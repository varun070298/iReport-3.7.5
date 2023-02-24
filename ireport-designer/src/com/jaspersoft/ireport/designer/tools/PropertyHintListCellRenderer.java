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
package com.jaspersoft.ireport.designer.tools;

import java.awt.Component;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author  gtoffoli
 */
public class PropertyHintListCellRenderer extends javax.swing.JPanel implements ListCellRenderer {
    
    public void setSelected(boolean b)
    {
        setBackground(b ? UIManager.getColor("List.selectionBackground") : UIManager.getColor("ToolTip.background"));
        jLabelDescription.setForeground(b ?  UIManager.getColor("List.selectionForeground") : UIManager.getColor("ToolTip.foreground"));
        jLabelProperty.setForeground(b ?  UIManager.getColor("List.selectionForeground") : UIManager.getColor("ToolTip.foreground"));
    }
    
    public void setPropertyName(String s)
    {
        if (s == null) s ="";
        if (!s.startsWith("<html><b>")) s = "<html><b>" + s;
        jLabelProperty.setText(s);
    }
    
    public void setPropertyDescription(String s)
    {
        if (s == null) s ="";
        if (!s.startsWith("<html>")) s = "<html>" + s;
        jLabelDescription.setText(s);
    }
    
    /** Creates new form PropertyHintRendererPanel */
    public PropertyHintListCellRenderer() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelProperty = new javax.swing.JLabel();
        jLabelDescription = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setLayout(new java.awt.GridBagLayout());

        jLabelProperty.setText("<html><b>Property");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 0, 4);
        add(jLabelProperty, gridBagConstraints);

        jLabelDescription.setText("jLabel1");
        jLabelDescription.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelDescription.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 0, 4);
        add(jLabelDescription, gridBagConstraints);

        jSeparator1.setMinimumSize(new java.awt.Dimension(1, 1));
        jSeparator1.setPreferredSize(new java.awt.Dimension(1, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jSeparator1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelDescription;
    private javax.swing.JLabel jLabelProperty;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        
        setSelected(isSelected);
        if (value instanceof PropertyHint)
        {
            PropertyHint ph = (PropertyHint)value;
            this.setPropertyName( ph.getPropertyName() );
            this.setPropertyDescription( ph.getPropertyDescription() );
        }
        else
        {
            this.setPropertyName("" + value);
            this.setPropertyDescription("");
        }
        
        if (cellHasFocus)
        {
            setBorder( UIManager.getBorder("List.focusCellHighlightBorder"));
        }
        else
        {
            setBorder(new EmptyBorder(new Insets(1, 1, 1, 1)));
        }
        
        return this;
    }
    
}