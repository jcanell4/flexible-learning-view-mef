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

import java.util.Map;
import org.elsquatrecaps.flexiblelearning.viewcomposer.components.multiElements.elements.GenericElementTagAttributesMap;
import org.springframework.data.annotation.PersistenceConstructor;

/**
 *
 * @author josep
 */
public class MefCodeEditorModeConfig extends GenericElementTagAttributesMap{
    public static final String TYPE_ATTR = "data-type"; 
    public static final String MODE_ATTR = "data-mode-name"; 
    public static final String MODE_URL_ATTR = "data-mode-url"; 

    public MefCodeEditorModeConfig() {
        this.setAttribute(ID_ATTR, "codemirrorMode");
        this.setAttribute(TYPE_ATTR, "codemirror");
    }
    
    public MefCodeEditorModeConfig(String modeName) {
        this();
        this.setAttribute(MODE_ATTR, modeName);
    }
    
    public MefCodeEditorModeConfig(String modeName, String modeUrl) {
        this(modeName);
        this.setAttribute(MODE_URL_ATTR, modeUrl);
    }
    
    @PersistenceConstructor
    protected MefCodeEditorModeConfig(Map<String, String> map){        
        super(map);
    }
    
    public void setModeName(String name){
        setAttribute(MODE_ATTR, name);
    }

    public void setModeUrl(String url){
        setAttribute(MODE_ATTR, url);
    }
}
