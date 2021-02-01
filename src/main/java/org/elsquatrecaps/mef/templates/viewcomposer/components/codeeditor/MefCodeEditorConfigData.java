/*
 * Copyright 2020 Grup de millora MetFlex.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.elsquatrecaps.mef.templates.viewcomposer.components.codeeditor;

import java.io.Serializable;
import org.springframework.data.annotation.PersistenceConstructor;

/**
 *
 * @author josep
 */
public class MefCodeEditorConfigData  implements Serializable{
    private final CodeActivity codeActivity;

    public MefCodeEditorConfigData() {
        this.codeActivity = new CodeActivity();
    }

    @PersistenceConstructor
    protected MefCodeEditorConfigData(CodeActivity codeActivity) {
        this.codeActivity = codeActivity;
    }

    public CodeActivity getCodeActivity() {
        return codeActivity;
    }    

    public CodeActivity getActivity() {
        return codeActivity;
    }    
}
