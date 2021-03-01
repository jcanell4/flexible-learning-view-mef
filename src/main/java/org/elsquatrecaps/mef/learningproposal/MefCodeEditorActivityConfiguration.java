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
package org.elsquatrecaps.mef.learningproposal;

import java.util.Map;
import org.elsquatrecaps.flexiblelearning.eventcomposer.components.ActivityEventProcessorConfiguration;
import org.elsquatrecaps.flexiblelearning.learningproposal.ActivityConfiguration;
import org.elsquatrecaps.flexiblelearning.viewcomposer.components.ResponseViewComponent;
import org.elsquatrecaps.flexiblelearning.viewcomposer.components.ResponseViewComponentConfigurator;
import org.elsquatrecaps.flexiblelearning.viewcomposer.components.multiElements.GenericMultiElementsByTagAttributesMap;
import org.elsquatrecaps.flexiblelearning.viewcomposer.components.multiElements.GenericMultiElementsByType;
import org.elsquatrecaps.flexiblelearning.viewcomposer.components.multiElements.elements.GenericElementByType;
import org.elsquatrecaps.mef.templates.viewcomposer.BasicMefComposer;
import org.elsquatrecaps.mef.templates.viewcomposer.components.codeeditor.CodeActivity;
import org.elsquatrecaps.mef.templates.viewcomposer.components.codeeditor.MefCodeEditorConfigData;
import org.springframework.data.annotation.PersistenceConstructor;

/**
 *
 * @author josep
 */
@ResponseViewComponentConfigurator(
        responseViewComposerClass = BasicMefComposer.class
)
public class MefCodeEditorActivityConfiguration extends ActivityConfiguration{

    public MefCodeEditorActivityConfiguration(String id) {
        super(id, "mef/mef_code_act", "activityComponent");
        this.getConfigurationDataMap().put("activityComponentData", new MefCodeEditorConfigData());
        this.getLinks().add(new GenericElementByType("jquery-ui"));
        this.getLinks().add(new GenericElementByType("veetsplit"));
        this.getLinks().add(new GenericElementByType("codemirror"));
        this.getLinks().add(new GenericElementByType("mef_activity"));
        this.getScripts().add(new GenericElementByType("jquery-ui"));
        this.getScripts().add(new GenericElementByType("veetsplit"));
        this.getScripts().add(new GenericElementByType("codemirror"));
        this.getModules().add(new GenericElementByType("mef_code_module"));
        this.getModules().add(new GenericElementByType("mef_dialog_module"));  
    }
    
    @PersistenceConstructor
    protected MefCodeEditorActivityConfiguration(String id, Map<String, Object> configurationDataMap, 
           Map<String, ResponseViewComponent> componentMap, GenericMultiElementsByType links, 
           GenericMultiElementsByType scripts, GenericMultiElementsByType modules, 
           GenericMultiElementsByTagAttributesMap configComponentElements){
        super(id, "mef/mef_code_act", "activityComponent", configurationDataMap, 
                componentMap, links, scripts, modules, configComponentElements);
    }
    
    public CodeActivity getCodeActivity(){
        return getActivity();
    }

    public CodeActivity getActivity(){
        return ((MefCodeEditorConfigData)this.getConfigurationDataMap().get("activityComponentData")).getCodeActivity();
    }

}
