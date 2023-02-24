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

import com.jaspersoft.ireport.locale.I18n;
import com.jaspersoft.ireport.designer.IReportManager;
import com.jaspersoft.ireport.designer.editor.ExpressionContext;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.design.JRDesignSubreportReturnValue;
import net.sf.jasperreports.engine.design.JRDesignVariable;
import org.jdesktop.swingx.JXTable;

/**
 *
 * @author  gtoffoli
 */
public class SubreportReturnValuesPanel extends javax.swing.JPanel {
    
    private List returnValues = new ArrayList();
    
    private ExpressionContext expressionContext = null;

    public ExpressionContext getExpressionContext() {
        return expressionContext;
    }

    public void setExpressionContext(ExpressionContext expressionContext) {
        this.expressionContext = expressionContext;
    }
    

    public List getReturnValues() {
        return returnValues;
    }

    /**
     * This method will duplicate the map. The panel will work on a copy of the map.
     **/
    @SuppressWarnings("unchecked")
    public void setReturnValues(List oldReturnVariables) {
        
        this.returnValues.clear();
        DefaultTableModel model = (DefaultTableModel)jTable.getModel();
        // Create a copy of the map content...
        Iterator iterator = oldReturnVariables.iterator();
        while (iterator.hasNext())
        {
            JRDesignSubreportReturnValue oldReturnValue = (JRDesignSubreportReturnValue)iterator.next();
            JRDesignSubreportReturnValue returnValue = new JRDesignSubreportReturnValue();
            returnValue.setSubreportVariable(oldReturnValue.getSubreportVariable() );
            returnValue.setCalculation(oldReturnValue.getCalculation() );
            returnValue.setIncrementerFactoryClassName(oldReturnValue.getIncrementerFactoryClassName() );
            returnValue.setToVariable(oldReturnValue.getToVariable() );
            returnValues.add(returnValue);
            model.addRow(new Object[]{returnValue, returnValue.getToVariable() });
        }
   }
    
    
    /** Creates new form SubreportParametersPanel */
    public SubreportReturnValuesPanel() {
        initComponents();
        
        javax.swing.DefaultListSelectionModel dlsm =  (javax.swing.DefaultListSelectionModel)this.jTable.getSelectionModel();
        dlsm.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent e)  {
                jTableSelectionValueChanged(e);
            }
        });
        
        jTable.getColumnModel().getColumn(0).setCellRenderer( new SubreportReturnValueCellRenderer());
        jLabelTitle.setText(I18n.getString("SubreportReturnValuesPanel.jLabelTitle.text"));
        jButtonAdd.setText(I18n.getString("Global.Button.Add"));
        jButtonModify.setText(I18n.getString("SubreportParametersPanel.jButtonModify.text"));
        jButtonDelete.setText(I18n.getString("Global.Button.Delete"));
        
        
    }
    
    public void jTableSelectionValueChanged(javax.swing.event.ListSelectionEvent e) {
        if (this.jTable.getSelectedRowCount() > 0) {
            this.jButtonModify.setEnabled(true);
            this.jButtonDelete.setEnabled(true);
        } else {
            this.jButtonModify.setEnabled(false);
            this.jButtonDelete.setEnabled(false);
        }
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new org.jdesktop.swingx.JXTable();
        jPanel1 = new javax.swing.JPanel();
        jButtonAdd = new javax.swing.JButton();
        jButtonModify = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        jLabelTitle.setText(I18n.getString("SubreportParametersPanel.jLabelTitle.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 0, 4);
        add(jLabelTitle, gridBagConstraints);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(375, 275));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subreport Variable", "Destination Variable"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setOpaque(false);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(jScrollPane1, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jButtonAdd.setText(I18n.getString("Global.Button.Add")); // NOI18N
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
        jPanel1.add(jButtonAdd, gridBagConstraints);

        jButtonModify.setText(I18n.getString("SubreportParametersPanel.jButtonModify.text")); // NOI18N
        jButtonModify.setEnabled(false);
        jButtonModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifyActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
        jPanel1.add(jButtonModify, gridBagConstraints);

        jButtonDelete.setText(I18n.getString("Global.Button.Delete")); // NOI18N
        jButtonDelete.setEnabled(false);
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
        jPanel1.add(jButtonDelete, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 4, 4);
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("unchecked")
    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        
        // Check if there is at least a local not system defined variable...
        List localVariables = IReportManager.getInstance().getActiveReport().getVariablesList();
        int count = 0;
        for (int i=0; count == 0 && i<localVariables.size(); ++i)
        {
            JRDesignVariable var = (JRDesignVariable)localVariables.get(i);
            if (!var.isSystemDefined()) count++;
        }
        
        if (count == 0)
        {
            javax.swing.JOptionPane.showMessageDialog(this, 
                    I18n.getString("SubreportReturnValuesPanel.Message.Warning"),
                    I18n.getString("SubreportReturnValuesPanel.Message.Error"),
                    javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Object pWin = SwingUtilities.getWindowAncestor(this);
        JRSubreportReturnValueDialog jrpd = null;
        if (pWin instanceof Dialog) jrpd = new JRSubreportReturnValueDialog((Dialog)pWin);
        else jrpd = new JRSubreportReturnValueDialog((Frame)pWin);
        
        jrpd.updateVariables();
        jrpd.setVisible(true);
        
        if (jrpd.getDialogResult() == javax.swing.JOptionPane.OK_OPTION) {
            
            JRDesignSubreportReturnValue returnValue = jrpd.getSubreportReturnValue();
            returnValues.add(returnValue);
            
            DefaultTableModel model = (DefaultTableModel)jTable.getModel();
            model.addRow(new Object[]{returnValue, returnValue.getToVariable() });
        }
        
    }//GEN-LAST:event_jButtonAddActionPerformed

    @SuppressWarnings("unchecked")
    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        
        DefaultTableModel model = (DefaultTableModel)jTable.getModel();
        // Remove selected parameters...
        while (jTable.getSelectedRow() >= 0)
        {
            int row = jTable.getSelectedRow();
            row = ((JXTable)jTable).convertRowIndexToModel(row);
            returnValues.remove( model.getValueAt(row,0) );
            model.removeRow(row);
        }
        
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    @SuppressWarnings("unchecked")
    private void jButtonModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifyActionPerformed
        
        DefaultTableModel model = (DefaultTableModel)jTable.getModel();
        
        int row = jTable.getSelectedRow();
        if (row < 0) return;
        row = ((JXTable)jTable).convertRowIndexToModel(row);
        
        JRDesignSubreportReturnValue oldReturnValue = (JRDesignSubreportReturnValue)model.getValueAt(row,0);
        
        Window pWin = SwingUtilities.windowForComponent(this);
        
        JRSubreportReturnValueDialog jrpd = null;
        if (pWin instanceof Dialog) jrpd = new JRSubreportReturnValueDialog((Dialog)pWin);
        else if (pWin instanceof Frame) jrpd = new JRSubreportReturnValueDialog((Frame)pWin);
        else jrpd = new JRSubreportReturnValueDialog((Dialog)null);
        
        
        //JRSubreportReturnValueDialog jrpd = new JRSubreportReturnValueDialog(SwingUtilities.getWindowAncestor(this));
        jrpd.setSubreportReturnValue(oldReturnValue);
        jrpd.setVisible(true);
            
        if (jrpd.getDialogResult() == javax.swing.JOptionPane.OK_OPTION) {
            JRDesignSubreportReturnValue newReturnValue = jrpd.getSubreportReturnValue();
            returnValues.set(row, newReturnValue);
            model.setValueAt(newReturnValue, row, 0);
            model.setValueAt(newReturnValue.getToVariable() , row, 1);
            
            jTable.updateUI();
        }
    }//GEN-LAST:event_jButtonModifyActionPerformed

    @SuppressWarnings("unchecked")
    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        
        if (evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt))
        {
            if (jTable.getSelectedRowCount() > 0)
            {
                jButtonModifyActionPerformed(null);
            }
        }
        
    }//GEN-LAST:event_jTableMouseClicked
    
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonModify;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
    
}
