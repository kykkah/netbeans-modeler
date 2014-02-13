/**
 * Copyright [2014] Gaurav Gupta
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.netbeans.modeler.properties.entity.custom.editor.combobox.internal;

import java.beans.PropertyEditorSupport;
import org.netbeans.modeler.core.ModelerFile;
import org.netbeans.modeler.properties.entity.custom.editor.combobox.client.listener.ComboBoxListener;
import org.netbeans.modeler.properties.entity.custom.editor.combobox.client.entity.ComboBoxValue;
import org.openide.explorer.propertysheet.ExPropertyEditor;
import org.openide.explorer.propertysheet.InplaceEditor;
import org.openide.explorer.propertysheet.PropertyEnv;

public class ComboBoxPropertyEditorSupport extends PropertyEditorSupport implements ExPropertyEditor, InplaceEditor.Factory {

    private String defaultText;
    private ComboBoxListener comboBoxListener;
    private ModelerFile modelerFile;

    public ComboBoxPropertyEditorSupport(ModelerFile modelerFile, final ComboBoxListener comboBoxListener) {
        this.modelerFile = modelerFile;
        this.defaultText = comboBoxListener.getDefaultText();
        this.comboBoxListener = comboBoxListener;
    }

    @Override
    public String getAsText() {
        String text = comboBoxListener.getItem() == null ? "" : comboBoxListener.getItem().getDisplayValue() == null ? "" : comboBoxListener.getItem().getDisplayValue();
        return text;

    }

//    @Override
//    public void setAsText(String s) {
//         System.out.println("setAsText : " + s);
//         setValue(s);
//    }
    @Override
    public void attachEnv(PropertyEnv env) {
        env.registerInplaceEditorFactory(this);
    }
    private InplaceEditor ed = null;

    @Override
    public InplaceEditor getInplaceEditor() {
        if (ed == null) {
            ed = new ComboBoxInplaceEditor(modelerFile, comboBoxListener);
        }
        return ed;
    }
}
