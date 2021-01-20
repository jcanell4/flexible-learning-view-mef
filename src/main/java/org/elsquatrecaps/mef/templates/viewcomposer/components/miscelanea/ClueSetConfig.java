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

import org.elsquatrecaps.mef.data.miscelanea.DefaultClue;
import org.elsquatrecaps.flexiblelearning.viewcomposer.components.BaseConfigurationData;
import org.elsquatrecaps.mef.data.miscelanea.Clue;
import org.elsquatrecaps.mef.data.miscelanea.Clue;
import org.elsquatrecaps.mef.data.miscelanea.DefaultClue;

/**
 *
 * @author josep
 */
public class ClueSetConfig extends BaseConfigurationData{
    private String clueIteratorType;
    private String clueSetId;
    private Clue currentClue;
    private String infoMessage;

    public ClueSetConfig(String clueSetId, String clueIteratorType, Clue curreClue) {
        this.clueIteratorType = clueIteratorType;
        this.currentClue = curreClue;
        this.infoMessage="";
    }
    
    public ClueSetConfig(String clueSetId, String clueIteratorType) {
        this(clueSetId, clueIteratorType, new DefaultClue());
    }

    public ClueSetConfig(String clueSetId) {
        this(clueSetId, "");
    }

    public ClueSetConfig() {
        this("");
    }

    public String getClueSetId() {
        return clueSetId;
    }

    public void setClueSetId(String clueSetId) {
        this.clueSetId = clueSetId;
    }
    
    public Clue getCurrentClue() {
        return currentClue;
    }

    public String getClueIteratorType() {
        return clueIteratorType;
    }

    public void setClueIteratorType(String clueIteratorType) {
        this.clueIteratorType = clueIteratorType;
    }

    public String getInfoMessage() {
        return infoMessage;
    }

    public void setInfoMessage(String infoMessage) {
        this.infoMessage = infoMessage;
    }
}
