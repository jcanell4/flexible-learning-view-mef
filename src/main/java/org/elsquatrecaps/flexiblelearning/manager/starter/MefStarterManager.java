/*
 * Copyright 2021 Grup de millora MetFlex.
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
package org.elsquatrecaps.flexiblelearning.manager.starter;

import org.elsquatrecaps.flexiblelearning.learningproposal.ActivityConfiguration;
import org.elsquatrecaps.flexiblelearning.learningproposal.LearningProposalConfiguration;
import org.elsquatrecaps.flexiblelearning.manager.GenericManager;
import org.elsquatrecaps.flexiblelearning.learningstate.LearningState;
import org.elsquatrecaps.flexiblelearning.viewcomposer.ResponseViewComposer;
import org.elsquatrecaps.flexiblelearning.viewcomposer.ResponseViewComposerfactory;
import org.elsquatrecaps.flexiblelearning.viewcomposer.components.ResponseViewConfigData;
import org.elsquatrecaps.mef.learningproposal.MefActivityConfiguration;
import org.elsquatrecaps.mef.learningproposal.MefLearningProposalConfiguration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

/**
 *
 * @author josep
 * @param <PMLS>
 * @param <PMLP>
 * @param <PMA>
 */
public class MefStarterManager<PMLS extends PagingAndSortingRepository<LearningState, String>&QueryByExampleExecutor<LearningState>, 
        PMLP extends PagingAndSortingRepository<MefLearningProposalConfiguration, String>&QueryByExampleExecutor<MefLearningProposalConfiguration>, 
        PMA extends PagingAndSortingRepository<MefActivityConfiguration, String>&QueryByExampleExecutor<MefActivityConfiguration>>
        extends GenericManager<LearningState, PMLS, MefLearningProposalConfiguration, PMLP, MefActivityConfiguration, PMA>         
        implements StarterManager<LearningState, PMLS, MefLearningProposalConfiguration, PMLP, MefActivityConfiguration, PMA>{

    public ModelAndView start(String studentId, String learningProposalId){
        ModelAndView modelAndView = null;
        
        LearningState ls = getLearningState(new LearningState(studentId, learningProposalId));
        MefLearningProposalConfiguration lp = getLearningProposalConfiguration(learningProposalId);
        MefActivityConfiguration ac = getActivityConfiguration(ls.getCurrentActivityId());
        modelAndView = getModelFromLearningProposalConfiguration(lp, ac, ls);
        return modelAndView;
    }

    protected ModelAndView getModelFromLearningProposalConfiguration(MefLearningProposalConfiguration learningProposalConfiguration, 
            MefActivityConfiguration activityConfiguration, 
            LearningState learningState) {
        ModelAndView model;
        ResponseViewConfigData configData = learningProposalConfiguration.getResponseViewConfigData();
        ResponseViewComposer responseViewComposer = ResponseViewComposerfactory.getResponseViewComposerInstance(configData);
        responseViewComposer.addAdditionalData("learningState", learningState);
        model = responseViewComposer.getResponseView();
        ResponseViewConfigData activityConfigData = activityConfiguration.getResponseViewComponent();
        
        responseViewComposer.addComponent("activityComponent", activityConfigData, model);
        
        
        return model;
    }
}
