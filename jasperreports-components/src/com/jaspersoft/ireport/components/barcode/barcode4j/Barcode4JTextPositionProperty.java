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
package com.jaspersoft.ireport.components.barcode.barcode4j;

import com.jaspersoft.ireport.designer.IReportManager;
import com.jaspersoft.ireport.designer.sheet.Tag;
import com.jaspersoft.ireport.designer.sheet.editors.ComboBoxPropertyEditor;
import com.jaspersoft.ireport.designer.undo.ObjectPropertyUndoableEdit;
import com.jaspersoft.ireport.locale.I18n;
import java.beans.PropertyEditor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import net.sf.jasperreports.components.barcode4j.BarcodeComponent;
import org.openide.nodes.PropertySupport;


public final class Barcode4JTextPositionProperty  extends PropertySupport
{
        private BarcodeComponent component;
        private ComboBoxPropertyEditor editor;

        @SuppressWarnings("unchecked")
        public Barcode4JTextPositionProperty(BarcodeComponent component)
        {
            // TODO: Replace WhenNoDataType with the right constant
            super( BarcodeComponent.PROPERTY_TEXT_POSITION,String.class,
                    I18n.getString("barcode4j.property.textPosition.name"),
                    I18n.getString("barcode4j.property.textPosition.description"), true, true);
            this.component = component;
            setValue("suppressCustomEditor", Boolean.TRUE);
        }

        @Override
        @SuppressWarnings("unchecked")
        public PropertyEditor getPropertyEditor() {

            if (editor == null)
            {

                editor = new ComboBoxPropertyEditor(false, getListOfTags());
            }
            return editor;
        }

        public Object getValue() throws IllegalAccessException, InvocationTargetException {
            return component.getTextPosition();
        }

        public void setValue(Object val) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (val == null || val instanceof String)
            {
                String oldValue = component.getTextPosition();
                String newValue = (String)val;
                component.setTextPosition(newValue);

                ObjectPropertyUndoableEdit urob =
                        new ObjectPropertyUndoableEdit(
                            component,
                            "TextPosition",
                            String.class,
                            oldValue,newValue);
                // Find the undoRedo manager...
                IReportManager.getInstance().addUndoableEdit(urob);
            }
        }

    private java.util.ArrayList getListOfTags()
    {
        ArrayList tags = new java.util.ArrayList();
        tags.add(new Tag(null, "<Default>"));
        tags.add(new Tag("none", "None"));
        tags.add(new Tag("bottom", "Bottom"));
        tags.add(new Tag("top", "Top"));

        return tags;
    }


    @Override
    public void restoreDefaultValue() throws IllegalAccessException, InvocationTargetException {
        setValue(null);
    }

    @Override
    public boolean supportsDefaultValue() {
        return true;
    }

    @Override
    public boolean isDefaultValue() {
        return component.getTextPosition() == null;
    }
}

