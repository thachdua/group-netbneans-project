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
package net.sf.jasperreports.compilers;

import net.sf.jasperreports.compilers.JavaScriptCompiledData.CompiledClass;
import net.sf.jasperreports.engine.JRRuntimeException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mozilla.javascript.DefiningClassLoader;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.optimizer.Codegen;

/**
 * Class loader used to load classes generated for JavaScript expression evaluation.
 * 
 * @author Lucian Chirita (lucianc@users.sourceforge.net)
 * @see JavaScriptCompiledEvaluator
 */
public class JavaScriptClassLoader extends DefiningClassLoader
{

	private static final Log log = LogFactory.getLog(JavaScriptClassLoader.class);
	
	public static final String EXCEPTION_MESSAGE_KEY_INSTANCE_ERROR = "compilers.javascript.instance.error";
	public static final String EXCEPTION_MESSAGE_KEY_LOAD_ERROR = "compilers.javascript.load.error";
	
	public JavaScriptClassLoader()
	{
		super(Codegen.class.getClassLoader());
	}
	
	public Script createScript(int classIndex, JavaScriptCompiledData compiledData)
	{
		CompiledClass compiledClass = compiledData.getCompiledClass(classIndex);
		Class<? extends Script> scriptClass = loadExpressionClass(compiledClass);
		try
		{
			Script script = scriptClass.newInstance();
			return script;
		}
		catch (InstantiationException e)
		{
			throw 
				new JRRuntimeException(
					EXCEPTION_MESSAGE_KEY_INSTANCE_ERROR,
					new Object[]{compiledClass.getClassName()},
					e);
		}
		catch (IllegalAccessException e)
		{
			throw 
				new JRRuntimeException(
					EXCEPTION_MESSAGE_KEY_INSTANCE_ERROR,
					new Object[]{compiledClass.getClassName()},
					e);
		}
	}
	
	protected synchronized Class<? extends Script> loadExpressionClass(CompiledClass compiledClass)
	{
		String className = compiledClass.getClassName();
		
		// first check if the class is already loaded
		Class<?> scriptClass = findLoadedClass(className);
		if (scriptClass == null)
		{
			if (log.isDebugEnabled())
			{
				log.debug("loading script class " + className);
			}

			try
			{
				scriptClass = defineClass(className, compiledClass.getClassBytes());
				linkClass(scriptClass);
			}
			catch (SecurityException e)
			{
				throw 
					new JRRuntimeException(
						EXCEPTION_MESSAGE_KEY_LOAD_ERROR,
						new Object[]{className},
						e);
			}
			catch (IllegalArgumentException e)
			{
				throw 
					new JRRuntimeException(
						EXCEPTION_MESSAGE_KEY_LOAD_ERROR,
						new Object[]{className},
						e);
			}
		}
		
		return (Class<? extends Script>) scriptClass;
	}
	
	@Override
	public String toString()
	{
		return getClass().getSimpleName() + '@' + hashCode();
	}

	@Override
	protected void finalize() throws Throwable
	{
		super.finalize();
		
		if (log.isDebugEnabled())
		{
			log.debug("finalized " + this);
		}
	}
	
	
}
