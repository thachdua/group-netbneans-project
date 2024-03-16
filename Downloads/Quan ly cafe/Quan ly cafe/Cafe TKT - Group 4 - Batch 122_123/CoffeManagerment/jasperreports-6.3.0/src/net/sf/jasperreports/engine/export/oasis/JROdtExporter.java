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
 * Special thanks to Google 'Summer of Code 2005' program for supporting this development
 *
 * Contributors:
 * Majid Ali Khan - majidkk@users.sourceforge.net
 * Frank Sch�nheit - Frank.Schoenheit@Sun.COM
 */
package net.sf.jasperreports.engine.export.oasis;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Dimension2D;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRGenericElementType;
import net.sf.jasperreports.engine.JRGenericPrintElement;
import net.sf.jasperreports.engine.JRPrintElement;
import net.sf.jasperreports.engine.JRPrintElementIndex;
import net.sf.jasperreports.engine.JRPrintEllipse;
import net.sf.jasperreports.engine.JRPrintFrame;
import net.sf.jasperreports.engine.JRPrintHyperlink;
import net.sf.jasperreports.engine.JRPrintImage;
import net.sf.jasperreports.engine.JRPrintLine;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JRPrintRectangle;
import net.sf.jasperreports.engine.JRPrintText;
import net.sf.jasperreports.engine.JRPropertiesUtil;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperReportsContext;
import net.sf.jasperreports.engine.PrintPageFormat;
import net.sf.jasperreports.engine.export.CutsInfo;
import net.sf.jasperreports.engine.export.ElementGridCell;
import net.sf.jasperreports.engine.export.ExporterNature;
import net.sf.jasperreports.engine.export.GenericElementHandlerEnviroment;
import net.sf.jasperreports.engine.export.Grid;
import net.sf.jasperreports.engine.export.GridRow;
import net.sf.jasperreports.engine.export.JRExportProgressMonitor;
import net.sf.jasperreports.engine.export.JRExporterGridCell;
import net.sf.jasperreports.engine.export.JRGridLayout;
import net.sf.jasperreports.engine.export.JRHyperlinkProducer;
import net.sf.jasperreports.engine.export.JRXmlExporter;
import net.sf.jasperreports.engine.export.LengthUtil;
import net.sf.jasperreports.engine.export.zip.ExportZipEntry;
import net.sf.jasperreports.engine.export.zip.FileBufferedZipEntry;
import net.sf.jasperreports.engine.type.ModeEnum;
import net.sf.jasperreports.engine.util.ImageUtil;
import net.sf.jasperreports.engine.util.JRStringUtil;
import net.sf.jasperreports.engine.util.JRStyledText;
import net.sf.jasperreports.export.ExportInterruptedException;
import net.sf.jasperreports.export.ExporterInputItem;
import net.sf.jasperreports.export.OdtExporterConfiguration;
import net.sf.jasperreports.export.OdtReportConfiguration;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.ReportExportConfiguration;
import net.sf.jasperreports.renderers.DimensionRenderable;
import net.sf.jasperreports.renderers.Renderable;
import net.sf.jasperreports.renderers.ResourceRenderer;
import net.sf.jasperreports.renderers.util.RendererUtil;


