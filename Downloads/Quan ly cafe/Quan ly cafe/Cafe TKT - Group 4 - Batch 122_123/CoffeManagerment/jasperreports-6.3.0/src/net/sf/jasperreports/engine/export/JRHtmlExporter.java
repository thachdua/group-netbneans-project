/*
 * JasperReports - Free Java Reporting Library.
 * Copyright (C) 2001 - 2016 TIBCO Software Inc. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of JasperReports.
 *
 * JasperReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JasperReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JasperReports. If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * Contributors:
 * Alex Parfenov - aparfeno@users.sourceforge.net
 * Adrian Jackson - iapetus@users.sourceforge.net
 * David Taylor - exodussystems@users.sourceforge.net
 * Lars Kristensen - llk@users.sourceforge.net
 */

package net.sf.jasperreports.engine.export;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.font.TextAttribute;
import java.awt.geom.Dimension2D;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.text.AttributedCharacterIterator;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.tools.codec.Base64Encoder;

import net.sf.jasperreports.crosstabs.JRCellContents;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.ImageMapRenderable;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRGenericPrintElement;
import net.sf.jasperreports.engine.JRLineBox;
import net.sf.jasperreports.engine.JRPen;
import net.sf.jasperreports.engine.JRPrintElement;
import net.sf.jasperreports.engine.JRPrintElementIndex;
import net.sf.jasperreports.engine.JRPrintEllipse;
import net.sf.jasperreports.engine.JRPrintFrame;
import net.sf.jasperreports.engine.JRPrintGraphicElement;
import net.sf.jasperreports.engine.JRPrintHyperlink;
import net.sf.jasperreports.engine.JRPrintHyperlinkParameter;
import net.sf.jasperreports.engine.JRPrintImage;
import net.sf.jasperreports.engine.JRPrintImageArea;
import net.sf.jasperreports.engine.JRPrintImageAreaHyperlink;
import net.sf.jasperreports.engine.JRPrintLine;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JRPrintRectangle;
import net.sf.jasperreports.engine.JRPrintText;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReportsContext;
import net.sf.jasperreports.engine.PrintPageFormat;
import net.sf.jasperreports.engine.base.JRBasePrintFrame;
import net.sf.jasperreports.engine.type.HyperlinkTypeEnum;
import net.sf.jasperreports.engine.type.LineDirectionEnum;
import net.sf.jasperreports.engine.type.LineSpacingEnum;
import net.sf.jasperreports.engine.type.LineStyleEnum;
import net.sf.jasperreports.engine.type.ModeEnum;
import net.sf.jasperreports.engine.type.RunDirectionEnum;
import net.sf.jasperreports.engine.type.ScaleImageEnum;
import net.sf.jasperreports.engine.util.JRColorUtil;
import net.sf.jasperreports.engine.util.JRImageLoader;
import net.sf.jasperreports.engine.util.JRStringUtil;
import net.sf.jasperreports.engine.util.JRStyledText;
import net.sf.jasperreports.engine.util.JRTextAttribute;
import net.sf.jasperreports.engine.util.JRTypeSniffer;
import net.sf.jasperreports.engine.util.Pair;
import net.sf.jasperreports.export.ExportInterruptedException;
import net.sf.jasperreports.export.ExporterInputItem;
import net.sf.jasperreports.export.HtmlReportConfiguration;
import net.sf.jasperreports.renderers.AreaHyperlinksRenderable;
import net.sf.jasperreports.renderers.DataRenderable;
import net.sf.jasperreports.renderers.DimensionRenderable;
import net.sf.jasperreports.renderers.Renderable;
import net.sf.jasperreports.renderers.RenderersCache;
import net.sf.jasperreports.renderers.ResourceRenderer;
import net.sf.jasperreports.renderers.util.RendererUtil;


/**
 * Exports a JasperReports document to HTML format. It has character output type and exports the document to a
 * grid-based layout.
 * 
 * @deprecated Replaced by {@link HtmlExporter}.
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 */
public class JRHtmlExporter extends AbstractHtmlExporter<JRHtmlReportConfiguration, JRHtmlExporterConfiguration>
{
	private static final Log log = LogFactory.getLog(JRHtmlExporter.class);

	/**
	 * @deprecated Replaced by {@link HtmlExporter#HTML_EXPORTER_PROPERTIES_PREFIX}.
	 */
	protected static final String HTML_EXPORTER_PROPERTIES_PREFIX = HtmlExporter.HTML_EXPORTER_PROPERTIES_PREFIX;

	/**
	 * @deprecated Replaced by {@link HtmlReportConfiguration#PROPERTY_IGNORE_HYPERLINK}.
	 */
	public static final String PROPERTY_IGNORE_HYPERLINK = HtmlReportConfiguration.PROPERTY_IGNORE_HYPERLINK;

	/**
	 * @deprecated Replaced by {@link HtmlExporter#HTML_EXPORTER_KEY}.
	 */
	public static final String HTML_EXPORTER_KEY = HtmlExporter.HTML_EXPORTER_KEY;
	
	/**
	 * @deprecated Replaced by {@link HtmlExporter#PROPERTY_HTML_CLASS}.
	 */
	public static final String PROPERTY_HTML_CLASS = HtmlExporter.PROPERTY_HTML_CLASS;

	/**
	 * @deprecated Replaced by {@link HtmlExporter#PROPERTY_HTML_ID}.
	 */
	public static final String PROPERTY_HTML_ID = HtmlExporter.PROPERTY_HTML_ID;

	/**
	 * @deprecated Replaced by {@link HtmlReportConfiguration#PROPERTY_ACCESSIBLE}.
	 */
	public static final String PROPERTY_ACCESSIBLE = HtmlReportConfiguration.PROPERTY_ACCESSIBLE;

	protected class ExporterContext extends BaseExporterContext implements JRHtmlExporterContext
	{
		@Override
		public String getExportPropertiesPrefix()
		{
			return HTML_EXPORTER_PROPERTIES_PREFIX;
		}

		@Override
		public String getHyperlinkURL(JRPrintHyperlink link)
		{
			return JRHtmlExporter.this.getHyperlinkURL(link);
		}
	}

	/**
	 *
	 */
	protected Writer writer;
	protected Map<String,String> rendererToImagePathMap;
	protected Map<Pair<String, Rectangle>,String> imageMaps;
	protected RenderersCache renderersCache;
	
	protected int reportIndex;
	protected int pageIndex;

	/**
	 *
	 */
	protected StringProvider emptyCellStringProvider;

	private LinkedList<Color> backcolorStack = new LinkedList<Color>();
	private Color backcolor;

	protected JRHyperlinkTargetProducerFactory targetProducerFactory;		

	protected boolean hyperlinkStarted;
	protected int thDepth;
	
	protected ExporterNature nature;

	/**
	 * @see #JRHtmlExporter(JasperReportsContext)
	 */
	public JRHtmlExporter()
	{
		this(DefaultJasperReportsContext.getInstance());
	}


	/**
	 *
	 */
	public JRHtmlExporter(JasperReportsContext jasperReportsContext)
	{
		super(jasperReportsContext);

		exporterContext = new ExporterContext();
	}


	@Override
	protected Class<JRHtmlExporterConfiguration> getConfigurationInterface()
	{
		return JRHtmlExporterConfiguration.class;
	}


	@Override
	protected Class<JRHtmlReportConfiguration> getItemConfigurationInterface()
	{
		return JRHtmlReportConfiguration.class;
	}
	

	@Override
	protected void ensureOutput()
	{
		if (exporterOutput == null)
		{
			exporterOutput = 
				new net.sf.jasperreports.export.parameters.ParametersHtmlExporterOutput(
					getJasperReportsContext(),
					getParameters(),
					getCurrentJasperPrint()
					);
		}
	}
	

