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
package com.jaspersoft.ireport.designer.sheet.properties.charts;

import com.jaspersoft.ireport.designer.sheet.Tag;
import com.jaspersoft.ireport.designer.sheet.properties.ByteProperty;
import com.jaspersoft.ireport.locale.I18n;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.charts.design.JRDesignMeterPlot;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRRuntimeException;
    
    
/**
 *  Class to manage the JRDesignMeterPlot.PROPERTY_SHAPE property
 */
public final class MeterShapeProperty extends ByteProperty
{
    private final JRDesignMeterPlot element;

    
    public MeterShapeProperty(JRDesignMeterPlot element)
    {
        super(element);
        this.element = element;
    }

    @Override
    public String getName()
    {
        return JRDesignMeterPlot.PROPERTY_SHAPE;
    }

    @Override
    public String getDisplayName()
    {
        return I18n.getString("Shape");
    }

    @Override
    public String getShortDescription()
    {
        return I18n.getString("Shape.");
    }

    @Override
    public List getTagList() 
    {
        List tags = new ArrayList();
        tags.add(new Tag(new Byte(JRDesignMeterPlot.SHAPE_PIE), I18n.getString("Pie")));
        tags.add(new Tag(new Byte(JRDesignMeterPlot.SHAPE_CIRCLE), I18n.getString("Circle")));
        tags.add(new Tag(new Byte(JRDesignMeterPlot.SHAPE_CHORD), I18n.getString("Chord")));
        tags.add(new Tag(new Byte(JRDesignMeterPlot.SHAPE_DIAL), I18n.getString("Dial")));
        return tags;
    }

    @Override
    public Byte getByte()
    {
        return element.getShapeByte();
    }

    @Override
    public Byte getOwnByte()
    {
        return element.getShapeByte();
    }

    @Override
    public Byte getDefaultByte()
    {
        return null;
    }

    @Override
    public void setByte(Byte position)
    {
        try
        {
            element.setShape(position);
        }
        catch(JRException e)
        {
            throw new JRRuntimeException(e);
        }
    }
    
}
