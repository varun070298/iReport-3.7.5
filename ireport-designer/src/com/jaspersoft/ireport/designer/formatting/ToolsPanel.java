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
package com.jaspersoft.ireport.designer.formatting;

import com.jaspersoft.ireport.designer.IReportManager;
import com.jaspersoft.ireport.locale.I18n;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 *
 * @author  gtoffoli
 */
public class ToolsPanel extends javax.swing.JPanel {
    
    /** Creates new form ToolsPanel */
    public ToolsPanel() {
        initComponents();
        applyI18n();
        jToolBar1.setLayout(new ToolsLayoutManager());
        jScrollPane1.getVerticalScrollBar().setBlockIncrement(23);
        
        setTextLabels(IReportManager.getPreferences().getBoolean("formatting_tools_show_labels",true));
    }

    public void setTextLabels(boolean labelsAreEnabled) {
        Component c;
        int i = 0;
        while((c = jToolBar1.getComponentAtIndex(i++)) != null) {
            
            if (c instanceof JButton)
            {
                JButton button = (JButton)c;
                button.setHorizontalTextPosition(SwingConstants.RIGHT);
                button.setHorizontalAlignment(SwingConstants.LEFT);
                button.setText((String) (labelsAreEnabled ? button.getAction().getValue(Action.NAME) : null));
            }
        }
    }
    
    public void add(Action action)
    {
        JButton button = jToolBar1.add(action);
        button.setComponentPopupMenu(jPopupMenu1);

        button.setHorizontalTextPosition(SwingConstants.RIGHT);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setText((String) (IReportManager.getPreferences().getBoolean("formatting_tools_show_labels",true) ? button.getAction().getValue(Action.NAME) : null));
    }

    private void applyI18n() {
        jCheckBoxMenuItemShowLabels.setText(I18n.getString("ToolsPanel.jCheckBoxMenuItemShowLabels.text")); // NOI18N
    }
  
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jCheckBoxMenuItemShowLabels = new javax.swing.JCheckBoxMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jToolBar1 = new javax.swing.JToolBar();

        jCheckBoxMenuItemShowLabels.setSelected(true);
        jCheckBoxMenuItemShowLabels.setText("Show Labels");
        jCheckBoxMenuItemShowLabels.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItemShowLabelsActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jCheckBoxMenuItemShowLabels);

        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jScrollPane1ComponentResized(evt);
            }
        });

        jToolBar1.setBorder(null);
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setComponentPopupMenu(jPopupMenu1);

        org.jdesktop.layout.GroupLayout jToolBar1Layout = new org.jdesktop.layout.GroupLayout(jToolBar1);
        jToolBar1.setLayout(jToolBar1Layout);
        jToolBar1Layout.setHorizontalGroup(
            jToolBar1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        jToolBar1Layout.setVerticalGroup(
            jToolBar1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 378, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jToolBar1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

private void jScrollPane1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jScrollPane1ComponentResized

    jToolBar1.setSize( jScrollPane1.getSize());
    Dimension dim = jToolBar1.getLayout().preferredLayoutSize(jToolBar1);
    jToolBar1.setSize(dim);
    
}//GEN-LAST:event_jScrollPane1ComponentResized

private void jCheckBoxMenuItemShowLabelsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItemShowLabelsActionPerformed

    setTextLabels(jCheckBoxMenuItemShowLabels.isSelected());
    IReportManager.getPreferences().putBoolean("formatting_tools_show_labels",jCheckBoxMenuItemShowLabels.isSelected());
}//GEN-LAST:event_jCheckBoxMenuItemShowLabelsActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemShowLabels;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
    
}
