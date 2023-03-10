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
import com.jaspersoft.ireport.designer.editor.ExpObjectCellRenderer;
import com.jaspersoft.ireport.designer.sheet.Tag;
import com.jaspersoft.ireport.designer.utils.Misc;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.TitledBorder;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JRVariable;
import net.sf.jasperreports.engine.design.JRDesignDataset;
import net.sf.jasperreports.engine.design.JRDesignExpression;

/**
 *
 * @author  gtoffoli
 */
public class GroupPanel extends javax.swing.JPanel {
    
    public static final int GROUP = 1;
    public static final int MEASURE = 2;
    
    int type = GROUP;
    
    /** Creates new form GroupPanel */
    public GroupPanel(int type)
    {
        initComponents();
        jComboBoxGroup.setRenderer( new ExpObjectCellRenderer());
        this.type = type;
        
        if (type == GROUP)
        {
            jLabelGroupMeasure.setText(I18n.getString("GroupPanel.Label.Group"));
            jLabelGroupByFunction.setText(I18n.getString("GroupPanel.Label.GroupBy"));
            jLabelGroupByFunction.setEnabled(false);
            jComboBoxGroupBy.setEnabled(false);
        }
        else
        {
            jLabelGroupMeasure.setText(I18n.getString("GroupPanel.Label.Measure"));
            jLabelGroupByFunction.setText(I18n.getString("GroupPanel.Label.Function"));
            jLabelGroupByFunction.setEnabled(true);
            jComboBoxGroupBy.setEnabled(true);
        }
    }
    
    public void setTitle(String title)
    {
        ((TitledBorder)this.getBorder()).setTitle(title);
    }
    
    public void setDataset(JRDesignDataset dataset, boolean addNullValue)
    {
        // Add the parameters...
        if (addNullValue) jComboBoxGroup.addItem("");
        
        List fields = dataset.getFieldsList();
        for (int i=0; i<fields.size(); ++i)
        {
            jComboBoxGroup.addItem(fields.get(i));
        }
        
        // Add the parameters...
        List parameters = dataset.getParametersList();
        for (int i=0; i<parameters.size(); ++i)
        {
            jComboBoxGroup.addItem(parameters.get(i));
        }
        
        List variables = dataset.getVariablesList();
        for (int i=0; i<variables.size(); ++i)
        {
            jComboBoxGroup.addItem(variables.get(i));
        }
    }

