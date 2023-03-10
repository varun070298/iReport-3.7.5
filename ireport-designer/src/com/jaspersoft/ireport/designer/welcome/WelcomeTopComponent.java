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
package com.jaspersoft.ireport.designer.welcome;

import com.jaspersoft.ireport.locale.I18n;
import java.awt.BorderLayout;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.openide.util.NbBundle;
import org.openide.util.Utilities;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
//import org.openide.util.Utilities;

/**
 * Top component which displays something.
 */
final class WelcomeTopComponent extends TopComponent {

    private static WelcomeTopComponent instance;
    /** path to the icon used by the component and its open action */
//    static final String ICON_PATH = "SET/PATH/TO/ICON/HERE";

    private static final String PREFERRED_ID = "WelcomeTopComponent";

    private WelcomeTopComponent() {
        initComponents();
        setName(I18n.getString("CTL_WelcomeTopComponent"));
        setToolTipText(I18n.getString("HINT_WelcomeTopComponent"));
//        setIcon(Utilities.loadImage(ICON_PATH, true));

        jLabelWelcome.setText(I18n.getString("welcome.toiReport"));
        
        jImagePanel1.setImage( new ImageIcon( this.getClass().getResource("/com/jaspersoft/ireport/designer/resources/welcome/welcomeScreen_filler.png")).getImage());

        jPanelContent1.add(new SectionPanel(I18n.getString("welcome.recentReports"), new RecentReportsPanel()), BorderLayout.CENTER);
        jPanelContent2.add(new SectionPanel(I18n.getString("welcome.quickStart"), new QuickStartPanel()), BorderLayout.CENTER);
        jPanelContent3.add(new SectionPanel(I18n.getString("welcome.resources"), new WebContentPanel("http://ireport.sf.net/webcontent1.php")), BorderLayout.CENTER);
        jPanelContent4.add(new SectionPanel(I18n.getString("welcome.resources2"), new WebContentPanel("http://ireport.sf.net/webcontent2.php")), BorderLayout.CENTER);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabelWelcome = new TitleLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jImagePanel1 = new com.jaspersoft.ireport.designer.welcome.JImagePanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanelContent = new javax.swing.JPanel();
        jPanelContent1 = new javax.swing.JPanel();
        jPanelseparatorNorth = new GraySeparator(GraySeparator.SEPARATOR_NORTH, true);
        jPanelContent2 = new javax.swing.JPanel();
        jPanelseparatorWest = new GraySeparator(GraySeparator.SEPARATOR_WEST);
        jPanelseparatorEast = new GraySeparator(GraySeparator.SEPARATOR_EAST);
        jPanelContent3 = new javax.swing.JPanel();
        jPanelseparatorSouth = new GraySeparator(GraySeparator.SEPARATOR_SOUTH);
        jPanelContent4 = new javax.swing.JPanel();

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 60));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabelWelcome.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabelWelcome.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(jLabelWelcome, org.openide.util.NbBundle.getMessage(WelcomeTopComponent.class, "WelcomeTopComponent.jLabelWelcome.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 4);
        jPanel1.add(jLabelWelcome, gridBagConstraints);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jaspersoft/ireport/designer/resources/welcome/logo.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(WelcomeTopComponent.class, "WelcomeTopComponent.jLabel3.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 4, 0, 0);
        jPanel1.add(jLabel3, gridBagConstraints);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jaspersoft/ireport/designer/resources/welcome/welcomeScreen_header_Right.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(WelcomeTopComponent.class, "WelcomeTopComponent.jLabel2.text")); // NOI18N
        jLabel2.setMinimumSize(new java.awt.Dimension(10, 61));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel1.add(jLabel2, gridBagConstraints);

        jImagePanel1.setBackground(new java.awt.Color(0, 102, 153));

        org.jdesktop.layout.GroupLayout jImagePanel1Layout = new org.jdesktop.layout.GroupLayout(jImagePanel1);
        jImagePanel1.setLayout(jImagePanel1Layout);
        jImagePanel1Layout.setHorizontalGroup(
            jImagePanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 531, Short.MAX_VALUE)
        );
        jImagePanel1Layout.setVerticalGroup(
            jImagePanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 60, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jImagePanel1, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        jPanel2.add(jSeparator1, gridBagConstraints);

        jPanelContent.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContent.setLayout(new java.awt.GridBagLayout());

        jPanelContent1.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanelContent.add(jPanelContent1, gridBagConstraints);

        jPanelseparatorNorth.setMinimumSize(new java.awt.Dimension(27, 27));
        jPanelseparatorNorth.setPreferredSize(new java.awt.Dimension(27, 27));

        org.jdesktop.layout.GroupLayout jPanelseparatorNorthLayout = new org.jdesktop.layout.GroupLayout(jPanelseparatorNorth);
        jPanelseparatorNorth.setLayout(jPanelseparatorNorthLayout);
        jPanelseparatorNorthLayout.setHorizontalGroup(
            jPanelseparatorNorthLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 27, Short.MAX_VALUE)
        );
        jPanelseparatorNorthLayout.setVerticalGroup(
            jPanelseparatorNorthLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 135, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        jPanelContent.add(jPanelseparatorNorth, gridBagConstraints);

        jPanelContent2.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanelContent.add(jPanelContent2, gridBagConstraints);

        jPanelseparatorWest.setMaximumSize(new java.awt.Dimension(32767, 27));
        jPanelseparatorWest.setMinimumSize(new java.awt.Dimension(27, 27));
        jPanelseparatorWest.setPreferredSize(new java.awt.Dimension(27, 27));

        org.jdesktop.layout.GroupLayout jPanelseparatorWestLayout = new org.jdesktop.layout.GroupLayout(jPanelseparatorWest);
        jPanelseparatorWest.setLayout(jPanelseparatorWestLayout);
        jPanelseparatorWestLayout.setHorizontalGroup(
            jPanelseparatorWestLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 210, Short.MAX_VALUE)
        );
        jPanelseparatorWestLayout.setVerticalGroup(
            jPanelseparatorWestLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 27, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        jPanelContent.add(jPanelseparatorWest, gridBagConstraints);

        jPanelseparatorEast.setMinimumSize(new java.awt.Dimension(27, 27));
        jPanelseparatorEast.setPreferredSize(new java.awt.Dimension(27, 27));

        org.jdesktop.layout.GroupLayout jPanelseparatorEastLayout = new org.jdesktop.layout.GroupLayout(jPanelseparatorEast);
        jPanelseparatorEast.setLayout(jPanelseparatorEastLayout);
        jPanelseparatorEastLayout.setHorizontalGroup(
            jPanelseparatorEastLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 291, Short.MAX_VALUE)
        );
        jPanelseparatorEastLayout.setVerticalGroup(
            jPanelseparatorEastLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 27, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        jPanelContent.add(jPanelseparatorEast, gridBagConstraints);

        jPanelContent3.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanelContent.add(jPanelContent3, gridBagConstraints);

        jPanelseparatorSouth.setMaximumSize(new java.awt.Dimension(32767, 27));
        jPanelseparatorSouth.setMinimumSize(new java.awt.Dimension(27, 27));
        jPanelseparatorSouth.setPreferredSize(new java.awt.Dimension(27, 27));

        org.jdesktop.layout.GroupLayout jPanelseparatorSouthLayout = new org.jdesktop.layout.GroupLayout(jPanelseparatorSouth);
        jPanelseparatorSouth.setLayout(jPanelseparatorSouthLayout);
        jPanelseparatorSouthLayout.setHorizontalGroup(
            jPanelseparatorSouthLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 27, Short.MAX_VALUE)
        );
        jPanelseparatorSouthLayout.setVerticalGroup(
            jPanelseparatorSouthLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 27, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        jPanelContent.add(jPanelseparatorSouth, gridBagConstraints);

        jPanelContent4.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanelContent4.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanelContent.add(jPanelContent4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(jPanelContent, gridBagConstraints);

        jScrollPane1.setViewportView(jPanel2);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(470, Short.MAX_VALUE))
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(layout.createSequentialGroup()
                    .add(59, 59, 59)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jaspersoft.ireport.designer.welcome.JImagePanel jImagePanel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelWelcome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JPanel jPanelContent1;
    private javax.swing.JPanel jPanelContent2;
    private javax.swing.JPanel jPanelContent3;
    private javax.swing.JPanel jPanelContent4;
    private javax.swing.JPanel jPanelseparatorEast;
    private javax.swing.JPanel jPanelseparatorNorth;
    private javax.swing.JPanel jPanelseparatorSouth;
    private javax.swing.JPanel jPanelseparatorWest;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link #findInstance}.
     */
    public static synchronized WelcomeTopComponent getDefault() {
        if (instance == null) {
            instance = new WelcomeTopComponent();
        }
        return instance;
    }

    /**
     * Obtain the WelcomeTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized WelcomeTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            Logger.getLogger(WelcomeTopComponent.class.getName()).warning(
                    "Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
            return getDefault();
        }
        if (win instanceof WelcomeTopComponent) {
            return (WelcomeTopComponent) win;
        }
        Logger.getLogger(WelcomeTopComponent.class.getName()).warning(
                "There seem to be multiple components with the '" + PREFERRED_ID +
                "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }

    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_ALWAYS;
    }

    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    /** replaces this in object stream */
    @Override
    public Object writeReplace() {
        return new ResolvableHelper();
    }

    @Override
    protected String preferredID() {
        return PREFERRED_ID;
    }

    final static class ResolvableHelper implements Serializable {

        private static final long serialVersionUID = 1L;

        public Object readResolve() {
            return WelcomeTopComponent.getDefault();
        }
    }
}
