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
import net.sf.jasperreports.engine.base.JRBaseChart;
import net.sf.jasperreports.engine.design.JRDesignChart;


/**
 *  Class to manage the JRDesignChart.PROPERTY_TITLE_POSITION property
 */
public final class TitlePositionProperty extends ByteProperty
{
    private final JRDesignChart chart;

    
    public TitlePositionProperty(JRDesignChart chart)
    {
        super(chart);
        this.chart = chart;
    }

    @Override
    public String getName()
    {
        return JRBaseChart.PROPERTY_TITLE_POSITION;
    }

    @Override
    public String getDisplayName()
    {
        return I18n.getString("Global.Property.TitlePosition");
    }

    @Override
    public String getShortDescription()
    {
        return I18n.getString("Global.Property.TitlePosition");
    }

    @Override
    public List getTagList() 
    {
        List tags = new ArrayList();
        tags.add(new Tag(new Byte(JRDesignChart.EDGE_TOP), I18n.getString("Global.Property.Top")));
        tags.add(new Tag(new Byte(JRDesignChart.EDGE_BOTTOM), I18n.getString("Global.Property.Bottom")));
        tags.add(new Tag(new Byte(JRDesignChart.EDGE_LEFT), I18n.getString("Global.Property.Left")));
        tags.add(new Tag(new Byte(JRDesignChart.EDGE_RIGHT), I18n.getString("Global.Property.Right")));
        return tags;
    }

    @Override
    public Byte getByte()
    {
        return chart.getTitlePositionByte();
    }

    @Override
    public Byte getOwnByte()
    {
        return chart.getTitlePositionByte();
    }

    @Override
    public Byte getDefaultByte()
    {
        return null;
    }

    @Override
    public void setByte(Byte position)
    {
        chart.setTitlePosition(position);
    }

}