/**
 * Exports a JasperReports document to ODF format. It has character output type and exports the document to a
 * grid-based layout.
 * <p/>
 * Open Document Format (short for OASIS Open Document Format for Office
 * Applications) describes electronic documents such as memos, spreadsheets, books,
 * charts, presentations, and word processing documents. <code>.odt</code> is the 
 * file extension used for the word processing documents in the Open Document Format, and such
 * files can be obtained in JasperReports using the 
 * {@link net.sf.jasperreports.engine.export.oasis.JROdtExporter} class.
 * <p/>
 * Currently, there are the following special configurations that can be applied to an ODT
 * exporter instance (see {@link net.sf.jasperreports.export.DocxReportConfiguration}) to customize 
 * its behavior:
 * <ul>
 * <li>Allowing table rows to adjust their height if more text is typed into their cells using
 * the ODT editor. This is controlled using either the
 * {@link net.sf.jasperreports.export.OdtReportConfiguration#isFlexibleRowHeight() isFlexibleRowHeight()} 
 * exporter configuration flag, or its corresponding exporter hint called
 * {@link net.sf.jasperreports.export.OdtReportConfiguration#PROPERTY_ODT_FLEXIBLE_ROW_HEIGHT net.sf.jasperreports.export.odt.flexible.row.height}.</li>
 * <li>Ignoring hyperlinks in generated documents if they are not intended for the ODT output format. This can be 
 * customized using either the 
 * {@link net.sf.jasperreports.export.OdtReportConfiguration#isIgnoreHyperlink() isIgnoreHyperlink()} 
 * exporter configuration flag, or its corresponding exporter hint called
 * {@link net.sf.jasperreports.export.OdtReportConfiguration#PROPERTY_IGNORE_HYPERLINK net.sf.jasperreports.export.odt.ignore.hyperlink}</li>
 * </ul>
 * <p/>
 * So far, the ODT exporter has the known limitations of grid exporters. It
 * can work in batch mode and supports all types of exporter input and output as well as
 * font mappings.
 * 
 * @see net.sf.jasperreports.export.OdtReportConfiguration
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 */
public class JROdtExporter extends JRAbstractExporter<OdtReportConfiguration, OdtExporterConfiguration, OutputStreamExporterOutput, JROdtExporterContext>
{
	private static final Log log = LogFactory.getLog(JROdtExporter.class);
	
	/**
	 * The exporter key, as used in
	 * {@link GenericElementHandlerEnviroment#getElementHandler(JRGenericElementType, String)}.
	 */
	public static final String ODT_EXPORTER_KEY = JRPropertiesUtil.PROPERTY_PREFIX + "odt";
	
	protected static final String ODT_EXPORTER_PROPERTIES_PREFIX = JRPropertiesUtil.PROPERTY_PREFIX + "export.odt.";

	
	/**
	 * @deprecated Replaced by {@link OdtReportConfiguration#PROPERTY_IGNORE_HYPERLINK}.
	 */
	public static final String PROPERTY_IGNORE_HYPERLINK = OdtReportConfiguration.PROPERTY_IGNORE_HYPERLINK;
	

	protected class ExporterContext extends BaseExporterContext implements JROdtExporterContext
	{
		TableBuilder tableBuilder = null;
		
		public ExporterContext(TableBuilder tableBuidler)
		{
			this.tableBuilder = tableBuidler;
		}
		
		@Override
		public TableBuilder getTableBuilder()
		{
			return tableBuilder;
		}
	}

	protected class OdtDocumentBuilder extends DocumentBuilder
	{
		public OdtDocumentBuilder(OasisZip oasisZip) 
		{
			super(oasisZip);
		}

		@Override
		public JRStyledText getStyledText(JRPrintText text) 
		{
			return JROdtExporter.this.getStyledText(text);
		}

		@Override
		public Locale getTextLocale(JRPrintText text) 
		{
			return JROdtExporter.this.getTextLocale(text);
		}

		@Override
		public String getInvalidCharReplacement() 
		{
			return JROdtExporter.this.invalidCharReplacement;
		}

		@Override
		protected void insertPageAnchor(TableBuilder tableBuilder) 
		{
			JROdtExporter.this.insertPageAnchor(tableBuilder);
		}

		@Override
		protected JRHyperlinkProducer getHyperlinkProducer(JRPrintHyperlink link) 
		{
			return JROdtExporter.this.getHyperlinkProducer(link);
		}

		@Override
		protected JasperReportsContext getJasperReportsContext() 
		{
			return JROdtExporter.this.getJasperReportsContext();
		}

		@Override
		protected int getReportIndex() 
		{
			return JROdtExporter.this.reportIndex;
		}

