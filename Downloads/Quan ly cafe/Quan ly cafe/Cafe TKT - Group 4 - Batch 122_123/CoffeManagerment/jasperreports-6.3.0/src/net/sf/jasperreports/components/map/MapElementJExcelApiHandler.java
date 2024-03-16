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
package net.sf.jasperreports.components.map;

import net.sf.jasperreports.engine.JRGenericPrintElement;
import net.sf.jasperreports.engine.export.JRExporterGridCell;
import net.sf.jasperreports.engine.export.JRGridLayout;


/**
 * @deprecated To be removed.
 * @author sanda zaharia (shertage@users.sourceforge.net)
 */
public class MapElementJExcelApiHandler implements net.sf.jasperreports.engine.export.GenericElementJExcelApiHandler
{
	private static final MapElementJExcelApiHandler INSTANCE = new MapElementJExcelApiHandler();
	
	public static MapElementJExcelApiHandler getInstance()
	{
		return INSTANCE;
	}
	
	@Override
	public void exportElement(
		net.sf.jasperreports.engine.export.JExcelApiExporterContext exporterContext,
		JRGenericPrintElement element,
		JRExporterGridCell gridCell,
		int colIndex,
		int rowIndex,
		int emptyCols,
		int yCutsRow, 
		JRGridLayout layout
		)
	{
		try
		{
			net.sf.jasperreports.engine.export.JExcelApiExporter exporter = 
				(net.sf.jasperreports.engine.export.JExcelApiExporter)exporterContext.getExporter();
			exporter.exportImage(MapElementImageProvider.getImage(exporterContext.getJasperReportsContext(), element), gridCell, colIndex, rowIndex, emptyCols, yCutsRow, layout);
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean toExport(JRGenericPrintElement element) {
		return true;
	}

}
