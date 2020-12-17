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

import org.elsquatrecaps.flexiblelearning.learningproposal.ActivityConfiguration;
import org.elsquatrecaps.mef.templates.viewcomposer.components.codeeditor.MefCodeEditorComponent;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author josep
 */
@Document
public class MefActivityConfiguration extends ActivityConfiguration<MefCodeEditorComponent>{

    public MefActivityConfiguration(String id) {
        super(id, new MefCodeEditorComponent());
    }    
    
    @PersistenceConstructor
    protected MefActivityConfiguration(String id, MefCodeEditorComponent responseViewComponent){
        super(id, responseViewComponent);
    }
}