		@Override
		protected int getPageIndex() 
		{
			return JROdtExporter.this.pageIndex;
		}
	}

	/**
	 *
	 */
	protected WriterHelper tempBodyWriter;
	protected WriterHelper tempStyleWriter;

	protected int reportIndex;
	protected int pageFormatIndex;
	protected int pageIndex;
	protected int tableIndex;
	protected boolean startPage;
	
	protected String invalidCharReplacement;

	protected LinkedList<Color> backcolorStack = new LinkedList<Color>();
	protected Color backcolor;

	protected DocumentBuilder documentBuilder;

	protected StyleCache styleCache;

	protected ExporterNature nature;

	protected Map<Integer, String> rowStyles = new HashMap<Integer, String>();
	protected Map<Integer, String> columnStyles = new HashMap<Integer, String>();
	
	/**
	 * @see #JROdtExporter(JasperReportsContext)
	 */
	public JROdtExporter()
	{
		this(DefaultJasperReportsContext.getInstance());
	}


	/**
	 *
	 */
	public JROdtExporter(JasperReportsContext jasperReportsContext)
	{
		super(jasperReportsContext);
		
		exporterContext = new ExporterContext(null);
	}


	@Override
	protected Class<OdtExporterConfiguration> getConfigurationInterface()
	{
		return OdtExporterConfiguration.class;
	}


	@Override
	protected Class<OdtReportConfiguration> getItemConfigurationInterface()
	{
		return OdtReportConfiguration.class;
	}
	

	@Override
	@SuppressWarnings("deprecation")
	protected void ensureOutput()
	{
		if (exporterOutput == null)
		{
			exporterOutput = 
				new net.sf.jasperreports.export.parameters.ParametersOutputStreamExporterOutput(
					getJasperReportsContext(),
					getParameters(),
					getCurrentJasperPrint()
					);
		}
	}
	

