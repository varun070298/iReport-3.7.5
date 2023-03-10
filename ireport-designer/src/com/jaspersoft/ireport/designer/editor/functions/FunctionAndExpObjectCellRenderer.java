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

package com.jaspersoft.ireport.designer.editor.functions;

import com.jaspersoft.ireport.designer.editor.ExpObjectCellRenderer;
import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @version $Id: FunctionAndExpObjectCellRenderer.java 0 2010-08-10 13:23:17 CET gtoffoli $
 * @author Giulio Toffoli (giulio@jaspersoft.com)
 *
 */
public class FunctionAndExpObjectCellRenderer extends ExpObjectCellRenderer {

    private Color selectionBackground;
    private Color background;

    // Create a style object and then set the style attributes
    Style methodStyle = null;
    Style returnTypeStyle = null;

    public FunctionAndExpObjectCellRenderer(JList list) {
        super();
        selectionBackground = list.getSelectionBackground();
        background = list.getBackground();
        StyledDocument doc = new DefaultStyledDocument();
        this.setDocument( doc );
        methodStyle = doc.addStyle("methodStyle", null);
        StyleConstants.setBold(methodStyle, true);
        returnTypeStyle = doc.addStyle("returnType", null);
        StyleConstants.setForeground(returnTypeStyle, Color.gray);
    }


    @Override
    public Component getListCellRendererComponent(JList list, Object object, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, object, index, isSelected, cellHasFocus);
    
        updateText(object, isSelected);

        return this;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        updateText(value, isSelected);
        
        return this;
    }

    private void updateText(Object object, boolean isSelected)
    {
        if (object instanceof Function)
        {
            Function f = (Function)object;

            String s = f.getName() + "(";

            List<Parameter> params = f.getParameters();
            boolean first= true;
            for (Parameter p : params)
            {
                if (!first) s += ", ";
                first = false;
                s += p.getLabel();
            }
            s += ") " +  f.getReturnType();

            this.setText("");
            StyledDocument doc = (StyledDocument)this.getDocument();
            try {
            doc.insertString(doc.getLength(), s.substring(0, s.indexOf("(")), methodStyle);
            doc.insertString(doc.getLength(), s.substring(s.indexOf("("), s.lastIndexOf(")")+1), null);
            doc.insertString(doc.getLength(), s.substring(s.lastIndexOf(")")+1), returnTypeStyle);
            } catch (Exception ex){}
            setBackground(isSelected ? selectionBackground : background);
        }
    }



}
