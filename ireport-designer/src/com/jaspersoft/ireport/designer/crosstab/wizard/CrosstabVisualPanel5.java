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
package com.jaspersoft.ireport.designer.crosstab.wizard;

import com.jaspersoft.ireport.locale.I18n;
import com.jaspersoft.ireport.designer.sheet.Tag;
import com.jaspersoft.ireport.designer.utils.ColorSchemaGenerator;
import com.jaspersoft.ireport.designer.utils.Misc;
import java.awt.Color;
import java.util.List;
import javax.swing.JPanel;
import org.openide.WizardDescriptor;

public final class CrosstabVisualPanel5 extends JPanel {
    
    /** Creates new form CrosstabVisualPanel2 */
    public CrosstabVisualPanel5() {
        initComponents();
        
        List<String> colors = ColorSchemaGenerator.getColors();
        for (int i=0; i<colors.size(); ++i)
        {
            jComboBoxColors.addItem(colors.get(i));
        }
        
        List<Tag> variants = ColorSchemaGenerator.getVariants();
        for (int i=0; i<variants.size(); ++i)
        {
            jComboBoxVariations.addItem(variants.get(i));
        }
        updatePreview();
    }

    @Override
    public String getName() {
        return I18n.getString("CrosstabVisualPanel5.Label.Layout");
    }

    public void readSettings(WizardDescriptor settings)
    {
        jCheckBoxRowGroupTotals.setSelected( settings.getProperty("rowGroupTotals") == null ?
                Boolean.TRUE :
                (Boolean)settings.getProperty("rowGroupTotals") );
       
        jCheckBoxColumnGroupTotals.setSelected( settings.getProperty("columnGroupTotals") == null ?
                Boolean.TRUE :
                (Boolean)settings.getProperty("columnGroupTotals") );
        
        jCheckBoxShowGrid.setSelected( settings.getProperty("showGrid") == null ?
                Boolean.TRUE :
                (Boolean)settings.getProperty("showGrid") );
        
        jCheckBoxWhiteGrid.setSelected( settings.getProperty("whiteGrid") == null ?
                Boolean.FALSE :
                (Boolean)settings.getProperty("whiteGrid") );
        
        String schema = (String)settings.getProperty("schemaColor");
        if (schema != null)
        {
            jComboBoxColors.setSelectedItem(schema);
        }
        
        String variant = (String)settings.getProperty("schemaVariant");
        if (variant != null)
        {
            Misc.setComboboxSelectedTagValue(jComboBoxColors, variant);
        }
    }
    