    boolean isUsed() {
        return !(jComboBoxGroup.getSelectedIndex() == 0 &&
            jComboBoxGroup.getSelectedItem().equals(""));
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelGroupMeasure = new javax.swing.JLabel();
        jComboBoxGroup = new javax.swing.JComboBox();
        jLabelGroupByFunction = new javax.swing.JLabel();
        jComboBoxGroupBy = new javax.swing.JComboBox();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), I18n.getString("GroupPanel.border.title"))); // NOI18N

        jLabelGroupMeasure.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelGroupMeasure.setText(I18n.getString("GroupPanel.jLabelGroupMeasure.text")); // NOI18N

        jComboBoxGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxGroupActionPerformed(evt);
            }
        });

        jLabelGroupByFunction.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelGroupByFunction.setText(I18n.getString("GroupPanel.jLabelGroupByFunction.text")); // NOI18N
        jLabelGroupByFunction.setEnabled(false);

        jComboBoxGroupBy.setEnabled(false);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jLabelGroupByFunction, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jLabelGroupMeasure, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jComboBoxGroupBy, 0, 196, Short.MAX_VALUE)
                    .add(jComboBoxGroup, 0, 196, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelGroupMeasure)
                    .add(jComboBoxGroup, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelGroupByFunction)
                    .add(jComboBoxGroupBy, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxGroupActionPerformed
        
        
        if (type == GROUP)
        {
            jComboBoxGroupBy.removeAllItems();
            List list = getGroupByValues();
            if (list.size() > 0)
            {
            
                for (int i=0; i<list.size(); ++i)
                {
                    jComboBoxGroupBy.addItem(list.get(i));
                }
                jComboBoxGroupBy.setSelectedItem(0);
            }
            jComboBoxGroupBy.setEnabled(list.size() > 0);
            jLabelGroupByFunction.setEnabled(list.size() > 0);
        }
        else
        {
            jComboBoxGroupBy.removeAllItems();
            List list = getFunctions();
            Misc.updateComboBox(jComboBoxGroupBy, list, false);
            if (list.size() > 0)
            {
                jComboBoxGroupBy.setSelectedIndex(0);
            }
        }

        updateUI();
    }//GEN-LAST:event_jComboBoxGroupActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBoxGroup;
    private javax.swing.JComboBox jComboBoxGroupBy;
    private javax.swing.JLabel jLabelGroupByFunction;
    private javax.swing.JLabel jLabelGroupMeasure;
    // End of variables declaration//GEN-END:variables
    
    
    public List getGroupByValues()
    {
        String classtype = "java.lang.String";
        List groupByValues = new ArrayList();
        
        groupByValues.add(new Tag(I18n.getString("GroupPanel.Label.Unique"),I18n.getString("GroupPanel.Label.Unique")));
        
        Object obj = jComboBoxGroup.getSelectedItem();
        
        if (obj instanceof JRField)
        {
            classtype = ((JRField)obj).getValueClassName();
        }
        else if (obj instanceof JRParameter)
        {
            classtype = ((JRParameter)obj).getValueClassName();
        }
        else if (obj instanceof JRVariable)
        {
            classtype = ((JRVariable)obj).getValueClassName();
        }
        
        try {
            Class clazz = this.getClass().forName( classtype );
            if ( java.util.Date.class.isAssignableFrom( clazz ))
            {
                
                groupByValues.add(new Tag(I18n.getString("Global.ComboBox.Year"),I18n.getString("Global.ComboBox.Year")));
                groupByValues.add(new Tag(I18n.getString("Global.ComboBox.Month"),I18n.getString("Global.ComboBox.Month")));
                groupByValues.add(new Tag(I18n.getString("Global.ComboBox.Week"),I18n.getString("Global.ComboBox.Week")));
                groupByValues.add(new Tag(I18n.getString("Global.ComboBox.Day"),I18n.getString("Global.ComboBox.Day")));
            }
        } catch (Exception ex)
        {}
        
      return groupByValues;
    }
    
    public List getFunctions()
    {
        String classtype = "java.lang.String";
        List functions = new ArrayList();
        
        functions.add(new Tag(new Byte(JRVariable.CALCULATION_COUNT),I18n.getString("GroupPanel.Label.Count")));
        
        Object obj = jComboBoxGroup.getSelectedItem();
        
        if (obj instanceof JRField)
        {
            classtype = ((JRField)obj).getValueClassName();
        }
        else if (obj instanceof JRParameter)
        {
            classtype = ((JRParameter)obj).getValueClassName();
        }
        else if (obj instanceof JRVariable)
        {
            classtype = ((JRVariable)obj).getValueClassName();
        }
        
        try {
            Class clazz = this.getClass().forName( classtype );
            
            if (java.lang.Number.class.isAssignableFrom( clazz ))
            {
                functions.add(new Tag(new Byte(JRVariable.CALCULATION_SUM),I18n.getString("GroupPanel.Function.Sum")));
                functions.add(new Tag(new Byte(JRVariable.CALCULATION_COUNT),I18n.getString("GroupPanel.Function.Count")));
                functions.add(new Tag(new Byte(JRVariable.CALCULATION_DISTINCT_COUNT),I18n.getString("GroupPanel.Function.DistinctCount")));
                functions.add(new Tag(new Byte(JRVariable.CALCULATION_AVERAGE),I18n.getString("GroupPanel.Function.Average")));
                functions.add(new Tag(new Byte(JRVariable.CALCULATION_STANDARD_DEVIATION),I18n.getString("GroupPanel.Function.StandardDeviation")));
                functions.add(new Tag(new Byte(JRVariable.CALCULATION_VARIANCE),I18n.getString("GroupPanel.Function.Variance")));
            }
            
            if ( java.util.Date.class.isAssignableFrom( clazz ) || 
                 java.lang.Number.class.isAssignableFrom( clazz ))
            {
                functions.add(new Tag(new Byte(JRVariable.CALCULATION_LOWEST),I18n.getString("GroupPanel.Function.Lowest")));
                functions.add(new Tag(new Byte(JRVariable.CALCULATION_HIGHEST),I18n.getString("GroupPanel.Function.Highest")));
            }
            
            
        } catch (Exception ex)
        {}
        
        functions.add(new Tag(new Byte(JRVariable.CALCULATION_FIRST),I18n.getString("GroupPanel.Function.First")));
        functions.add(new Tag(new Byte(JRVariable.CALCULATION_NOTHING),I18n.getString("GroupPanel.Function.Nothing")));
        
      return functions;
    }
    
    public String getGroupMeasureName()
    {
        Object obj = jComboBoxGroup.getSelectedItem();
        if (obj instanceof JRField)
        {
            return ((JRField)obj).getName();
        }
        else if (obj instanceof JRParameter)
        {
            return ((JRParameter)obj).getName();
        }
        else if (obj instanceof JRVariable)
        {
            return ((JRVariable)obj).getName();
        }
        
        return ""+obj;
    }
    
    public String getExpression(String groupByType)
    {
        String expression = "";
        Object obj = jComboBoxGroup.getSelectedItem();
        
        if (obj instanceof JRField)
        {
            expression = "$F{" + ((JRField)obj).getName() + "}";
        }
        else if (obj instanceof JRParameter)
        {
            expression = "$P{" + ((JRParameter)obj).getName() + "}";
        }
        else if (obj instanceof JRVariable)
        {
            expression = "$V{" + ((JRVariable)obj).getName() + "}";
        }
        
        if (groupByType != null)
        {
            if (groupByType.equals(I18n.getString("Global.ComboBox.Year")))
            {
                return "(new SimpleDateFormat(\"yyyy\")).format("+expression+")";
            }
            else if (groupByType.equals(I18n.getString("Global.ComboBox.Month")))
            {
                return "(new SimpleDateFormat(\"yyyy-MM\")).format("+expression+")";
            }
            else if (groupByType.equals(I18n.getString("Global.ComboBox.Week")))
            {
                return "(new SimpleDateFormat(\"yyyy-ww\")).format("+expression+")";
            }
            else if (groupByType.equals(I18n.getString("Global.ComboBox.Day")))
            {
                return "(new SimpleDateFormat(\"yyyy-MM-dd\")).format("+expression+")";
            }
        }
        
        return expression;
    }
    
    public String getExpressionClass(String groupByType)
    {
        Object obj = jComboBoxGroup.getSelectedItem();
        if (groupByType !=null && !groupByType.equals(I18n.getString("GroupPanel.Function.Unique")) )
        {
            return "java.lang.String";
        }
        
        if (obj instanceof JRField)
        {
            return ((JRField)obj).getValueClassName();
        }
        else if (obj instanceof JRParameter)
        {
            return ((JRParameter)obj).getValueClassName();
        }
        else if (obj instanceof JRVariable)
        {
            return ((JRVariable)obj).getValueClassName();
        }
        
        return "java.lang.String";
     }
    
    public JRDesignExpression getDesignExpression()
    {
        Object obj = jComboBoxGroup.getSelectedItem();
        String groupByType = null;
        if (type == GROUP)
        {
           Object gb = jComboBoxGroupBy.getSelectedItem();
           if (gb != null && gb instanceof Tag)
           {
               groupByType = ((Tag)gb).getValue() + "";
           }
           gb = null;
        }
        return Misc.createExpression(getExpressionClass(groupByType), getExpression(groupByType));
    }
    
    public byte getCalculationType()
    {
       byte b = JRVariable.CALCULATION_COUNT;
       Object gb = jComboBoxGroupBy.getSelectedItem();
       if (gb != null && gb instanceof Tag)
       {
           b = (Byte)((Tag)gb).getValue(); //(Byte)((Tag)gb).getValue();
       }
       return b;
    }
    
}
