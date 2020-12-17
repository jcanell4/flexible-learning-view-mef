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
package org.elsquatrecaps.mef.templates.viewcomposer;

import java.util.List;
import java.util.Map;
import org.elsquatrecaps.flexiblelearning.viewcomposer.BaseResponseViewComposer;
import org.elsquatrecaps.flexiblelearning.viewcomposer.components.ResponseViewConfigData;
import org.elsquatrecaps.flexiblelearning.viewcomposer.components.multiElements.GenericMultiElementsByTagAttributesMap;
import org.elsquatrecaps.flexiblelearning.viewcomposer.components.multiElements.GenericMultiElementsByType;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author josep
 */
public class MefComposer extends BaseResponseViewComposer{
    public MefComposer() {
    }

    public MefComposer(ResponseViewConfigData config) {
        super(config);
    }
    
    public void configModelFromElements(ModelAndView model){
        this.configElementsBySelector(model, "linkSelectors", this.getConfig().getLinks());
        this.configElementsBySelector(model, "scriptSelectors", this.getConfig().getScripts());
        this.configElementsBySelector(model, "moduleSelectors", this.getConfig().getModules());
        this.configElementsByAttributeMap(model, "mefConfigComponents", this.getConfig().getConfigComponentElements());
    }
    
    protected void configElementsByAttributeMap(ModelAndView model, String keyElement, GenericMultiElementsByTagAttributesMap elements){
        if(!elements.getElementAttributesMapList().isEmpty()){
            Map<String, Object> map = model.getModel();
            if(map.containsKey(keyElement)){
                List<String> list = (List<String>) map.get(keyElement);
                list.addAll(elements.getElementAttributesMapList());
                model.addObject(keyElement, list);            
            }else{
                model.addObject(keyElement, elements.getElementAttributesMapList());            
            }        
        }
    }

    protected void configElementsBySelector(ModelAndView model, String keyElement, GenericMultiElementsByType elements){
        if(!elements.getSelectors().isEmpty()){
            Map<String, Object> map = model.getModel();
            if(map.containsKey(keyElement)){
                model.addObject(keyElement, ((String) map.get(keyElement))
                        .concat(" or ").concat(elements.getSelectors()));            
            }else{
                model.addObject(keyElement, elements.getSelectors());            
            }  
        }
    }

}
