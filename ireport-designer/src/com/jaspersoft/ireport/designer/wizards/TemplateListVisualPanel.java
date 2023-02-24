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
package com.jaspersoft.ireport.designer.wizards;

import com.jaspersoft.ireport.locale.I18n;
import javax.swing.JPanel;
import org.openide.filesystems.FileObject;


public final class TemplateListVisualPanel extends JPanel {

    private TemplateListWizardPanel panel = null;
        
    /** Creates new form TemplateVisualPanel */
    public TemplateListVisualPanel(TemplateListWizardPanel panel) {
        this.panel = panel;
        initComponents();
        
        
     }

    @Override
    public String getName() {
        return I18n.getString("TemplateVisualPanel.Name.Layout");
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        templatesPanel1 = new com.jaspersoft.ireport.designer.templates.TemplatesPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(518, 379));
        setLayout(new java.awt.BorderLayout());
        add(templatesPanel1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jaspersoft/ireport/designer/resources/template/small.png"))); // NOI18N
        jPanel1.add(jLabel1, new java.awt.GridBagConstraints());

        jSlider1.setMaximum(1000);
        jSlider1.setMinimum(80);
        jSlider1.setFocusable(false);
        jSlider1.setMinimumSize(new java.awt.Dimension(120, 23));
        jSlider1.setPreferredSize(new java.awt.Dimension(150, 23));
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        jPanel1.add(jSlider1, new java.awt.GridBagConstraints());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jaspersoft/ireport/designer/resources/template/big.png"))); // NOI18N
        jPanel1.add(jLabel2, new java.awt.GridBagConstraints());

        add(jPanel1, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged

        templatesPanel1.setIconsSize( jSlider1.getValue());
}//GEN-LAST:event_jSlider1StateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider jSlider1;
    private com.jaspersoft.ireport.designer.templates.TemplatesPanel templatesPanel1;
    // End of variables declaration//GEN-END:variables

    public void setSelectedTemplate(FileObject obj)
    {
        if (obj == null) return;
        templatesPanel1.setSelectedTamplate(obj);
    }

    public FileObject getSelectedTemplate()
    {
        if (templatesPanel1.getSelectedTamplate() != null)
        {
            return templatesPanel1.getSelectedTamplate().getFileObject();
        }
        return null;
    }

   
}

