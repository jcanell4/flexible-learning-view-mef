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
package org.elsquatrecaps.mef.templates.viewcomposer.components.miscelanea;

import java.util.HashMap;
import java.util.Map;
import org.elsquatrecaps.flexiblelearning.viewcomposer.components.BaseResponseViewComponentMultiFragment;
import org.elsquatrecaps.flexiblelearning.viewcomposer.components.ResponseViewComponent;
import org.elsquatrecaps.flexiblelearning.viewcomposer.components.ResponseViewComponentConfigurator;
import org.elsquatrecaps.flexiblelearning.viewcomposer.components.multiElements.GenericMultiElementsByTagAttributesMap;
import org.elsquatrecaps.flexiblelearning.viewcomposer.components.multiElements.GenericMultiElementsByType;
import org.elsquatrecaps.mef.templates.viewcomposer.DefaultClueMefComposer;
import org.springframework.data.annotation.PersistenceConstructor;

/**
 *
 * @author josep
 */
@ResponseViewComponentConfigurator(responseViewComposerClass = DefaultClueMefComposer.class)
public class MefClueComponent extends BaseResponseViewComponentMultiFragment{

    public MefClueComponent() {
        this(null);
    }
    
    public MefClueComponent(String clueSetId) {
        super("mef/mef_clue_for_act", new HashMap<String, String>(){{
            put("clueButton", "clueButton");
            put("clueForm", "clueForm");
        }});
        
        this.getConfigurationDataMap().put("clueComponentData", new MefClueConfigData(clueSetId));
    }
    
    @PersistenceConstructor
    protected MefClueComponent(Map<String, String> fragments, Map<String, Object> configurationDataMap, 
           Map<String, ResponseViewComponent> componentMap, GenericMultiElementsByType links, 
           GenericMultiElementsByType scripts, GenericMultiElementsByType modules, 
           GenericMultiElementsByTagAttributesMap configComponentElements){
        super("mef/mef_clue_for_act", fragments, configurationDataMap, componentMap, 
                links, scripts, modules, configComponentElements);
    }
    
    public MefClueConfigData getClueConfigData(){
        return ((MefClueConfigData)this.getConfigurationDataMap().get("clueComponentData"));
    }
    
    public String getClueConfigDataKeyInTemplate(){
        return "clueComponentData";
    }    

    public String getInfoMessageKeyInTemplate(){
        return "infoMessage";
    }    

    public String getCurrentClueKeyInTemplate(){
        return "currentClue";
    }    
}
