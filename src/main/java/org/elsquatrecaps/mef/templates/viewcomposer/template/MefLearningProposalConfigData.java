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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.PersistenceConstructor;

/**
 *
 * @author josep
 */
public class MefLearningProposalConfigData implements Serializable{
    private String id;
    private String description;
    private String keywords;
    private List<String> authors;

    public MefLearningProposalConfigData() {
        this.authors = new ArrayList<>();
    }

    public MefLearningProposalConfigData(String id, String description, String keywords) {
        this.authors = new ArrayList<>();
        this.id = id;
        this.description = description;
        this.keywords = keywords;
    }

    @PersistenceConstructor
    public MefLearningProposalConfigData(String id, String description, String keywords, List<String> authors) {
        this.id = id;
        this.description = description;
        this.keywords = keywords;
        this.authors = authors;
    }
    
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the keywords
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * @return the authors
     */
    public List<String> getAuthors() {
        return authors;
    }
}
