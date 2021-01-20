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
import org.elsquatrecaps.flexiblelearning.learningstate.LearningState;
import org.elsquatrecaps.flexiblelearning.viewcomposer.BaseResponseViewComposer;
import org.elsquatrecaps.flexiblelearning.viewcomposer.components.ResponseViewConfigData;
import org.elsquatrecaps.mef.templates.viewcomposer.components.miscelanea.ClueSetConfig;
import org.elsquatrecaps.mef.data.miscelanea.DefaultClue;
import org.elsquatrecaps.mef.templates.viewcomposer.components.miscelanea.MefClueComponent;
import org.elsquatrecaps.mef.templates.viewcomposer.components.miscelanea.MefClueConfigData;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author josep
 */
public class DefaultClueMefComposer extends BaseResponseViewComposer{
    
    public DefaultClueMefComposer() {
    }

    public DefaultClueMefComposer(ResponseViewConfigData config) {
        super(config);
    }

    @Override
    protected void configModelFromConfigurarionData(ModelAndView model){
        MefClueComponent mefClueComponent = (MefClueComponent)this.getConfig();
        MefClueConfigData mefClueConfigData = mefClueComponent.getClueConfigData();
        ClueSetConfig  clueSetConfig = new ClueSetConfig(mefClueConfigData.getClueSetId()
                , this.selectClueIteratorType(mefClueConfigData.getAllowedClueIteratorTypes()));
        model.addObject(mefClueComponent.getClueConfigDataKeyInTemplate(), clueSetConfig);
    }
    
    private String selectClueIteratorType(List<String> allowedClueIteratorTypes){
        //Podria seleccionar en funció de les dades adicionals (learningState per exemple).
        //En aquest cas retorna sempre el primer iterador dels disponibles.
        return allowedClueIteratorTypes.get(0);
    }
    
    private LearningState getLearningState(){
        LearningState ret;
        ret = (LearningState) this.getAdditionalData("learnindState");
        return ret;
    }
}
