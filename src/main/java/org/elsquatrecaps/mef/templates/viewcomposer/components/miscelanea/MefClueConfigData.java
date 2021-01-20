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
package org.elsquatrecaps.mef.templates.viewcomposer.components.miscelanea;

import java.util.ArrayList;
import java.util.List;
import org.elsquatrecaps.flexiblelearning.viewcomposer.components.BaseConfigurationData;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

/**
 *
 * @author josep
 */
public class MefClueConfigData extends BaseConfigurationData{
    private List<String> allowedClueIteratorTypes = new ArrayList<>();
    @Id
    private String clueSetId;

    @PersistenceConstructor
    public MefClueConfigData(List<String> allowedClueIteratorTypes, String clueSetId) {
        this(clueSetId);
        this.allowedClueIteratorTypes = allowedClueIteratorTypes;
    }

    public MefClueConfigData(String clueSetId) {
        this.clueSetId = clueSetId;
    }

    public MefClueConfigData() {
        this("");
    }

    public List<String> getAllowedClueIteratorTypes() {
        return allowedClueIteratorTypes;
    }

    public void setAllowedClueIteratorTypes(List<String> allowedClueIteratorTypes) {
        this.allowedClueIteratorTypes = allowedClueIteratorTypes;
    }

    public String getClueSetId() {
        return clueSetId;
    }

    public void setClueSetId(String clueSetId) {
        this.clueSetId = clueSetId;
    }
    
    public void addAllowedClueIteratorType(String type){
        this.allowedClueIteratorTypes.add(type);
    }    
}
