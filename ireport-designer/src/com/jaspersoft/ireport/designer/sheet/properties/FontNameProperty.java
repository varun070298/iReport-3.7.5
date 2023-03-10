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
package com.jaspersoft.ireport.designer.sheet.properties;

import com.jaspersoft.ireport.designer.IReportManager;
import com.jaspersoft.ireport.designer.ReportClassLoader;
import com.jaspersoft.ireport.designer.sheet.Tag;
import com.jaspersoft.ireport.designer.sheet.editors.ComboBoxPropertyEditor;
import com.jaspersoft.ireport.designer.undo.ObjectPropertyUndoableEdit;
import com.jaspersoft.ireport.locale.I18n;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.beans.PropertyEditor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;
import net.sf.jasperreports.engine.JRFont;
import net.sf.jasperreports.engine.base.JRBaseStyle;
import net.sf.jasperreports.engine.util.JRFontUtil;
import org.openide.nodes.PropertySupport;

/**
 * Class to manage the JRBaseStyle.PROPERTY_FONT_NAME property
 */
public class FontNameProperty extends PropertySupport.ReadWrite implements PreferenceChangeListener
{
    // FIXME: refactorize this
    private final JRFont font;
    PropertyEditor editor = null;

    @SuppressWarnings("unchecked")
    public FontNameProperty(JRFont font)
    {
        super(JRBaseStyle.PROPERTY_FONT_NAME, String.class,
              I18n.getString("Global.Property.Fontname"),
              I18n.getString("Global.Property.FontnameDetails"));
        this.font = font;

        setValue("canEditAsText",true);
        setValue("oneline",true);
        setValue("suppressCustomEditor",true);

        IReportManager.getPreferences().addPreferenceChangeListener(this);
    }

    public Object getValue() throws IllegalAccessException, InvocationTargetException {
        return font.getFontName();
    }

    public void setValue(Object val) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        
        if (val == null || val instanceof String)
        {
            String oldValue = font.getOwnFontName();
            
            String newValue =   (String)val;
            
            font.setFontName(newValue);

            ObjectPropertyUndoableEdit urob =
                    new ObjectPropertyUndoableEdit(
                        font,
                        "FontName", 
                        String.class,
                        oldValue,newValue);
            // Find the undoRedo manager...
            IReportManager.getInstance().addUndoableEdit(urob);
        }
    }

    @Override
    public boolean isDefaultValue() {
        return font.getOwnFontName() == null;
    }

    @Override
    public void restoreDefaultValue() throws IllegalAccessException, InvocationTargetException {
        setValue(null);
    }

    @Override
    public boolean supportsDefaultValue() {
        return true;
    }

    private void updateTags()
    {
        java.util.List classes = new ArrayList();
        ClassLoader oldCL = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(new ReportClassLoader(IReportManager.getReportClassLoader()));

        Collection extensionFonts = JRFontUtil.getFontFamilyNames();
        for(Iterator it = extensionFonts.iterator(); it.hasNext();)
        {
            String fname = (String)it.next();
            classes.add(new Tag(fname));
        }

        Thread.currentThread().setContextClassLoader(oldCL);


        if (IReportManager.getPreferences().getBoolean("showSystemFonts", true))
        {

            String[] names = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
            //classes.add(new Tag("sansserif","SansSerif"));

            classes.add(new Tag(null,"__________"));

            for (int i = 0; i < names.length; i++) {
                    String name = names[i];
                    classes.add(new Tag(name));
            }

        }

        if (editor == null)
        {
            editor = new ComboBoxPropertyEditor(true, classes);
        }
        else
        {
            ((ComboBoxPropertyEditor)editor).setTagValues(classes);
        }



    }

    @Override
    @SuppressWarnings("unchecked")
    public PropertyEditor getPropertyEditor() {

        if (editor == null) {
            updateTags();
        }
        return editor;
    }

    public void preferenceChange(PreferenceChangeEvent evt) {
        if (evt == null || evt.getKey() == null || evt.getKey().equals( IReportManager.IREPORT_CLASSPATH)|| evt.getKey().equals("fontExtensions"))
        {
            // Refresh the array...
            updateTags();
        }
    }

}
