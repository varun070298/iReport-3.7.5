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

import com.jaspersoft.ireport.designer.data.queryexecuters.QueryExecuterDef;
import com.jaspersoft.ireport.locale.I18n;


/**
 *
 * @author  Administrator
 */
public class QueryExecuterDialog extends javax.swing.JDialog {
    /** Creates new form JRParameterDialog */
    private QueryExecuterDef queryExecuterDef = null;
    
    public QueryExecuterDialog(java.awt.Frame parent, boolean modal) {        
        super(parent, modal);
        initComponents();
        applyI18n();
        
        javax.swing.KeyStroke escape =  javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0, false);
        javax.swing.Action escapeAction = new javax.swing.AbstractAction() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                jButtonCancelActionPerformed(e);
            }
        };
       
        getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).put(escape, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);


        //to make the default button ...
        this.getRootPane().setDefaultButton(this.jButtonOK);
    }
    
  
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jTextFieldLanguage = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldFactoryClass = new javax.swing.JTextField();
        jLabelFieldsProvider = new javax.swing.JLabel();
        jTextFieldFactoryClass1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButtonOK = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setTitle("Add/modify property");
        setModal(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel1.setText("Language");
        jLabel1.setMaximumSize(new java.awt.Dimension(1000, 100));
        jLabel1.setMinimumSize(new java.awt.Dimension(100, 15));
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 4);
        getContentPane().add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 4);
        getContentPane().add(jTextFieldLanguage, gridBagConstraints);

        jLabel4.setText("Factory class");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 0, 4);
        getContentPane().add(jLabel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 4);
        getContentPane().add(jTextFieldFactoryClass, gridBagConstraints);

        jLabelFieldsProvider.setText("Fields provider class (optional)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 0, 4);
        getContentPane().add(jLabelFieldsProvider, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 4, 4);
        getContentPane().add(jTextFieldFactoryClass1, gridBagConstraints);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jPanel1.setMinimumSize(new java.awt.Dimension(200, 35));
        jPanel1.setPreferredSize(new java.awt.Dimension(250, 35));
        jButtonOK.setMnemonic('o');
        jButtonOK.setText("OK");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        jPanel1.add(jButtonOK);

        jButtonCancel.setMnemonic('c');
        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jPanel1.add(jButtonCancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-320)/2, (screenSize.height-177)/2, 320, 177);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        setVisible(false);
        this.setDialogResult( javax.swing.JOptionPane.CANCEL_OPTION);
        dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        
        if (this.jTextFieldLanguage.getText().trim().length() <= 0)
        {
            javax.swing.JOptionPane.showMessageDialog(this,
                    I18n.getString("messages.queryExecuterDialog.notValidLanguage","Please insert a valid language name!"),
                    I18n.getString("messages.queryExecuterDialog.notValidLanguageCaption","Invalid language!"),javax.swing.JOptionPane.WARNING_MESSAGE );
            return;
        }
        
        if (this.jTextFieldFactoryClass.getText().trim().length() <= 0)
        {
            javax.swing.JOptionPane.showMessageDialog(this,
                    I18n.getString("messages.queryExecuterDialog.notValidFactoryName","Please insert a valid Factory class name!"),
                    I18n.getString("messages.queryExecuterDialog.notValidFactoryNameCaption","Invalid class name!"),
                    javax.swing.JOptionPane.WARNING_MESSAGE );
            return;
        }
        
        
        
        if (queryExecuterDef == null) queryExecuterDef = new QueryExecuterDef();
        queryExecuterDef.setLanguage( jTextFieldLanguage.getText().trim());
        queryExecuterDef.setClassName( jTextFieldFactoryClass.getText().trim());
        queryExecuterDef.setFieldsProvider( jTextFieldFactoryClass1.getText().trim());
        
        setVisible(false);
        this.setDialogResult( javax.swing.JOptionPane.OK_OPTION);
        dispose();
    }//GEN-LAST:event_jButtonOKActionPerformed
    
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        this.setDialogResult( javax.swing.JOptionPane.CLOSED_OPTION);
        dispose();
    }//GEN-LAST:event_closeDialog
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new QueryExecuterDialog(new javax.swing.JFrame(), true).setVisible(true);
    }
    
    /** Getter for property dialogResult.
     * @return Value of property dialogResult.
     *
     */
    public int getDialogResult() {
        return dialogResult;
    }
    
    /** Setter for property dialogResult.
     * @param dialogResult New value of property dialogResult.
     *
     */
    public void setDialogResult(int dialogResult) {
        this.dialogResult = dialogResult;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelFieldsProvider;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldFactoryClass;
    private javax.swing.JTextField jTextFieldFactoryClass1;
    private javax.swing.JTextField jTextFieldLanguage;
    // End of variables declaration//GEN-END:variables

    private int dialogResult;    

    public QueryExecuterDef getQueryExecuterDef() {
        return queryExecuterDef;
    }

    

    public void setQueryExecuterDef(QueryExecuterDef queryExecuterDef) {
        this.queryExecuterDef = queryExecuterDef;
        this.jTextFieldLanguage.setText( queryExecuterDef.getLanguage() );
        this.jTextFieldFactoryClass.setText( queryExecuterDef.getClassName());
        this.jTextFieldFactoryClass1.setText( queryExecuterDef.getFieldsProvider());
    }
    
    public void applyI18n(){
                // Start autogenerated code ----------------------
                jButtonCancel.setText(I18n.getString("queryExecuterDialog.buttonCancel","Cancel"));
                jButtonOK.setText(I18n.getString("queryExecuterDialog.buttonOK","OK"));
                jLabel1.setText(I18n.getString("queryExecuterDialog.label1","Language"));
                jLabel4.setText(I18n.getString("queryExecuterDialog.label4","Factory class"));
                
                jLabelFieldsProvider.setText(I18n.getString("queryExecuterDialog.labelFieldsProviderClass","Fields Provider class (optional)"));
                // End autogenerated code ----------------------
                setTitle(I18n.getString("queryExecuterDialog.title","Query executers"));
                jButtonCancel.setMnemonic(I18n.getString("queryExecuterDialog.buttonCancelMnemonic","c").charAt(0));
                jButtonOK.setMnemonic(I18n.getString("queryExecuterDialog.buttonOKMnemonic","o").charAt(0));
    }
}