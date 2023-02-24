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
package com.jaspersoft.ireport.jasperserver.options;

import com.jaspersoft.ireport.designer.IReportManager;
import com.jaspersoft.ireport.designer.utils.Misc;
import com.jaspersoft.ireport.jasperserver.JasperServerManager;
import com.jaspersoft.ireport.jasperserver.ws.IReportTrustManager;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

final class JasperServerRepositoryPanel extends javax.swing.JPanel {

    private final JasperServerRepositoryOptionsPanelController controller;

    JasperServerRepositoryPanel(JasperServerRepositoryOptionsPanelController controller) {
        this.controller = controller;
        initComponents();
        // TODO listen to changes in form fields and call controller.changed()
        jSpinner1.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE/1000, 5));
    }

    private boolean init = false;

    public boolean setInit(boolean b)
    {
        boolean old = init;
        init =b;
        return old;
    }

    public boolean isInit()
    {
        return init;
    }

    /**
     * Notify a change in the UI.
     */
    public void notifyChange()
    {
        if (this.controller != null && !isInit())
        {
            controller.changed();
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jCheckBoxProMode = new javax.swing.JCheckBox();
        jButtonClearCertificatesCache = new javax.swing.JButton();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(JasperServerRepositoryPanel.class, "JasperServerRepositoryPanel.jLabel1.text")); // NOI18N

        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jCheckBoxProMode, org.openide.util.NbBundle.getMessage(JasperServerRepositoryPanel.class, "JasperServerRepositoryPanel.jCheckBoxProMode.text")); // NOI18N
        jCheckBoxProMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxProModeActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jButtonClearCertificatesCache, org.openide.util.NbBundle.getMessage(JasperServerRepositoryPanel.class, "JasperServerRepositoryPanel.jButtonClearCertificatesCache.text")); // NOI18N
        jButtonClearCertificatesCache.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearCertificatesCacheActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jSpinner1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 82, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 46, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(jCheckBoxProMode, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
                    .add(jButtonClearCertificatesCache))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jSpinner1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jCheckBoxProMode)
                .add(18, 18, 18)
                .add(jButtonClearCertificatesCache)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxProModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxProModeActionPerformed
        notifyChange();
}//GEN-LAST:event_jCheckBoxProModeActionPerformed

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        notifyChange();
    }//GEN-LAST:event_jSpinner1StateChanged

    private void jButtonClearCertificatesCacheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearCertificatesCacheActionPerformed
        
        JasperServerManager.getPreferences().remove(IReportTrustManager.TRUSTED_CERTIFICATE_FINGERPRINTS);

        JOptionPane.showMessageDialog(Misc.getMainFrame(), "All the trusted certificate fingerprints have been removed from the cache.");
    }//GEN-LAST:event_jButtonClearCertificatesCacheActionPerformed

    void load() {
        setInit(true);
        //jCheckBoxJS30Compatibility.setSelected(IReportManager.getPreferences().getBoolean("use_jrxml_DTD", false));
        int timeout = IReportManager.getPreferences().getInt("client_timeout", 0);
        jSpinner1.setValue(new Integer(timeout));
        jCheckBoxProMode.setSelected(IReportManager.getPreferences().getBoolean("proMode", false));
        setInit(false);
    }

    void store() {
        //IReportManager.getPreferences().putBoolean("use_jrxml_DTD", jCheckBoxJS30Compatibility.isSelected());
        IReportManager.getPreferences().putInt("client_timeout", ((SpinnerNumberModel)jSpinner1.getModel()).getNumber().intValue() );
        IReportManager.getPreferences().putBoolean("proMode", jCheckBoxProMode.isSelected());
    }

    boolean valid() {
        // TODO check whether form is consistent and complete
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClearCertificatesCache;
    private javax.swing.JCheckBox jCheckBoxProMode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables
}
