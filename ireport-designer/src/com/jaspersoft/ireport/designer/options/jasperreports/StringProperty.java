/*
 * iReport - Visual Designer for JasperReports.
 * Copyright (C) 2002 - 2009 Jaspersoft Corporation. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of iReport.
 *
 * iReport is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * iReport is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with iReport. If not, see <http://www.gnu.org/licenses/>.
 */
package com.jaspersoft.ireport.designer.options.jasperreports;

import java.lang.reflect.InvocationTargetException;
import net.sf.jasperreports.engine.util.JRProperties;
import org.openide.nodes.PropertySupport;

/**
 *
 * @author gtoffoli
 */
public class StringProperty extends PropertySupport.ReadWrite {

    public StringProperty(String name)
    {
        super(name, String.class, name, name);
    }

    @Override
    public Object getValue() throws IllegalAccessException, InvocationTargetException {
        if (getName() != null)
        {
            String val = JRProperties.getProperty(getName());
            return val == null ? "" : val+"";
        }

        return "";
    }



    @Override
    public void setValue(Object newValue) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        if (newValue != null)
        {

        }

    }

}