	@Override
	public void exportReport() throws JRException
	{
		/*   */
		ensureJasperReportsContext();
		ensureInput();

		initExport();

		ensureOutput();
		
		OutputStream outputStream = getExporterOutput().getOutputStream();

		try
		{
			exportReportToOasisZip(outputStream);
		}
		catch (IOException e)
		{
			throw new JRRuntimeException(e);
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
	}


	@Override
	protected void initReport()
	{
		super.initReport();
		
		if(jasperPrint.hasProperties() && jasperPrint.getPropertiesMap().containsProperty(JRXmlExporter.PROPERTY_REPLACE_INVALID_CHARS))
		{
			// allows null values for the property
			invalidCharReplacement = jasperPrint.getProperty(JRXmlExporter.PROPERTY_REPLACE_INVALID_CHARS);
		}
		else
		{
			invalidCharReplacement = getPropertiesUtil().getProperty(JRXmlExporter.PROPERTY_REPLACE_INVALID_CHARS, jasperPrint);
		}

		nature = new JROdtExporterNature(getJasperReportsContext(), filter);
	}

	
	/**
	 *
	 */
	protected void exportReportToOasisZip(OutputStream os) throws JRException, IOException
	{
		OasisZip oasisZip = new FileBufferedOasisZip(OasisZip.MIME_TYPE_ODT);

		ExportZipEntry tempBodyEntry = new FileBufferedZipEntry(null);
		ExportZipEntry tempStyleEntry = new FileBufferedZipEntry(null);

		tempBodyWriter = new WriterHelper(jasperReportsContext, tempBodyEntry.getWriter());
		tempStyleWriter = new WriterHelper(jasperReportsContext, tempStyleEntry.getWriter());

		documentBuilder = new OdtDocumentBuilder(oasisZip);
		
		styleCache = new StyleCache(jasperReportsContext, tempStyleWriter, getExporterKey());

		WriterHelper stylesWriter = new WriterHelper(jasperReportsContext, oasisZip.getStylesEntry().getWriter());

		List<ExporterInputItem> items = exporterInput.getItems();

		StyleBuilder styleBuilder = new StyleBuilder(stylesWriter);
		
		styleBuilder.buildBeforeAutomaticStyles(jasperPrint);
		
		pageFormatIndex = -1;

		for(reportIndex = 0; reportIndex < items.size(); reportIndex++)
		{
			ExporterInputItem item = items.get(reportIndex);
			rowStyles.clear();
			columnStyles.clear();

			setCurrentExporterInputItem(item);
			
			List<JRPrintPage> pages = jasperPrint.getPages();
			if (pages != null && pages.size() > 0)
			{
				PageRange pageRange = getPageRange();
				int startPageIndex = (pageRange == null || pageRange.getStartPageIndex() == null) ? 0 : pageRange.getStartPageIndex();
				int endPageIndex = (pageRange == null || pageRange.getEndPageIndex() == null) ? (pages.size() - 1) : pageRange.getEndPageIndex();

				PrintPageFormat oldPageFormat = null;
				JRPrintPage page = null;
				for(pageIndex = startPageIndex; pageIndex <= endPageIndex; pageIndex++)
				{
					if (Thread.interrupted())
					{
						throw new ExportInterruptedException();
					}

					PrintPageFormat pageFormat = jasperPrint.getPageFormat(pageIndex);
					
					if (oldPageFormat != pageFormat)
					{
						styleBuilder.buildPageLayout(++pageFormatIndex, pageFormat);
						oldPageFormat = pageFormat;
					}

					page = pages.get(pageIndex);

					exportPage(page);
				}
			}
		}

		styleBuilder.buildMasterPages(pageFormatIndex);
		

		stylesWriter.flush();
		tempBodyWriter.flush();
		tempStyleWriter.flush();


		stylesWriter.close();
		tempBodyWriter.close();
		tempStyleWriter.close();


		/*   */
		ContentBuilder contentBuilder =
			new ContentBuilder(
				oasisZip.getContentEntry(),
				tempStyleEntry,
				tempBodyEntry,
				styleCache.getFontFaces(),
				OasisZip.MIME_TYPE_ODT
				);
		contentBuilder.build();

		tempStyleEntry.dispose();
		tempBodyEntry.dispose();

		oasisZip.zipEntries(os);

		oasisZip.dispose();
	}


	/**
	 *
	 */
	protected void exportPage(JRPrintPage page) throws JRException, IOException
	{
		startPage = true;

		ReportExportConfiguration configuration = getCurrentItemConfiguration();
		
		PrintPageFormat pageFormat = jasperPrint.getPageFormat(pageIndex);
		
		JRGridLayout layout =
			new JRGridLayout(
				nature,
				page.getElements(),
				pageFormat.getPageWidth(),
				pageFormat.getPageHeight(),
				configuration.getOffsetX() == null ? 0 : configuration.getOffsetX(), 
				configuration.getOffsetY() == null ? 0 : configuration.getOffsetY(),
				null //address
				);

		exportGrid(layout, null);

		JRExportProgressMonitor progressMonitor = configuration.getProgressMonitor();
		if (progressMonitor != null)
		{
			progressMonitor.afterPageExport();
		}
	}


	/**
	 *
	 */
	protected void exportGrid(JRGridLayout gridLayout, JRPrintElementIndex frameIndex) throws IOException, JRException
	{
		boolean isFlexibleRowHeight = getCurrentItemConfiguration().isFlexibleRowHeight();
		
		CutsInfo xCuts = gridLayout.getXCuts();
		Grid grid = gridLayout.getGrid();

		TableBuilder tableBuilder = frameIndex == null
			? new TableBuilder(documentBuilder, jasperPrint, pageFormatIndex, pageIndex, tempBodyWriter, tempStyleWriter, styleCache, rowStyles, columnStyles)
			: new TableBuilder(documentBuilder, jasperPrint, frameIndex.toString(), tempBodyWriter, tempStyleWriter, styleCache, rowStyles, columnStyles);

		
		tableBuilder.buildTableStyle(gridLayout.getWidth());
		tableBuilder.buildTableHeader();

		for(int col = 1; col < xCuts.size(); col++)
		{
			tableBuilder.buildColumnStyle(
					col - 1,
					xCuts.getCutOffset(col) - xCuts.getCutOffset(col - 1)
					);
			tableBuilder.buildColumnHeader(xCuts.getCutOffset(col) - xCuts.getCutOffset(col - 1));
			tableBuilder.buildColumnFooter();
		}

		int rowCount = grid.getRowCount();
		for(int row = 0; row < rowCount; row++)
		{
			int emptyCellColSpan = 0;
			//int emptyCellWidth = 0;
			int rowHeight = gridLayout.getRowHeight(row);

			tableBuilder.buildRowStyle(row, isFlexibleRowHeight ? -1 : rowHeight);
			tableBuilder.buildRowHeader(isFlexibleRowHeight ? -1 : rowHeight);

			GridRow gridRow = grid.getRow(row);
			int rowSize = gridRow.size();
			for(int col = 0; col < rowSize; col++)
			{
				JRExporterGridCell gridCell = gridRow.get(col);
				if (gridCell.getType() == JRExporterGridCell.TYPE_OCCUPIED_CELL)
				{
					if (emptyCellColSpan > 0)
					{
						//writeEmptyCell(gridCell, emptyCellColSpan, emptyCellWidth, rowHeight);
						emptyCellColSpan = 0;
						//emptyCellWidth = 0;
					}

					//writeOccupiedCells(1);
					exportOccupiedCells(1);
//					OccupiedGridCell occupiedGridCell = (OccupiedGridCell)gridCell;
//					ElementGridCell elementGridCell = (ElementGridCell)grid[occupiedGridCell.getRow()][occupiedGridCell.getCol()];
//					exportOccupiedCells(elementGridCell);
//					col += elementGridCell.getColSpan() - 1;
				}
				else if(gridCell.getType() == JRExporterGridCell.TYPE_ELEMENT_CELL)
				{
					if (emptyCellColSpan > 0)
					{
						//writeEmptyCell(gridCell, emptyCellColSpan, emptyCellWidth, rowHeight);
						emptyCellColSpan = 0;
						//emptyCellWidth = 0;
					}

					JRPrintElement element = gridCell.getElement();

					if (element instanceof JRPrintLine)
					{
						exportLine(tableBuilder, (JRPrintLine)element, gridCell);
					}
					else if (element instanceof JRPrintRectangle)
					{
						exportRectangle(tableBuilder, (JRPrintRectangle)element, gridCell);
					}
					else if (element instanceof JRPrintEllipse)
					{
						exportEllipse(tableBuilder, (JRPrintEllipse)element, gridCell);
					}
					else if (element instanceof JRPrintImage)
					{
						exportImage(tableBuilder, (JRPrintImage)element, gridCell);
					}
					else if (element instanceof JRPrintText)
					{
						exportText(tableBuilder, (JRPrintText)element, gridCell);
					}
					else if (element instanceof JRPrintFrame)
					{
						exportFrame(tableBuilder, (JRPrintFrame)element, gridCell);
					}
					else if (element instanceof JRGenericPrintElement)
					{
						exportGenericElement(tableBuilder, (JRGenericPrintElement)element, gridCell);
					}

					// //x += gridCell.colSpan - 1;
					//col += gridCell.getColSpan() - 1;
				}
				else
				{
					emptyCellColSpan++;
					//emptyCellWidth += gridCell.getWidth();
					exportEmptyCell(gridCell, 1);
				}
			}

//			if (emptyCellColSpan > 0)
//			{
//				//writeEmptyCell(null, emptyCellColSpan, emptyCellWidth, rowHeight);
//			}

			tableBuilder.buildRowFooter();
		}

		tableBuilder.buildTableFooter();
	}


	/**
	 *
	 */
	private void exportOccupiedCells(int count)
	{
		for(int i = 0; i < count; i++)
		{
			tempBodyWriter.write("<table:covered-table-cell/>\n");
		}
	}

	
	/**
	 *
	 */
	private void exportEmptyCell(JRExporterGridCell gridCell, int emptyCellColSpan) throws IOException
	{
		tempBodyWriter.write("<table:table-cell");
		//tempBodyWriter.write(" office:value-type=\"string\"");
//		if (gridCell == null)
//		{
//			tempBodyWriter.write(" table:style-name=\"empty-cell\"");
//		}
//		else
		{
			tempBodyWriter.write(" table:style-name=\"" + styleCache.getCellStyle(gridCell) + "\"");
		}
		if (emptyCellColSpan > 1)
		{
			tempBodyWriter.write(" table:number-columns-spanned=\"" + emptyCellColSpan + "\"");
		}
		tempBodyWriter.write("/>\n");

		exportOccupiedCells(emptyCellColSpan - 1);
	}


	/**
	 *
	 */
	protected void exportFrame(TableBuilder tableBuilder, JRPrintFrame frame, JRExporterGridCell gridCell) throws IOException, JRException
	{
		tableBuilder.buildCellHeader(styleCache.getCellStyle(gridCell), gridCell.getColSpan(), gridCell.getRowSpan());

		boolean appendBackcolor =
			frame.getModeValue() == ModeEnum.OPAQUE
			&& (backcolor == null || frame.getBackcolor().getRGB() != backcolor.getRGB());

		if (appendBackcolor)
		{
			setBackcolor(frame.getBackcolor());
		}

		try
		{
			JRGridLayout layout = ((ElementGridCell) gridCell).getLayout();
			JRPrintElementIndex frameIndex =
				new JRPrintElementIndex(
						reportIndex,
						pageIndex,
						gridCell.getElementAddress()
						);
			exportGrid(layout, frameIndex);
		}
		finally
		{
			if (appendBackcolor)
			{
				restoreBackcolor();
			}
		}

		tableBuilder.buildCellFooter();
	}


	/**
	 *
	 */
	protected void setBackcolor(Color color)
	{
		backcolorStack.addLast(backcolor);

		backcolor = color;
	}


	/**
	 *
	 */
	protected void restoreBackcolor()
	{
		backcolor = backcolorStack.removeLast();
	}


	/**
	 *
	 */
	protected void exportRectangle(TableBuilder tableBuilder, JRPrintRectangle rectangle, JRExporterGridCell gridCell)
	{
		tableBuilder.exportRectangle(rectangle, gridCell);
	}

	
	/**
	 *
	 */
	protected void exportLine(TableBuilder tableBuilder, JRPrintLine line, JRExporterGridCell gridCell)
	{
		tableBuilder.exportLine(line, gridCell);
	}

	
	/**
	 *
	 */
	protected void exportEllipse(TableBuilder tableBuilder, JRPrintEllipse ellipse, JRExporterGridCell gridCell)
	{
		tableBuilder.exportEllipse(ellipse, gridCell);
	}


	/**
	 *
	 */
	public void exportText(TableBuilder tableBuilder, JRPrintText text, JRExporterGridCell gridCell)
	{
		tableBuilder.exportText(text, gridCell, false, true, false);
	}

	
	/**
	 *
	 */
	public void exportImage(TableBuilder tableBuilder, JRPrintImage image, JRExporterGridCell gridCell) throws JRException
	{
		int topPadding = 
			Math.max(image.getLineBox().getTopPadding().intValue(), Math.round(image.getLineBox().getTopPen().getLineWidth().floatValue()));
		int leftPadding = 
			Math.max(image.getLineBox().getLeftPadding().intValue(), Math.round(image.getLineBox().getLeftPen().getLineWidth().floatValue()));
		int bottomPadding = 
			Math.max(image.getLineBox().getBottomPadding().intValue(), Math.round(image.getLineBox().getBottomPen().getLineWidth().floatValue()));
		int rightPadding = 
			Math.max(image.getLineBox().getRightPadding().intValue(), Math.round(image.getLineBox().getRightPen().getLineWidth().floatValue()));

		int availableImageWidth = image.getWidth() - leftPadding - rightPadding;
		availableImageWidth = availableImageWidth < 0 ? 0 : availableImageWidth;

		int availableImageHeight = image.getHeight() - topPadding - bottomPadding;
		availableImageHeight = availableImageHeight < 0 ? 0 : availableImageHeight;

		tableBuilder.buildCellHeader(styleCache.getCellStyle(gridCell), gridCell.getColSpan(), gridCell.getRowSpan());

		Renderable renderer = image.getRenderer();

		if (
			renderer != null 
			&& availableImageWidth > 0 
			&& availableImageHeight > 0
			)
		{
			InternalImageProcessor imageProcessor = 
				new InternalImageProcessor(
					image, 
					gridCell,
					availableImageWidth,
					availableImageHeight
					);
				
			InternalImageProcessorResult imageProcessorResult = null;
			
			try
			{
				imageProcessorResult = imageProcessor.process(renderer);
			}
			catch (Exception e)
			{
				Renderable onErrorRenderer = getRendererUtil().handleImageError(e, image.getOnErrorTypeValue());
				if (onErrorRenderer != null)
				{
					imageProcessorResult = imageProcessor.process(onErrorRenderer);
				}
			}
			
			if (imageProcessorResult != null)
			{
				tempBodyWriter.write("<text:p>");
				documentBuilder.insertPageAnchor(tableBuilder);
				if (image.getAnchorName() != null)
				{
					tableBuilder.exportAnchor(JRStringUtil.xmlEncode(image.getAnchorName()));
				}


				boolean startedHyperlink = tableBuilder.startHyperlink(image,false);

				tempBodyWriter.write(
					"<draw:frame text:anchor-type=\"paragraph\" "
					+ "draw:style-name=\"" + styleCache.getGraphicStyle(image) + "\" "
					+ "svg:x=\"" + LengthUtil.inch(leftPadding + imageProcessorResult.xoffset) + "in\" "
					+ "svg:y=\"" + LengthUtil.inch(topPadding + imageProcessorResult.yoffset) + "in\" "
					+ "svg:width=\"" + LengthUtil.inch(imageProcessorResult.width) + "in\" "
					+ "svg:height=\"" + LengthUtil.inch(imageProcessorResult.height) + "in\">"
					);
				tempBodyWriter.write("<draw:image ");
				tempBodyWriter.write(" xlink:href=\"" + JRStringUtil.xmlEncode(imageProcessorResult.imagePath) + "\"");
				tempBodyWriter.write(" xlink:type=\"simple\"");
				tempBodyWriter.write(" xlink:show=\"embed\"");
				tempBodyWriter.write(" xlink:actuate=\"onLoad\"");
				tempBodyWriter.write("/>\n");

				tempBodyWriter.write("</draw:frame>");
				if(startedHyperlink)
				{
					tableBuilder.endHyperlink(false);
				}
				tempBodyWriter.write("</text:p>");
			}
		}

		tableBuilder.buildCellFooter();
	}

	
	private class InternalImageProcessor
	{
		private final JRPrintImage imageElement;
		private final JRExporterGridCell cell;
		private final int availableImageWidth;
		private final int availableImageHeight;

		protected InternalImageProcessor(
			JRPrintImage imageElement,
			JRExporterGridCell cell,
			int availableImageWidth,
			int availableImageHeight
			)
		{
			this.imageElement = imageElement;
			this.cell = cell;
			this.availableImageWidth = availableImageWidth;
			this.availableImageHeight = availableImageHeight;
		}
		
		private InternalImageProcessorResult process(Renderable renderer) throws JRException
		{
			boolean isLazy = RendererUtil.isLazy(renderer);

			if (!isLazy)
			{
				if (renderer instanceof ResourceRenderer)
				{
					renderer = documentBuilder.getRenderersCache().getLoadedRenderer((ResourceRenderer)renderer);
				}
			}

			// check dimension first, to avoid caching renderers that might not be used eventually, due to their dimension errors 

			int width = availableImageWidth;
			int height = availableImageHeight;

			int xoffset = 0;
			int yoffset = 0;

			switch (imageElement.getScaleImageValue())
			{
				case FILL_FRAME :
				{
					width = availableImageWidth;
					height = availableImageHeight;
					xoffset = 0;
					yoffset = 0;
					break;
				}
				case CLIP :
				case RETAIN_SHAPE :
				default :
				{
					double normalWidth = availableImageWidth;
					double normalHeight = availableImageHeight;

					if (!isLazy)
					{
						DimensionRenderable dimensionRenderer = documentBuilder.getRenderersCache().getDimensionRenderable(renderer);
						Dimension2D dimension = dimensionRenderer == null ? null :  dimensionRenderer.getDimension(jasperReportsContext);
						if (dimension != null)
						{
							normalWidth = dimension.getWidth();
							normalHeight = dimension.getHeight();
						}
					}

					double ratio = normalWidth / normalHeight;

					if( ratio > availableImageWidth / (double)availableImageHeight )
					{
						width = availableImageWidth;
						height = (int)(width/ratio);

					}
					else
					{
						height = availableImageHeight;
						width = (int)(ratio * height);
					}

					xoffset = (int)(ImageUtil.getXAlignFactor(imageElement) * (availableImageWidth - width));
					yoffset = (int)(ImageUtil.getYAlignFactor(imageElement) * (availableImageHeight - height));
				}
			}


			String imagePath = 
					documentBuilder.getImagePath(
						renderer, 
						new Dimension(availableImageWidth, availableImageHeight),
						ModeEnum.OPAQUE == imageElement.getModeValue() ? imageElement.getBackcolor() : null,
						cell,
						isLazy
						);

			return 
				new InternalImageProcessorResult(
					imagePath, 
					width,
					height,
					xoffset,
					yoffset
					);
		}
	}

	private class InternalImageProcessorResult
	{
		protected final String imagePath;
		protected int width;
		protected int height;
		protected int xoffset;
		protected int yoffset;
		
		protected InternalImageProcessorResult(
			String imagePath, 
			int width,
			int height,
			int xoffset,
			int yoffset
			)
		{
			this.imagePath = imagePath;
			this.width = width;
			this.height = height;
			this.xoffset = xoffset;
			this.yoffset = yoffset;
		}
	}

	
	/**
	 * 
	 */
	protected void insertPageAnchor(TableBuilder tableBuilder)
	{
		if(startPage)
		{
			tableBuilder.exportAnchor(DocumentBuilder.JR_PAGE_ANCHOR_PREFIX + reportIndex + "_" + (pageIndex + 1));
			startPage = false;
		}
	}

	
	/**
	 *
	 */
	protected void exportGenericElement(TableBuilder tableBuilder, JRGenericPrintElement element, JRExporterGridCell gridCell) throws IOException, JRException
	{
		GenericElementOdtHandler handler = (GenericElementOdtHandler) 
		GenericElementHandlerEnviroment.getInstance(getJasperReportsContext()).getElementHandler(
				element.getGenericType(), getExporterKey());

		if (handler != null)
		{
			JROdtExporterContext exporterContext = new ExporterContext(tableBuilder);

			handler.exportElement(exporterContext, element, gridCell);
		}
		else
		{
			if (log.isDebugEnabled())
			{
				log.debug("No ODT generic element handler for " 
						+ element.getGenericType());
			}
		}
	}

	
	@Override
	public String getExporterKey()
	{
		return ODT_EXPORTER_KEY;
	}

	
	@Override
	public String getExporterPropertiesPrefix()
	{
		return ODT_EXPORTER_PROPERTIES_PREFIX;
	}
}

