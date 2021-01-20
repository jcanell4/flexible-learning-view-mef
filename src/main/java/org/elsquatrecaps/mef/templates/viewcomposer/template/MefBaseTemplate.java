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
package org.elsquatrecaps.mef.templates.viewcomposer.template;

import org.elsquatrecaps.mef.templates.viewcomposer.components.progessbar.MefLinialProgressbarComponent;
import java.util.List;
import java.util.Map;
import org.elsquatrecaps.flexiblelearning.viewcomposer.components.BaseResponseViewConfigData;
import org.elsquatrecaps.flexiblelearning.viewcomposer.components.ConfigurationData;
import org.elsquatrecaps.flexiblelearning.viewcomposer.components.ResponseViewConfigData;
import org.elsquatrecaps.flexiblelearning.viewcomposer.components.multiElements.GenericMultiElementsByTagAttributesMap;
import org.elsquatrecaps.flexiblelearning.viewcomposer.components.multiElements.GenericMultiElementsByType;
import org.springframework.data.annotation.PersistenceConstructor;

/**
 *
 * @author josep
 */
public class MefBaseTemplate extends BaseResponseViewConfigData{
    private static final String LEARNING_PROPOSAL_KEY = "learningProposal";
    private static final String NAV_ELEMENTS_KEY = "navComponentData";
    private static final String NAV_PROGRESS_BAR_COMPONENT_KEY = "progressbarComponent";
    private static final String TEMPLATE_NAME = "mef/mef_base";

    public MefBaseTemplate() {
        super();
        this.setTemplateName(TEMPLATE_NAME);
        this.getConfigurationDataMap().put(LEARNING_PROPOSAL_KEY, new MefLearningProposalConfigData());
        this.getConfigurationDataMap().put(NAV_ELEMENTS_KEY, new MefNavConfigData());
        
    }
    
    @PersistenceConstructor
    protected MefBaseTemplate(String templateName, Map<String, ConfigurationData> configurationDataMap, 
            Map<String, ResponseViewConfigData> componentMap, GenericMultiElementsByType links, 
           GenericMultiElementsByType scripts, GenericMultiElementsByType modules, GenericMultiElementsByTagAttributesMap configComponentElements) {
        super(templateName, configurationDataMap, componentMap, links, scripts, modules, configComponentElements);
    }

    public void setLearningProposal(String id, String description, String keywords, List<String> authors){
        this.getConfigurationDataMap().put(LEARNING_PROPOSAL_KEY, new MefLearningProposalConfigData(id, description, keywords, authors));
    }
    
    public void setInfoTextToNavElement(String infoText){
        MefNavConfigData ne = (MefNavConfigData) this.getConfigurationDataMap().get(NAV_ELEMENTS_KEY);
        ne.setInfoText(infoText);
    }

    public void setSummaryToNavElement(String summary){
        MefNavConfigData ne = (MefNavConfigData) this.getConfigurationDataMap().get(NAV_ELEMENTS_KEY);
        ne.setSummary(summary);
    }

    public void setVideoToNavElement(VideoResource videoResource){
        MefNavConfigData ne = (MefNavConfigData) this.getConfigurationDataMap().get(NAV_ELEMENTS_KEY);
        ne.setVideo(videoResource);
    }

    public void addRelatedResourceToNavElement(ItemResource itemResource){
        MefNavConfigData ne = (MefNavConfigData) this.getConfigurationDataMap().get(NAV_ELEMENTS_KEY);
        ne.addRelatedResource(itemResource);
    }
    
    public void setLearningProposalNameToNavElement(String name){
        MefNavConfigData ne = (MefNavConfigData) this.getConfigurationDataMap().get(NAV_ELEMENTS_KEY);
        ne.setLearningProposalName(name);
    }

    public void addNavProgressBarComponent(){
        this.getComponentMap().put(NAV_PROGRESS_BAR_COMPONENT_KEY, new MefLinialProgressbarComponent());
    }
    
    public void addNavProgressBarComponent(MefLinialProgressbarComponent mefLinialProgressbarComponent){
        this.getComponentMap().put(NAV_PROGRESS_BAR_COMPONENT_KEY, mefLinialProgressbarComponent);
    }
    
}