	@Override
	protected void setJasperReportsContext(JasperReportsContext jasperReportsContext)
	{
		super.setJasperReportsContext(jasperReportsContext);
		
		targetProducerFactory = new DefaultHyperlinkTargetProducerFactory(jasperReportsContext);
	}

	
	@Override
	public void exportReport() throws JRException
	{
		/*   */
		ensureJasperReportsContext();
		ensureInput();
		
		initExport();
		
		ensureOutput();
		
		writer = getExporterOutput().getWriter();

		try
		{
			exportReportToWriter();
		}
		catch (IOException e)
		{
			throw 
				new JRException(
					EXCEPTION_MESSAGE_KEY_OUTPUT_WRITER_ERROR,
					new Object[]{jasperPrint.getName()}, 
					e);
		}
		finally
		{
			getExporterOutput().close();
			resetExportContext();
		}
	}


	@Override
	protected void initExport()
	{
		super.initExport();

		rendererToImagePathMap = new HashMap<String,String>();
		imageMaps = new HashMap<Pair<String, Rectangle>,String>();
		renderersCache = new RenderersCache(getJasperReportsContext());

		fontsToProcess = new HashMap<String, HtmlFontFamily>();

		if (getCurrentConfiguration().isUsingImagesToAlign())
		{
			emptyCellStringProvider =
				new StringProvider()
				{
					@Override
					public String getStringForCollapsedTD(int width, int height)
					{
						HtmlResourceHandler imageHandler = 
							getImageHandler() == null 
							? getExporterOutput().getImageHandler() 
							: getImageHandler();
						String pxUri = imageHandler == null ? null : imageHandler.getResourcePath("px");
						return "><img alt=\"\" src=\"" + pxUri + "\" style=\"width: " + toSizeUnit(width) + "; height: " + toSizeUnit(height) + ";\"/>";
					}

					@Override
					public String getStringForEmptyTD()
					{
						HtmlResourceHandler imageHandler = 
							getImageHandler() == null 
							? getExporterOutput().getImageHandler() 
							: getImageHandler();
						String pxUri = imageHandler == null ? null : imageHandler.getResourcePath("px");
						return "<img alt=\"\" src=\"" + pxUri + "\" border=\"0\"/>";
					}
					
					@Override
					public String getReportTableStyle()
					{
						return null;
					}
				};
		}
		else
		{
			emptyCellStringProvider =
				new StringProvider()
				{
					@Override
					public String getStringForCollapsedTD(int width, int height)
					{
						return " style=\"width: " + toSizeUnit(width) + "; height: " + toSizeUnit(height) + ";\">";
					}

					@Override
					public String getStringForEmptyTD()
					{
						return "";
					}
					
					@Override
					public String getReportTableStyle()
					{
						// required for lines and rectangles, but doesn't work in IE
						// border-collapse: collapse seems to take care of this though
						return "empty-cells: show";
					}
				};
		}
	}


	@Override
	protected void initReport()
	{
		super.initReport();

		JRHtmlReportConfiguration configuration = getCurrentItemConfiguration();
		
		nature = new JRHtmlExporterNature(
			jasperReportsContext, 
			filter, 
			!configuration.isFramesAsNestedTables(), 
			configuration.isIgnorePageMargins()
			);
	}
	

	/**
	 *
	 */
	protected void exportReportToWriter() throws JRException, IOException
	{
		JRHtmlExporterConfiguration configuration = getCurrentConfiguration();
		
		if (configuration.isUsingImagesToAlign())
		{
			loadPxImage();
		}

		String htmlHeader = configuration.getHtmlHeader();
		String betweenPagesHtml = configuration.getBetweenPagesHtml();
		String htmlFooter = configuration.getHtmlFooter();
		boolean flushOutput = configuration.isFlushOutput();
		
		if (htmlHeader == null)
		{
			String encoding = getExporterOutput().getEncoding();

			// no doctype because of bug 1430880
//			writer.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
//			writer.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
			writer.write("<html>\n");
			writer.write("<head>\n");
			writer.write("  <title></title>\n");
			writer.write("  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=" + encoding + "\"/>\n");
			writer.write("  <style type=\"text/css\">\n");
			writer.write("    a {text-decoration: none}\n");
			writer.write("  </style>\n");
			writer.write("</head>\n");
			writer.write("<body text=\"#000000\" link=\"#000000\" alink=\"#000000\" vlink=\"#000000\">\n");
			writer.write("<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n");
			writer.write("<tr><td width=\"50%\">&nbsp;</td><td align=\"center\">\n");
			writer.write("\n");
		}
		else
		{
			writer.write(htmlHeader);
		}

		List<ExporterInputItem> items = exporterInput.getItems();

		for(reportIndex = 0; reportIndex < items.size(); reportIndex++)
		{
			ExporterInputItem item = items.get(reportIndex);

			setCurrentExporterInputItem(item);
			
			List<JRPrintPage> pages = jasperPrint.getPages();
			if (pages != null && pages.size() > 0)
			{
				PageRange pageRange = getPageRange();
				int startPageIndex = (pageRange == null || pageRange.getStartPageIndex() == null) ? 0 : pageRange.getStartPageIndex();
				int endPageIndex = (pageRange == null || pageRange.getEndPageIndex() == null) ? (pages.size() - 1) : pageRange.getEndPageIndex();

				JRPrintPage page = null;
				for(pageIndex = startPageIndex; pageIndex <= endPageIndex; pageIndex++)
				{
					if (Thread.interrupted())
					{
						throw new ExportInterruptedException();
					}

					page = pages.get(pageIndex);

					writer.write("<a name=\"" + JR_PAGE_ANCHOR_PREFIX + reportIndex + "_" + (pageIndex + 1) + "\"></a>\n");

					/*   */
					exportPage(page);

					if (reportIndex < items.size() - 1 || pageIndex < endPageIndex)
					{
						if (betweenPagesHtml == null)
						{
							writer.write("<br/>\n<br/>\n");
						}
						else
						{
							writer.write(betweenPagesHtml);
						}
					}

					writer.write("\n");
				}
			}
		}

		if (fontsToProcess != null && fontsToProcess.size() > 0)// when no fontHandler and/or resourceHandler, fonts are not processed 
		{
			HtmlResourceHandler fontHandler = 
				getExporterOutput().getFontHandler() == null
				? getFontHandler()
				: getExporterOutput().getFontHandler();
			for (HtmlFontFamily htmlFontFamily : fontsToProcess.values())
			{
				writer.write("<link class=\"jrWebFont\" rel=\"stylesheet\" href=\"" + fontHandler.getResourcePath(htmlFontFamily.getId()) + "\">\n");
			}
		}
		
//		if (!isOutputResourcesToDir)
		{
			writer.write("<!--[if IE]>\n");
			writer.write("<script>\n");
			writer.write("var links = document.querySelectorAll('link.jrWebFont');\n");
			writer.write("setTimeout(function(){ if (links) { for (var i = 0; i < links.length; i++) { links.item(i).href = links.item(i).href; } } }, 0);\n");
			writer.write("</script>\n");
			writer.write("<![endif]-->\n");
		}

		if (htmlFooter == null)
		{
			writer.write("</td><td width=\"50%\">&nbsp;</td></tr>\n");
			writer.write("</table>\n");
			writer.write("</body>\n");
			writer.write("</html>\n");
		}
		else
		{
			writer.write(htmlFooter);
		}

		if (flushOutput)
		{
			writer.flush();
		}
	}


	/**
	 *
	 */
	protected void exportPage(JRPrintPage page) throws JRException, IOException
	{
		List<JRPrintElement> elements = null;
		
		JRHtmlReportConfiguration configuration = getCurrentItemConfiguration();

		if (configuration.isAccessibleHtml())
		{
			JRBasePrintFrame frame = new JRBasePrintFrame(jasperPrint.getDefaultStyleProvider());

			new JRHtmlExporterHelper(jasperPrint).createNestedFrames(page.getElements().listIterator(), frame);
			
			elements = frame.getElements();
		}
		else
		{
			elements = page.getElements();
		}
		
		PrintPageFormat pageFormat = jasperPrint.getPageFormat(pageIndex);
		
		JRGridLayout layout = 
			new JRGridLayout(
				nature,
				elements,
				pageFormat.getPageWidth(), 
				pageFormat.getPageHeight(),
				configuration.getOffsetX() == null ? 0 : configuration.getOffsetX(), 
				configuration.getOffsetY() == null ? 0 : configuration.getOffsetY(), 
				null //address
				);

		exportGrid(layout, configuration.isWhitePageBackground());

		JRExportProgressMonitor progressMonitor = configuration.getProgressMonitor();
		if (progressMonitor != null)
		{
			progressMonitor.afterPageExport();
		}
	}
	