    public void storeSettings(WizardDescriptor settings)
    {
        settings.putProperty("rowGroupTotals", jCheckBoxRowGroupTotals.isSelected());
        settings.putProperty("columnGroupTotals", jCheckBoxColumnGroupTotals.isSelected());
        settings.putProperty("showGrid", jCheckBoxShowGrid.isSelected());
        
        settings.putProperty("whiteGrid", jCheckBoxWhiteGrid.isSelected());
        settings.putProperty("schemaColor", jComboBoxColors.getSelectedItem());
        if (jComboBoxVariations.getSelectedItem() != null)
        settings.putProperty("schemaVariant", ((Tag)jComboBoxVariations.getSelectedItem()).getValue());
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxRowGroupTotals = new javax.swing.JCheckBox();
        jCheckBoxColumnGroupTotals = new javax.swing.JCheckBox();
        jCheckBoxShowGrid = new javax.swing.JCheckBox();
        layoutPreviewPanel1 = new com.jaspersoft.ireport.designer.crosstab.wizard.LayoutPreviewPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxColors = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxVariations = new javax.swing.JComboBox();
        jCheckBoxWhiteGrid = new javax.swing.JCheckBox();

        jCheckBoxRowGroupTotals.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(jCheckBoxRowGroupTotals, I18n.getString("CrosstabVisualPanel5.CheckBox.AddRowGroupTotals")); // NOI18N
        jCheckBoxRowGroupTotals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxRowGroupTotalsActionPerformed(evt);
            }
        });

        jCheckBoxColumnGroupTotals.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(jCheckBoxColumnGroupTotals, I18n.getString("CrosstabVisualPanel5.CheckBox.AddColumnGroupTotals")); // NOI18N
        jCheckBoxColumnGroupTotals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxColumnGroupTotalsActionPerformed(evt);
            }
        });

        jCheckBoxShowGrid.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(jCheckBoxShowGrid, I18n.getString("CrosstabVisualPanel5.CheckBox.ShowGridLines")); // NOI18N
        jCheckBoxShowGrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxShowGridActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, I18n.getString("CrosstabVisualPanel5.Label.ColorScheme")); // NOI18N

        jComboBoxColors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxColorsActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, I18n.getString("CrosstabVisualPanel5.Label.Variations")); // NOI18N

        jComboBoxVariations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxVariationsActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jCheckBoxWhiteGrid, I18n.getString("CrosstabVisualPanel5.CheckBox.UseWhiteGrid")); // NOI18N
        jCheckBoxWhiteGrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxWhiteGridActionPerformed(evt);
            }
        });
        jCheckBoxWhiteGrid.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBoxWhiteGridStateChanged(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(126, 126, 126)
                        .add(layoutPreviewPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(jCheckBoxRowGroupTotals, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                                .add(90, 90, 90))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jCheckBoxColumnGroupTotals, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                            .add(jCheckBoxShowGrid, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jSeparator1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 102, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 102, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jComboBoxVariations, 0, 255, Short.MAX_VALUE)
                            .add(jComboBoxColors, 0, 255, Short.MAX_VALUE))))
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jCheckBoxWhiteGrid, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .add(187, 187, 187))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layoutPreviewPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jComboBoxColors, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jComboBoxVariations, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jCheckBoxWhiteGrid)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 17, Short.MAX_VALUE)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jCheckBoxRowGroupTotals)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jCheckBoxColumnGroupTotals)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jCheckBoxShowGrid)
                .addContainerGap(57, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxRowGroupTotalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxRowGroupTotalsActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jCheckBoxRowGroupTotalsActionPerformed

    private void jCheckBoxColumnGroupTotalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxColumnGroupTotalsActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jCheckBoxColumnGroupTotalsActionPerformed

    private void jCheckBoxShowGridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxShowGridActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jCheckBoxShowGridActionPerformed

    private void jComboBoxColorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxColorsActionPerformed
        updatePreview();
        
}//GEN-LAST:event_jComboBoxColorsActionPerformed

    private void jComboBoxVariationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxVariationsActionPerformed
        updatePreview();
}//GEN-LAST:event_jComboBoxVariationsActionPerformed

    private void jCheckBoxWhiteGridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxWhiteGridActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jCheckBoxWhiteGridActionPerformed

    private void jCheckBoxWhiteGridStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBoxWhiteGridStateChanged
        updatePreview();
    }//GEN-LAST:event_jCheckBoxWhiteGridStateChanged

    public void updatePreview()
    {
        String s = ""+jComboBoxColors.getSelectedItem();
        Color c = ColorSchemaGenerator.getColor(s);
        if (c != null)
        {
            layoutPreviewPanel1.setColor(c);
        }
        
        Tag var = (Tag)jComboBoxVariations.getSelectedItem();
        
        if (var != null)
        {
            layoutPreviewPanel1.setVariant((String)var.getValue());
        }

        layoutPreviewPanel1.setWhiteGrid(jCheckBoxWhiteGrid.isSelected());
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBoxColumnGroupTotals;
    private javax.swing.JCheckBox jCheckBoxRowGroupTotals;
    private javax.swing.JCheckBox jCheckBoxShowGrid;
    private javax.swing.JCheckBox jCheckBoxWhiteGrid;
    private javax.swing.JComboBox jComboBoxColors;
    private javax.swing.JComboBox jComboBoxVariations;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private com.jaspersoft.ireport.designer.crosstab.wizard.LayoutPreviewPanel layoutPreviewPanel1;
    // End of variables declaration//GEN-END:variables
}

