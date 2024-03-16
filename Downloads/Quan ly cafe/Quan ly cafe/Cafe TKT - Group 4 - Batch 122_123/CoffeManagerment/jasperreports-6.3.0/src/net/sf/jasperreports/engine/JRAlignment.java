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
package net.sf.jasperreports.engine;


/**
 * An interface that defines constants useful for alignment. All report elements that can be aligned in some way
 * implement this interface.
 *
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 */
public interface JRAlignment extends JRStyleContainer
{

	/**
	 * Gets the text horizontal alignment.
	 * @return a value representing one of the horizontal alignment constants in {@link net.sf.jasperreports.engine.type.HorizontalAlignEnum}
	 * @deprecated Replaced by {@link JRTextAlignment} and {@link JRImageAlignment}. 
	 */
	public net.sf.jasperreports.engine.type.HorizontalAlignEnum getHorizontalAlignmentValue();

	/**
	 * @deprecated Replaced by {@link JRTextAlignment} and {@link JRImageAlignment}. 
	 */
	public net.sf.jasperreports.engine.type.HorizontalAlignEnum getOwnHorizontalAlignmentValue();

	/**
	 * Sets the text horizontal alignment.
	 * @param horizontalAlignment a value representing one of the horizontal alignment constants in {@link net.sf.jasperreports.engine.type.HorizontalAlignEnum}
	 * @deprecated Replaced by {@link JRTextAlignment} and {@link JRImageAlignment}. 
	 */
	public void setHorizontalAlignment(net.sf.jasperreports.engine.type.HorizontalAlignEnum horizontalAlignment);

	/**
	 * Gets the text vertical alignment.
	 * @return a value representing one of the vertical alignment constants in {@link net.sf.jasperreports.engine.type.VerticalAlignEnum}
	 * @deprecated Replaced by {@link JRTextAlignment} and {@link JRImageAlignment}. 
	 */
	public net.sf.jasperreports.engine.type.VerticalAlignEnum getVerticalAlignmentValue();
	
	/**
	 * @deprecated Replaced by {@link JRTextAlignment} and {@link JRImageAlignment}. 
	 */
	public net.sf.jasperreports.engine.type.VerticalAlignEnum getOwnVerticalAlignmentValue();

	/**
	 * Gets the text vertical alignment.
	 * @param verticalAlignment a value representing one of the vertical alignment constants in {@link net.sf.jasperreports.engine.type.VerticalAlignEnum}
	 * @deprecated Replaced by {@link JRTextAlignment} and {@link JRImageAlignment}. 
	 */
	public void setVerticalAlignment(net.sf.jasperreports.engine.type.VerticalAlignEnum verticalAlignment);

}