	/**
	 *
	 */
	protected void exportGrid(JRGridLayout gridLayout, boolean whitePageBackground) throws IOException, JRException
	{
		CutsInfo xCuts = gridLayout.getXCuts();
		Grid grid = gridLayout.getGrid();

		String tableStyle = "width: " + toSizeUnit(gridLayout.getWidth()) + "; border-collapse: collapse";
		String additionalTableStyle = emptyCellStringProvider.getReportTableStyle();
		if (additionalTableStyle != null)
		{
			tableStyle += "; " + additionalTableStyle;
		}
		
		writer.write("<table style=\"" + tableStyle + "\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"");
		if (whitePageBackground)
		{
			writer.write(" bgcolor=\"white\"");
		}
		writer.write(">\n");

		if (whitePageBackground)
		{
			setBackcolor(Color.white);
		}

		writer.write("<tr>\n");
		int width = 0;
		for(int i = 1; i < xCuts.size(); i++)
		{
			width = xCuts.getCutOffset(i) - xCuts.getCutOffset(i - 1);
			writer.write("  <td" + emptyCellStringProvider.getStringForCollapsedTD(width, 1) + "</td>\n");
		}
		writer.write("</tr>\n");
		
		boolean isRemoveEmptySpaceBetweenRows = ((HtmlReportConfiguration)getCurrentItemConfiguration()).isRemoveEmptySpaceBetweenRows();

		CutsInfo yCuts = gridLayout.getYCuts();
		
		thDepth = 0;
		int rowCount = grid.getRowCount();
		for(int y = 0; y < rowCount; y++)
		{
			Cut yCut = yCuts.getCut(y);

			if (yCut.isCutSpanned() || !isRemoveEmptySpaceBetweenRows)
			{
				GridRow gridRow = grid.getRow(y);
				
				int rowHeight = JRGridLayout.getRowHeight(gridRow);
				
				boolean hasEmptyCell = hasEmptyCell(gridRow);
				
				writer.write("<tr valign=\"top\"");
				if (!hasEmptyCell)
				{
					writer.write(" style=\"height:" + toSizeUnit(rowHeight) + "\"");
				}
				writer.write(">\n");

				int rowSize = gridRow.size();
				for(int x = 0; x < rowSize; x++)
				{
					JRExporterGridCell gridCell = gridRow.get(x);
					if(gridCell.getType() == JRExporterGridCell.TYPE_EMPTY_CELL)
					{
						writeEmptyCell(gridCell, rowHeight);						
					}
					else
					{
						
						JRPrintElement element = gridCell.getElement();
						
						String thTag = null;

						if (
							element != null
							&& element.hasProperties()
							)
						{
							thTag = element.getPropertiesMap().getProperty(JRPdfExporterTagHelper.PROPERTY_TAG_TH);
						}
						
						if (thTag != null && (JRPdfExporterTagHelper.TAG_START.equals(thTag) || JRPdfExporterTagHelper.TAG_FULL.equals(thTag)))
						{
							thDepth++;
						}

						if (element instanceof JRPrintLine)
						{
							exportLine((JRPrintLine)element, gridCell);
						}
						else if (element instanceof JRPrintRectangle)
						{
							exportRectangle((JRPrintRectangle)element, gridCell);
						}
						else if (element instanceof JRPrintEllipse)
						{
							exportRectangle((JRPrintEllipse)element, gridCell);
						}
						else if (element instanceof JRPrintImage)
						{
							exportImage((JRPrintImage)element, gridCell);
						}
						else if (element instanceof JRPrintText)
						{
							exportText((JRPrintText)element, gridCell);
						}
						else if (element instanceof JRPrintFrame)
						{
							exportFrame((JRPrintFrame) element, gridCell);
						}
						else if (element instanceof JRGenericPrintElement)
						{
							exportGenericElement((JRGenericPrintElement) element, 
									gridCell, rowHeight);
						}

						if (thTag != null && (JRPdfExporterTagHelper.TAG_END.equals(thTag) || JRPdfExporterTagHelper.TAG_FULL.equals(thTag)))
						{
							thDepth--;
						}
					}

					x += gridCell.getColSpan() - 1;
				}

				writer.write("</tr>\n");
			}
		}

		if (whitePageBackground)
		{
			restoreBackcolor();
		}

		writer.write("</table>\n");
	}


	private boolean hasEmptyCell(GridRow gridRow)
	{
		if (gridRow.get(0).getType() == JRExporterGridCell.TYPE_EMPTY_CELL) // quick exit
		{
			return true;
		}
		
		boolean hasEmptyCell = false;
		int rowSize = gridRow.size();
		for(int x = 1; x < rowSize; x++)
		{
			if (gridRow.get(x).getType() == JRExporterGridCell.TYPE_EMPTY_CELL)
			{
				hasEmptyCell = true;
				break;
			}
		}

		return hasEmptyCell;
	}


	protected void writeEmptyCell(JRExporterGridCell cell, int rowHeight) throws IOException
	{
		String cellTag = getCellTag(cell);
		
		writer.write("  <" + cellTag);
		if (cell.getColSpan() > 1)
		{
			writer.write(" colspan=\"" + cell.getColSpan() + "\"");
		}

		StringBuilder styleBuilder = new StringBuilder();
		appendBackcolorStyle(cell, styleBuilder);
		appendBorderStyle(cell.getBox(), styleBuilder);

		if (styleBuilder.length() > 0)
		{
			writer.write(" style=\"");
			writer.write(styleBuilder.toString());
			writer.write("\"");
		}

		writer.write(emptyCellStringProvider.getStringForCollapsedTD(cell.getWidth(), rowHeight));
		writer.write("</" + cellTag + ">\n");
	}


	/**
	 *
	 */
	protected void exportLine(JRPrintLine line, JRExporterGridCell gridCell) throws IOException
	{
		writeCellStart(gridCell);

		StringBuilder styleBuilder = new StringBuilder();

		appendBackcolorStyle(gridCell, styleBuilder);
		
		String side = null;
		float ratio = line.getWidth() / line.getHeight();
		if (ratio > 1)
		{
			if (line.getDirectionValue() == LineDirectionEnum.TOP_DOWN)
			{
				side = "top";
			}
			else
			{
				side = "bottom";
			}
		}
		else
		{
			if (line.getDirectionValue() == LineDirectionEnum.TOP_DOWN)
			{
				side = "left";
			}
			else
			{
				side = "right";
			}
		}

		appendPen(
			styleBuilder,
			line.getLinePen(),
			side
			);

		if (styleBuilder.length() > 0)
		{
			writer.write(" style=\"");
			writer.write(styleBuilder.toString());
			writer.write("\"");
		}

		writer.write(">");

		writer.write(emptyCellStringProvider.getStringForEmptyTD());

		writeCellEnd(gridCell);
	}


	/**
	 *
	 */
	protected void writeCellStart(JRExporterGridCell gridCell) throws IOException
	{
		writer.write("  <" + getCellTag(gridCell));
		if (gridCell.getColSpan() > 1)
		{
			writer.write(" colspan=\"" + gridCell.getColSpan() +"\"");
		}
		if (gridCell.getRowSpan() > 1)
		{
			writer.write(" rowspan=\"" + gridCell.getRowSpan() + "\"");
		}
		JRPrintElement element = gridCell.getElement();
		if (element != null)
		{
			String id = getPropertiesUtil().getProperty(element, PROPERTY_HTML_ID);
			if (id != null)
			{
				writer.write(" id=\"" + id +"\"");
			}
			String clazz = getPropertiesUtil().getProperty(element, PROPERTY_HTML_CLASS);
			if (clazz != null)
			{
				writer.write(" class=\"" + clazz +"\"");
			}
		}
	}


	/**
	 *
	 */
	protected void writeCellEnd(JRExporterGridCell gridCell) throws IOException
	{
		writer.write("</" + getCellTag(gridCell) + ">\n");
	}


	/**
	 *
	 */
	protected String getCellTag(JRExporterGridCell gridCell)
	{
		boolean accessibleHtml = ((HtmlReportConfiguration)getCurrentItemConfiguration()).isAccessibleHtml();
		if (accessibleHtml)
		{
			if (thDepth > 0)
			{
				return "th"; //FIXMEHTML th tags have center alignment by default
			}
			else
			{
				String cellContentsType = gridCell.getProperty(JRCellContents.PROPERTY_TYPE);
				if (
					JRCellContents.TYPE_CROSSTAB_HEADER.equals(cellContentsType)
					|| JRCellContents.TYPE_COLUMN_HEADER.equals(cellContentsType)
					|| JRCellContents.TYPE_ROW_HEADER.equals(cellContentsType)
					)
				{
					return "th";
				}
			}
		}
		
		return "td";
	}


	/**
	 *
	 */
	protected void exportRectangle(JRPrintGraphicElement element, JRExporterGridCell gridCell) throws IOException
	{
		writeCellStart(gridCell);

		StringBuilder styleBuilder = new StringBuilder();

		appendBackcolorStyle(gridCell, styleBuilder);
		
		appendPen(
			styleBuilder,
			element.getLinePen(),
			null
			);

		if (styleBuilder.length() > 0)
		{
			writer.write(" style=\"");
			writer.write(styleBuilder.toString());
			writer.write("\"");
		}

		writer.write(">");

		writer.write(emptyCellStringProvider.getStringForEmptyTD());

		writeCellEnd(gridCell);
	}


	/**
	 *
	 */
	protected void exportStyledText(JRPrintText printText, JRStyledText styledText, String tooltip) throws IOException
	{
		Locale locale = getTextLocale(printText);
		LineSpacingEnum lineSpacing = printText.getParagraph().getLineSpacing();
		Float lineSpacingSize = printText.getParagraph().getLineSpacingSize();
		float lineSpacingFactor = printText.getLineSpacingFactor();
		Color backcolor = printText.getBackcolor();
		
		String text = styledText.getText();

		int runLimit = 0;

		AttributedCharacterIterator iterator = styledText.getAttributedString().getIterator();

		boolean first = true;
		boolean startedSpan = false;
		while(runLimit < styledText.length() && (runLimit = iterator.getRunLimit()) <= styledText.length())
		{
			//if there are several text runs, write the tooltip into a parent <span>
			if (first && runLimit < styledText.length() && tooltip != null)
			{
				startedSpan = true;
				writer.write("<span title=\"");
				writer.write(JRStringUtil.xmlEncode(tooltip));
				writer.write("\">");
				//reset the tooltip so that inner <span>s to not use it
				tooltip = null;
			}
			first = false;
			
			exportStyledTextRun(
				iterator.getAttributes(), 
				text.substring(iterator.getIndex(), runLimit),
				tooltip,
				locale,
				lineSpacing,
				lineSpacingSize,
				lineSpacingFactor,
				backcolor
				);

			iterator.setIndex(runLimit);
		}
		
		if (startedSpan)
		{
			writer.write("</span>");
		}
	}


	/**
	 *
	 */
	protected void exportStyledTextRun(
		Map<Attribute,Object> attributes, 
		String text,
		String tooltip,
		Locale locale,
		LineSpacingEnum lineSpacing,
		Float lineSpacingSize,
		float lineSpacingFactor,
		Color backcolor
		) throws IOException
	{
		boolean localHyperlink = false;
		JRPrintHyperlink hyperlink = (JRPrintHyperlink)attributes.get(JRTextAttribute.HYPERLINK);
		if (!hyperlinkStarted && hyperlink != null)
		{
			startHyperlink(hyperlink);
			localHyperlink = true;
		}
		
		boolean isBold = TextAttribute.WEIGHT_BOLD.equals(attributes.get(TextAttribute.WEIGHT));
		boolean isItalic = TextAttribute.POSTURE_OBLIQUE.equals(attributes.get(TextAttribute.POSTURE));

		String fontFamily = resolveFontFamily(attributes, locale);

		// do not put single quotes around family name here because the value might already contain quotes, 
		// especially if it is coming from font extension export configuration
		writer.write("<span style=\"font-family: ");
		writer.write(fontFamily);
		writer.write("; ");

		Color forecolor = (Color)attributes.get(TextAttribute.FOREGROUND);
		if (!hyperlinkStarted || !Color.black.equals(forecolor))
		{
			writer.write("color: ");
			writer.write(JRColorUtil.getCssColor(forecolor));
			writer.write("; ");
		}

		Color runBackcolor = (Color)attributes.get(TextAttribute.BACKGROUND);
		if (runBackcolor != null && !runBackcolor.equals(backcolor))
		{
			writer.write("background-color: ");
			writer.write(JRColorUtil.getCssColor(runBackcolor));
			writer.write("; ");
		}

		writer.write("font-size: ");
		writer.write(toSizeUnit((Float)attributes.get(TextAttribute.SIZE)));
		writer.write(";");
		
		switch (lineSpacing)
		{
			case SINGLE:
			default:
			{
				if (lineSpacingFactor == 0)
				{
					writer.write(" line-height: 1; *line-height: normal;");
				}
				else
				{
					writer.write(" line-height: " + lineSpacingFactor + ";");
				}
				break;
			}
			case ONE_AND_HALF:
			{
				if (lineSpacingFactor == 0)
				{
					writer.write(" line-height: 1.5;");
				}
				else
				{
					writer.write(" line-height: " + lineSpacingFactor + ";");
				}
				break;
			}
			case DOUBLE:
			{
				if (lineSpacingFactor == 0)
				{
					writer.write(" line-height: 2.0;");
				}
				else
				{
					writer.write(" line-height: " + lineSpacingFactor + ";");
				}
				break;
			}
			case PROPORTIONAL:
			{
				if (lineSpacingSize != null) {
					writer.write(" line-height: " + lineSpacingSize.floatValue() + ";");
				}
				break;
			}
			case AT_LEAST:
			case FIXED:
			{
				if (lineSpacingSize != null) {
					writer.write(" line-height: " + lineSpacingSize.floatValue() + "px;");
				}
				break;
			}
		}

		/*
		if (!horizontalAlignment.equals(CSS_TEXT_ALIGN_LEFT))
		{
			writer.write(" text-align: ");
			writer.write(horizontalAlignment);
			writer.write(";");
		}
		*/

		if (isBold)
		{
			writer.write(" font-weight: bold;");
		}
		if (isItalic)
		{
			writer.write(" font-style: italic;");
		}
		if (TextAttribute.UNDERLINE_ON.equals(attributes.get(TextAttribute.UNDERLINE)))
		{
			writer.write(" text-decoration: underline;");
		}
		if (TextAttribute.STRIKETHROUGH_ON.equals(attributes.get(TextAttribute.STRIKETHROUGH)))
		{
			writer.write(" text-decoration: line-through;");
		}

		if (TextAttribute.SUPERSCRIPT_SUPER.equals(attributes.get(TextAttribute.SUPERSCRIPT)))
		{
			writer.write(" vertical-align: super;");
		}
		else if (TextAttribute.SUPERSCRIPT_SUB.equals(attributes.get(TextAttribute.SUPERSCRIPT)))
		{
			writer.write(" vertical-align: sub;");
		}
		
		writer.write("\"");

		if (tooltip != null)
		{
			writer.write(" title=\"");
			writer.write(JRStringUtil.xmlEncode(tooltip));
			writer.write("\"");
		}
		
		writer.write(">");

		writer.write(
			JRStringUtil.htmlEncode(text)
			);

		writer.write("</span>");
		
		if (localHyperlink)
		{
			endHyperlink();
		}
	}


	/**
	 *
	 */
	protected void exportText(JRPrintText text, JRExporterGridCell gridCell) throws IOException
	{
		JRStyledText styledText = getStyledText(text);

		int textLength = 0;

		if (styledText != null)
		{
			textLength = styledText.length();
		}

		writeCellStart(gridCell);//FIXME why dealing with cell style if no text to print (textLength == 0)?

		if (text.getRunDirectionValue() == RunDirectionEnum.RTL)
		{
			writer.write(" dir=\"rtl\"");
		}

		StringBuilder styleBuilder = new StringBuilder();

		String verticalAlignment = HTML_VERTICAL_ALIGN_TOP;

		switch (text.getVerticalTextAlign())
		{
			case BOTTOM :
			{
				verticalAlignment = HTML_VERTICAL_ALIGN_BOTTOM;
				break;
			}
			case MIDDLE :
			{
				verticalAlignment = HTML_VERTICAL_ALIGN_MIDDLE;
				break;
			}
			case TOP :
			case JUSTIFIED :
			default :
			{
				verticalAlignment = HTML_VERTICAL_ALIGN_TOP;
			}
		}

		if (!verticalAlignment.equals(HTML_VERTICAL_ALIGN_TOP))
		{
			styleBuilder.append(" vertical-align: ");
			styleBuilder.append(verticalAlignment);
			styleBuilder.append(";");
		}

		appendBackcolorStyle(gridCell, styleBuilder);
		appendBorderStyle(gridCell.getBox(), styleBuilder);
		appendPaddingStyle(text.getLineBox(), styleBuilder);

		String horizontalAlignment = CSS_TEXT_ALIGN_LEFT;

		if (textLength > 0)
		{
			switch (text.getHorizontalTextAlign())
			{
				case RIGHT :
				{
					horizontalAlignment = CSS_TEXT_ALIGN_RIGHT;
					break;
				}
				case CENTER :
				{
					horizontalAlignment = CSS_TEXT_ALIGN_CENTER;
					break;
				}
				case JUSTIFIED :
				{
					horizontalAlignment = CSS_TEXT_ALIGN_JUSTIFY;
					break;
				}
				case LEFT :
				default :
				{
					horizontalAlignment = CSS_TEXT_ALIGN_LEFT;
				}
			}

			if (
				(text.getRunDirectionValue() == RunDirectionEnum.LTR
				 && !horizontalAlignment.equals(CSS_TEXT_ALIGN_LEFT))
				|| (text.getRunDirectionValue() == RunDirectionEnum.RTL
					&& !horizontalAlignment.equals(CSS_TEXT_ALIGN_RIGHT))
				)
			{
				styleBuilder.append("text-align: ");
				styleBuilder.append(horizontalAlignment);
				styleBuilder.append(";");
			}
		}

		boolean isWrapBreakWord = ((HtmlReportConfiguration)getCurrentItemConfiguration()).isWrapBreakWord();
		
		if (isWrapBreakWord)
		{
			styleBuilder.append("width: " + toSizeUnit(gridCell.getWidth()) + "; ");
			styleBuilder.append("word-wrap: break-word; ");
		}
		
		if (text.getLineBreakOffsets() != null)
		{
			//if we have line breaks saved in the text, set nowrap so that
			//the text only wraps at the explicit positions
			styleBuilder.append("white-space: nowrap; ");
		}
		
		if (styleBuilder.length() > 0)
		{
			writer.write(" style=\"");
			writer.write(styleBuilder.toString());
			writer.write("\"");
		}
		
		writer.write(">");
		writer.write("<p style=\"overflow: hidden; ");

		writer.write("text-indent: " + text.getParagraph().getFirstLineIndent().intValue() + "px; ");
//		writer.write("margin-left: " + text.getParagraph().getLeftIndent().intValue() + "px; ");
//		writer.write("margin-right: " + text.getParagraph().getRightIndent().intValue() + "px; ");
//		writer.write("margin-top: " + text.getParagraph().getSpacingBefore().intValue() + "px; ");
//		writer.write("margin-bottom: " + text.getParagraph().getSpacingAfter().intValue() + "px; ");
		writer.write("\">");

		if (text.getAnchorName() != null)
		{
			writer.write("<a name=\"");
			writer.write(text.getAnchorName());
			writer.write("\"/>");
		}

		startHyperlink(text);

		if (textLength > 0)
		{
			//only use text tooltip when no hyperlink present
//			String textTooltip = hyperlinkStarted ? null : text.getHyperlinkTooltip();
			exportStyledText(text, styledText, text.getHyperlinkTooltip());
		}
		else
		{
			writer.write(emptyCellStringProvider.getStringForEmptyTD());
		}

		endHyperlink();

		writer.write("</p>");

		writeCellEnd(gridCell);
	}


	protected boolean startHyperlink(JRPrintHyperlink link) throws IOException
	{
		String href = getHyperlinkURL(link);

		if (href != null)
		{
			writer.write("<a href=\"");
			writer.write(href);
			writer.write("\"");

			String target = getHyperlinkTarget(link);
			if (target != null)
			{
				writer.write(" target=\"");
				writer.write(target);
				writer.write("\"");
			}

			if (link.getHyperlinkTooltip() != null)
			{
				writer.write(" title=\"");
				writer.write(JRStringUtil.xmlEncode(link.getHyperlinkTooltip()));
				writer.write("\"");
			}
			
			writer.write(">");
		}
		
		hyperlinkStarted = href != null;
		
		return hyperlinkStarted;
	}


	protected String getHyperlinkTarget(JRPrintHyperlink link)
	{
		String target = null;
		JRHyperlinkTargetProducer producer = targetProducerFactory.getHyperlinkTargetProducer(link.getLinkTarget());		
		if (producer == null)
		{
			switch(link.getHyperlinkTargetValue())
			{
				case BLANK :
				{
					target = "_blank";//FIXME make reverse for html markup hyperlinks
					break;
				}
				case PARENT :
				{
					target = "_parent";
					break;
				}
				case TOP :
				{
					target = "_top";
					break;
				}
				case CUSTOM :
				{
					boolean paramFound = false;
					List<JRPrintHyperlinkParameter> parameters = link.getHyperlinkParameters() == null ? null : link.getHyperlinkParameters().getParameters();
					if (parameters != null)
					{
						for(Iterator<JRPrintHyperlinkParameter> it = parameters.iterator(); it.hasNext();)
						{
							JRPrintHyperlinkParameter parameter = it.next();
							if (link.getLinkTarget().equals(parameter.getName()))
							{
								target = parameter.getValue() == null ? null : parameter.getValue().toString();
								paramFound = true;
								break;
							}
						}
					}
					if (!paramFound)
					{
						target = link.getLinkTarget();
					}
					break;
				}
				case SELF :
				default :
				{
				}
			}
		}
		else
		{
			target = producer.getHyperlinkTarget(link);
		}

		return target;
	}


	protected String getHyperlinkURL(JRPrintHyperlink link)
	{
		String href = null;
		
		Boolean ignoreHyperlink = HyperlinkUtil.getIgnoreHyperlink(PROPERTY_IGNORE_HYPERLINK, link);
		if (ignoreHyperlink == null)
		{
			ignoreHyperlink = getPropertiesUtil().getBooleanProperty(jasperPrint, PROPERTY_IGNORE_HYPERLINK, false);
		}

		if (!ignoreHyperlink)
		{
			JRHyperlinkProducer customHandler = getHyperlinkProducer(link);		
			if (customHandler == null)
			{
				switch(link.getHyperlinkTypeValue())
				{
					case REFERENCE :
					{
						if (link.getHyperlinkReference() != null)
						{
							href = link.getHyperlinkReference();
						}
						break;
					}
					case LOCAL_ANCHOR :
					{
						if (link.getHyperlinkAnchor() != null)
						{
							href = "#" + link.getHyperlinkAnchor();
						}
						break;
					}
					case LOCAL_PAGE :
					{
						if (link.getHyperlinkPage() != null)
						{
							href = "#" + JR_PAGE_ANCHOR_PREFIX + reportIndex + "_" + link.getHyperlinkPage().toString();
						}
						break;
					}
					case REMOTE_ANCHOR :
					{
						if (
							link.getHyperlinkReference() != null &&
							link.getHyperlinkAnchor() != null
							)
						{
							href = link.getHyperlinkReference() + "#" + link.getHyperlinkAnchor();
						}
						break;
					}
					case REMOTE_PAGE :
					{
						if (
							link.getHyperlinkReference() != null &&
							link.getHyperlinkPage() != null
							)
						{
							href = link.getHyperlinkReference() + "#" + JR_PAGE_ANCHOR_PREFIX + "0_" + link.getHyperlinkPage().toString();
						}
						break;
					}
					case NONE :
					default :
					{
						break;
					}
				}
			}
			else
			{
				href = customHandler.getHyperlink(link);
			}
		}
		
		return href;
	}


	protected void endHyperlink() throws IOException
	{
		if (hyperlinkStarted)
		{
			writer.write("</a>");
		}
		hyperlinkStarted = false;
	}


	protected boolean appendBorderStyle(JRLineBox box, StringBuilder styleBuilder)
	{
		boolean addedToStyle = false;

		if (box != null)
		{
			LineStyleEnum tps = box.getTopPen().getLineStyleValue();
			LineStyleEnum lps = box.getLeftPen().getLineStyleValue();
			LineStyleEnum bps = box.getBottomPen().getLineStyleValue();
			LineStyleEnum rps = box.getRightPen().getLineStyleValue();
			
			float tpw = box.getTopPen().getLineWidth().floatValue();
			float lpw = box.getLeftPen().getLineWidth().floatValue();
			float bpw = box.getBottomPen().getLineWidth().floatValue();
			float rpw = box.getRightPen().getLineWidth().floatValue();
			
			if (0f < tpw && tpw < 1f) {
				tpw = 1f;
			}
			if (0f < lpw && lpw < 1f) {
				lpw = 1f;
			}
			if (0f < bpw && bpw < 1f) {
				bpw = 1f;
			}
			if (0f < rpw && rpw < 1f) {
				rpw = 1f;
			}
			
			Color tpc = box.getTopPen().getLineColor();
			
			// try to compact all borders into one css property
			if (tps == lps &&												// same line style
					tps == bps &&
					tps == rps &&
					tpw == lpw &&											// same line width
					tpw == bpw &&
					tpw == rpw &&
					tpc.equals(box.getLeftPen().getLineColor()) &&			// same line color
					tpc.equals(box.getBottomPen().getLineColor()) &&
					tpc.equals(box.getRightPen().getLineColor())) 
			{
				addedToStyle |= appendPen(
						styleBuilder,
						box.getTopPen(),
						null
						);
			} else {
				addedToStyle |= appendPen(
					styleBuilder,
					box.getTopPen(),
					"top"
					);
				addedToStyle |= appendPen(
					styleBuilder,
					box.getLeftPen(),
					"left"
					);
				addedToStyle |= appendPen(
					styleBuilder,
					box.getBottomPen(),
					"bottom"
					);
				addedToStyle |= appendPen(
					styleBuilder,
					box.getRightPen(),
					"right"
					);
			}
		}
		
		return addedToStyle;
	}


	protected boolean appendPaddingStyle(JRLineBox box, StringBuilder styleBuilder)
	{
		boolean addedToStyle = false;
		
		if (box != null)
		{
			Integer tp = box.getTopPadding();
			Integer lp = box.getLeftPadding();
			Integer bp = box.getBottomPadding();
			Integer rp = box.getRightPadding();
			
			// try to compact all paddings into one css property
			if (tp == lp && tp == bp && tp == rp)
			{
				addedToStyle |= appendPadding(
						styleBuilder,
						tp,
						null
						);
			} else 
			{
				addedToStyle |= appendPadding(
						styleBuilder,
						box.getTopPadding(),
						"top"
						);
				addedToStyle |= appendPadding(
						styleBuilder,
						box.getLeftPadding(),
						"left"
						);
				addedToStyle |= appendPadding(
						styleBuilder,
						box.getBottomPadding(),
						"bottom"
						);
				addedToStyle |= appendPadding(
						styleBuilder,
						box.getRightPadding(),
						"right"
						);
			}
		}
		
		return addedToStyle;
	}


	protected Color appendBackcolorStyle(JRExporterGridCell gridCell, StringBuilder styleBuilder)
	{
		Color cellBackcolor = gridCell.getCellBackcolor();
		if (cellBackcolor != null && (backcolor == null || cellBackcolor.getRGB() != backcolor.getRGB()))
		{
			styleBuilder.append("background-color: ");
			styleBuilder.append(JRColorUtil.getCssColor(cellBackcolor));
			styleBuilder.append("; ");

			return cellBackcolor;
		}

		return null;
	}


	/**
	 *
	 */
	protected void exportImage(JRPrintImage image, JRExporterGridCell gridCell) throws JRException, IOException
	{
		writeCellStart(gridCell);

		StringBuilder styleBuilder = new StringBuilder();

		String horizontalAlignment = CSS_TEXT_ALIGN_LEFT;

		switch (image.getHorizontalImageAlign())
		{
			case RIGHT :
			{
				horizontalAlignment = CSS_TEXT_ALIGN_RIGHT;
				break;
			}
			case CENTER :
			{
				horizontalAlignment = CSS_TEXT_ALIGN_CENTER;
				break;
			}
			case LEFT :
			default :
			{
				horizontalAlignment = CSS_TEXT_ALIGN_LEFT;
			}
		}

		if (!horizontalAlignment.equals(CSS_TEXT_ALIGN_LEFT))
		{
			styleBuilder.append("text-align: ");
			styleBuilder.append(horizontalAlignment);
			styleBuilder.append(";");
		}

		String verticalAlignment = HTML_VERTICAL_ALIGN_TOP;

		switch (image.getVerticalImageAlign())
		{
			case BOTTOM :
			{
				verticalAlignment = HTML_VERTICAL_ALIGN_BOTTOM;
				break;
			}
			case MIDDLE :
			{
				verticalAlignment = HTML_VERTICAL_ALIGN_MIDDLE;
				break;
			}
			case TOP :
			default :
			{
				verticalAlignment = HTML_VERTICAL_ALIGN_TOP;
			}
		}

		if (!verticalAlignment.equals(HTML_VERTICAL_ALIGN_TOP))
		{
			styleBuilder.append(" vertical-align: ");
			styleBuilder.append(verticalAlignment);
			styleBuilder.append(";");
		}

		appendBackcolorStyle(gridCell, styleBuilder);
		
		boolean addedToStyle = appendBorderStyle(gridCell.getBox(), styleBuilder);
		if (!addedToStyle)
		{
			appendPen(
				styleBuilder,
				image.getLinePen(),
				null
				);
		}

		appendPaddingStyle(image.getLineBox(), styleBuilder);

		if (styleBuilder.length() > 0)
		{
			writer.write(" style=\"");
			writer.write(styleBuilder.toString());
			writer.write("\"");
		}

		writer.write(">");

		if (image.getAnchorName() != null)
		{
			writer.write("<a name=\"");
			writer.write(image.getAnchorName());
			writer.write("\"/>");
		}
		
		Renderable renderer = image.getRenderer();

		boolean isLazy = RendererUtil.isLazy(renderer);
		
		boolean isUsingImagesToAlign = getCurrentConfiguration().isUsingImagesToAlign();
		if (renderer != null || isUsingImagesToAlign)
		{
			boolean hasAreaHyperlinks =  
				renderer instanceof ImageMapRenderable
				&& ((ImageMapRenderable) renderer).hasImageAreaHyperlinks();

			boolean hasHyperlinks = false;

			if (hasAreaHyperlinks)
			{
				hasHyperlinks = true;
				hyperlinkStarted = false;
			}
			else
			{
				hasHyperlinks = startHyperlink(image);
			}
			
			writer.write("<img");
			String imagePath = null;
			String imageMapName = null;
			List<JRPrintImageAreaHyperlink> imageMapAreas = null;
	
			int availableImageWidth = image.getWidth() - image.getLineBox().getLeftPadding().intValue() - image.getLineBox().getRightPadding().intValue();
			if (availableImageWidth < 0)
			{
				availableImageWidth = 0;
			}
		
			int availableImageHeight = image.getHeight() - image.getLineBox().getTopPadding().intValue() - image.getLineBox().getBottomPadding().intValue();
			if (availableImageHeight < 0)
			{
				availableImageHeight = 0;
			}
		
			ScaleImageEnum scaleImage = image.getScaleImageValue();
			
			if (renderer != null)
			{
				if (isLazy)
				{
					// we do not cache imagePath for lazy images because the short location string is already cached inside the render itself
					imagePath = RendererUtil.getResourceLocation(renderer);
				}
				else
				{
					if (renderer instanceof ResourceRenderer)
					{
						renderer = renderersCache.getLoadedRenderer((ResourceRenderer)renderer);
					}

					boolean isEmbedImage = isEmbedImage(image);
					
					if (
						!isEmbedImage //we do not cache imagePath for embedded images because it is too big
						&& renderer instanceof DataRenderable //we do not cache imagePath for non-data renderers because they render width different width/height each time
						&& rendererToImagePathMap.containsKey(renderer.getId())
						)
					{
						imagePath = rendererToImagePathMap.get(renderer.getId());
					}
					else
					{
						if (isEmbedImage)
						{
							DataRenderable dataRenderer = 
								getRendererUtil().getDataRenderable(
									renderer,
									new Dimension(availableImageWidth, availableImageHeight),
									ModeEnum.OPAQUE == image.getModeValue() ? image.getBackcolor() : null
									);

							byte[] imageData = dataRenderer.getData(jasperReportsContext);

							String imageMimeType = 
								getRendererUtil().isSvgData(imageData)
								? "image/svg+xml"
								: JRTypeSniffer.getImageTypeValue(imageData).getMimeType();
							
							ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
							ByteArrayOutputStream baos = new ByteArrayOutputStream();
							
							Base64Encoder encoder = new Base64Encoder(bais, baos);
							encoder.process();
							
							imagePath = "data:" + imageMimeType + ";base64," + new String(baos.toByteArray(), "UTF-8"); // UTF-8 is fine as we just need an ASCII compatible encoding for the Base64 array
							//don't cache the base64 encoded image as imagePath because they are too big
						}
						else
						{
							HtmlResourceHandler imageHandler = 
								getImageHandler() == null 
								? getExporterOutput().getImageHandler() 
								: getImageHandler();
							if (imageHandler != null)
							{
								DataRenderable dataRenderer = 
									getRendererUtil().getDataRenderable(
										renderer,
										new Dimension(availableImageWidth, availableImageHeight),
										ModeEnum.OPAQUE == image.getModeValue() ? image.getBackcolor() : null
										);

								byte[] imageData = dataRenderer.getData(jasperReportsContext);

								String fileExtension = 
									getRendererUtil().isSvgData(imageData)
									? RendererUtil.SVG_FILE_EXTENSION
									: JRTypeSniffer.getImageTypeValue(imageData).getFileExtension();

								String imageName = getImageName(getElementIndex(gridCell), fileExtension);

								imageHandler.handleResource(imageName, imageData);

								imagePath = imageHandler.getResourcePath(imageName);

								if (dataRenderer == renderer)
								{
									//cache imagePath only for true ImageRenderable instances because the wrapping ones render with different width/height each time
									rendererToImagePathMap.put(renderer.getId(), imagePath);
								}
							}
							//does not make sense to cache null imagePath, in the absence of an image handler
						}
					}
					
					if (hasAreaHyperlinks)
					{
						Rectangle renderingArea = new Rectangle(image.getWidth(), image.getHeight());
						
						if (renderer instanceof DataRenderable)
						{
							imageMapName = imageMaps.get(new Pair<String, Rectangle>(renderer.getId(), renderingArea));
						}
		
						if (imageMapName == null)
						{
							Renderable originalRenderer = image.getRenderer();
							imageMapName = "map_" + getElementIndex(gridCell).toString();
							imageMapAreas = ((AreaHyperlinksRenderable) originalRenderer).getImageAreaHyperlinks(renderingArea);//FIXMECHART
							
							if (renderer instanceof DataRenderable)
							{
								imageMaps.put(new Pair<String, Rectangle>(renderer.getId(), renderingArea), imageMapName);
							}
						}
					}
				}
			}
			else 		// ie: 	if(isUsingImagesToAlign)
			{
				HtmlResourceHandler imageHandler = getExporterOutput().getImageHandler();
				imagePath = imageHandler == null ? null : imageHandler.getResourcePath("px");
				scaleImage = ScaleImageEnum.FILL_FRAME;
			}
	
			writer.write(" src=\"");
			if (imagePath != null)
			{
				writer.write(imagePath);
			}
			writer.write("\"");
		
			switch (scaleImage)
			{
				case FILL_FRAME :
				{
					writer.write(" style=\"width: ");
					writer.write(toSizeUnit(availableImageWidth));
					writer.write("; height: ");
					writer.write(toSizeUnit(availableImageHeight));
					writer.write("\"");
		
					break;
				}
				case CLIP : //FIXMEIMAGE image clip could be achieved by cutting the image and preserving the image type
				case RETAIN_SHAPE :
				default :
				{
					double normalWidth = availableImageWidth;
					double normalHeight = availableImageHeight;
		
					if (!isLazy)
					{
						// Image load might fail. 
						Renderable tmpRenderer = 
							net.sf.jasperreports.engine.RenderableUtil.getInstance(jasperReportsContext).getOnErrorRendererForDimension(
								renderersCache,
								renderer, 
								image.getOnErrorTypeValue()
								);
						if (tmpRenderer instanceof DimensionRenderable)
						{
							Dimension2D dimension = ((DimensionRenderable)tmpRenderer).getDimension(jasperReportsContext);
							if (dimension != null)
							{
								normalWidth = dimension.getWidth();
								normalHeight = dimension.getHeight();
							}
						}
					}
		
					if (availableImageHeight > 0)
					{
						double ratio = normalWidth / normalHeight;
		
						if( ratio > (double)availableImageWidth / (double)availableImageHeight )
						{
							writer.write(" style=\"width: ");
							writer.write(toSizeUnit(availableImageWidth));
							writer.write("\"");
						}
						else
						{
							writer.write(" style=\"height: ");
							writer.write(toSizeUnit(availableImageHeight));
							writer.write("\"");
						}
					}
				}
			}
			
			if (imageMapName != null)
			{
				writer.write(" usemap=\"#" + imageMapName + "\"");
			}
			
			writer.write(" alt=\"\"");
			
			if (hasHyperlinks)
			{
				writer.write(" border=\"0\"");
			}
			
			if (image.getHyperlinkTooltip() != null)
			{
				writer.write(" title=\"");
				writer.write(JRStringUtil.xmlEncode(image.getHyperlinkTooltip()));
				writer.write("\"");
			}
			
			writer.write("/>");

			endHyperlink();
			
			if (imageMapAreas != null)
			{
				writer.write("\n");
				writeImageMap(imageMapName, image, imageMapAreas);
			}
		}
		writeCellEnd(gridCell);
	}


	protected JRPrintElementIndex getElementIndex(JRExporterGridCell gridCell)
	{
		JRPrintElementIndex imageIndex =
			new JRPrintElementIndex(
					reportIndex,
					pageIndex,
					gridCell.getElementAddress()
					);
		return imageIndex;
	}


	protected void writeImageMap(String imageMapName, JRPrintImage image, List<JRPrintImageAreaHyperlink> imageMapAreas) throws IOException
	{
		writer.write("<map name=\"" + imageMapName + "\">\n");

		for (ListIterator<JRPrintImageAreaHyperlink> it = imageMapAreas.listIterator(imageMapAreas.size()); it.hasPrevious();)
		{
			JRPrintImageAreaHyperlink areaHyperlink = it.previous();
			JRPrintImageArea area = areaHyperlink.getArea();

			writer.write("  <area shape=\"" + JRPrintImageArea.getHtmlShape(area.getShape()) + "\"");
			writeImageAreaCoordinates(area.getCoordinates());			
			writeImageAreaHyperlink(areaHyperlink.getHyperlink());
			writer.write("/>\n");
		}
		
		if (image.getHyperlinkTypeValue() != HyperlinkTypeEnum.NONE)
		{
			writer.write("  <area shape=\"default\"");
			writeImageAreaCoordinates(new int[]{0, 0, image.getWidth(), image.getHeight()});//for IE
			writeImageAreaHyperlink(image);
			writer.write("/>\n");
		}
		
		writer.write("</map>\n");
	}

	
	protected void writeImageAreaCoordinates(int[] coords) throws IOException
	{
		if (coords != null && coords.length > 0)
		{
			StringBuilder coordsEnum = new StringBuilder(coords.length * 4);
			coordsEnum.append(toZoom(coords[0]));
			for (int i = 1; i < coords.length; i++)
			{
				coordsEnum.append(',');
				coordsEnum.append(toZoom(coords[i]));
			}
			writer.write(" coords=\"" + coordsEnum + "\"");
		}		
	}


	protected void writeImageAreaHyperlink(JRPrintHyperlink hyperlink) throws IOException
	{
		String href = getHyperlinkURL(hyperlink);
		if (href == null)
		{
			writer.write(" nohref=\"nohref\"");
		}
		else
		{
			writer.write(" href=\"" + href + "\"");
			
			String target = getHyperlinkTarget(hyperlink);
			if (target != null)
			{
				writer.write(" target=\"");
				writer.write(target);
				writer.write("\"");
			}
		}

		if (hyperlink.getHyperlinkTooltip() != null)
		{
			writer.write(" title=\"");
			writer.write(JRStringUtil.xmlEncode(hyperlink.getHyperlinkTooltip()));
			writer.write("\"");
		}
	}


	/**
	 *
	 */
	protected void loadPxImage() throws JRException
	{
		Renderable pxRenderer =
			net.sf.jasperreports.engine.RenderableUtil.getInstance(jasperReportsContext).getRenderable(JRImageLoader.PIXEL_IMAGE_RESOURCE);

		String imageName = "px";
		String imagePath = null;

		HtmlResourceHandler imageHandler = 
			getImageHandler() == null 
			? getExporterOutput().getImageHandler() 
			: getImageHandler();
		if (imageHandler != null)
		{
			byte[] imageData = ((DataRenderable)pxRenderer).getData(jasperReportsContext);
			
			imageHandler.handleResource(imageName, imageData);

			imagePath = imageHandler.getResourcePath(imageName);
		}

		rendererToImagePathMap.put(pxRenderer.getId(), imagePath);
	}


	/**
	 *
	 */
	protected static interface StringProvider
	{

		/**
		 *
		 */
		public String getStringForCollapsedTD(int width, int height);

		/**
		 *
		 */
		public String getStringForEmptyTD();

		public String getReportTableStyle();
	}


	/**
	 *
	 */
	private boolean appendPadding(StringBuilder sb, Integer padding, String side)
	{
		boolean addedToStyle = false;
		
		if (padding.intValue() > 0)
		{
			sb.append("padding");
			if (side != null)
			{
				sb.append("-");
				sb.append(side);
			}
			sb.append(": ");
			sb.append(toSizeUnit(padding.intValue()));
			sb.append("; ");

			addedToStyle = true;
		}
		
		return addedToStyle;
	}


	/**
	 *
	 */
	private boolean appendPen(StringBuilder sb, JRPen pen, String side)
	{
		boolean addedToStyle = false;
		
		float borderWidth = pen.getLineWidth().floatValue();
		if (0f < borderWidth && borderWidth < 1f)
		{
			borderWidth = 1f;
		}

		String borderStyle = null;
		switch (pen.getLineStyleValue())
		{
			case DOUBLE :
			{
				borderStyle = "double";
				break;
			}
			case DOTTED :
			{
				borderStyle = "dotted";
				break;
			}
			case DASHED :
			{
				borderStyle = "dashed";
				break;
			}
			case SOLID :
			default :
			{
				borderStyle = "solid";
				break;
			}
		}

		if (borderWidth > 0f)
		{
			sb.append("border");
			if (side != null)
			{
				sb.append("-");
				sb.append(side);
			}

			sb.append(": ");
			sb.append(toSizeUnit((int)borderWidth));
			
			sb.append(" ");
			sb.append(borderStyle);

			sb.append(" ");
			sb.append(JRColorUtil.getCssColor(pen.getLineColor()));
			sb.append("; ");

			addedToStyle = true;
		}

		return addedToStyle;
	}


	protected void exportFrame(JRPrintFrame frame, JRExporterGridCell gridCell) throws IOException, JRException
	{
		writeCellStart(gridCell);

		StringBuilder styleBuilder = new StringBuilder();
		Color frameBackcolor = appendBackcolorStyle(gridCell, styleBuilder);
		appendBorderStyle(gridCell.getBox(), styleBuilder);
		//no padding style for frames, because padding is in the grid

		if (styleBuilder.length() > 0)
		{
			writer.write(" style=\"");
			writer.write(styleBuilder.toString());
			writer.write("\"");
		}

		writer.write(">\n");

		if (frameBackcolor != null)
		{
			setBackcolor(frameBackcolor);
		}
		try
		{
			exportGrid(((ElementGridCell) gridCell).getLayout(), false);
		}
		finally
		{
			if (frameBackcolor != null)
			{
				restoreBackcolor();
			}
		}

		writeCellEnd(gridCell);
	}


	protected void setBackcolor(Color color)
	{
		backcolorStack.addLast(backcolor);

		backcolor = color;
	}


	protected void restoreBackcolor()
	{
		backcolor = backcolorStack.removeLast();
	}


	protected void exportGenericElement(JRGenericPrintElement element,
			JRExporterGridCell gridCell, int rowHeight) throws IOException
	{
		GenericElementHtmlHandler handler = (GenericElementHtmlHandler) 
				GenericElementHandlerEnviroment.getInstance(getJasperReportsContext()).getElementHandler(
						element.getGenericType(), HTML_EXPORTER_KEY);
		
		if (handler == null)
		{
			if (log.isDebugEnabled())
			{
				log.debug("No HTML generic element handler for " 
						+ element.getGenericType());
			}
			
			writeEmptyCell(gridCell, rowHeight);
		}
		else
		{
			writeCellStart(gridCell);

			StringBuilder styleBuilder = new StringBuilder();
			appendBackcolorStyle(gridCell, styleBuilder);
			appendBorderStyle(gridCell.getBox(), styleBuilder);
			if (styleBuilder.length() > 0)
			{
				writer.write(" style=\"");
				writer.write(styleBuilder.toString());
				writer.write("\"");
			}

			writer.write(">");
			
			String htmlFragment = handler.getHtmlFragment(exporterContext, element);
			if (htmlFragment != null)
			{
				writer.write(htmlFragment);
			}

			writeCellEnd(gridCell);
		}
	}

	public Map<net.sf.jasperreports.engine.JRExporterParameter,Object> getExportParameters()
	{
		return parameters;
	}

	@Override
	public String getExporterPropertiesPrefix()
	{
		return HTML_EXPORTER_PROPERTIES_PREFIX;
	}
	
	@Override
	public String getExporterKey()
	{
		return HTML_EXPORTER_KEY;
	}

	public JasperPrint getExportedReport()
	{
		return jasperPrint;
	}

	public String toSizeUnit(float size)
	{
		Number number = toZoom(size);
		if (number.intValue() == number.floatValue())
		{
			number = number.intValue();
		}

		return String.valueOf(number) + getCurrentItemConfiguration().getSizeUnit().getName();
	}

	/**
	 * @deprecated Replaced by {@link #toSizeUnit(float)}.
	 */
	public String toSizeUnit(int size)
	{
		return toSizeUnit((float)size);
	}

	public float toZoom(float size)
	{
		float zoom = DEFAULT_ZOOM;
		
		Float zoomRatio = getCurrentItemConfiguration().getZoomRatio();
		if (zoomRatio != null)
		{
			zoom = zoomRatio.floatValue();
			if (zoom <= 0)
			{
				throw 
					new JRRuntimeException(
						EXCEPTION_MESSAGE_KEY_INVALID_ZOOM_RATIO,  
						new Object[]{zoom} 
						);
			}
		}

		return (zoom * size);
	}

	/**
	 * @deprecated Replaced by {@link #toZoom(float)}.
	 */
	public int toZoom(int size)
	{
		return (int)toZoom((float)size);
	}
	
}

