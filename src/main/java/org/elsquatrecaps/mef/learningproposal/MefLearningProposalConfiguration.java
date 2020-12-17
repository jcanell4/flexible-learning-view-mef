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

import org.elsquatrecaps.mef.templates.viewcomposer.template.MefBaseTemplate;
import java.util.List;
import org.elsquatrecaps.flexiblelearning.learningproposal.LearningProposalConfiguration;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author josep
 */
@Document
public class MefLearningProposalConfiguration extends LearningProposalConfiguration<MefBaseTemplate>{
    
    public MefLearningProposalConfiguration(String id, String description, String keywords, List<String> authors){
      super(id, new MefBaseTemplate());
      this.getResponseViewConfigData().setLearningProposal(id, description, keywords, authors);
    }
    
    @PersistenceConstructor
    protected MefLearningProposalConfiguration(String id, MefBaseTemplate responseViewConfigData) {
        super(id, responseViewConfigData);
    }
}
