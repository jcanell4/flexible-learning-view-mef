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
package org.elsquatrecaps.mef.templates.viewcomposer.components.miscelanea;

import org.elsquatrecaps.flexiblelearning.viewcomposer.components.multiElements.elements.TimerConfig;

/**
 *
 * @author josep
 */
public class MefTimerConfig extends TimerConfig{

    public MefTimerConfig() {
        super();
        this.setDefault();
    }
    
    public MefTimerConfig(String id) {
        super(id);
        this.setDefault();
    }
    
    public MefTimerConfig(String id, int time, String url) {
        this(id);
        this.setAttribute(TIME_ATTR, String.valueOf(time));
        this.setAttribute(URL_ATTR, url);
    }
    
    public MefTimerConfig(int time, String url) {
        this();
        this.setAttribute(TIME_ATTR, String.valueOf(time));
        this.setAttribute(URL_ATTR, url);
    }
    
    private final void setDefault(){
        this.setAttribute(DATA_OBJECT_ATTR,  "timerObjectData");
        this.setAttribute(REQUEST_METHOD_ATTR, "POST");
        this.setAttribute(CALLABLE_OBJECT_ATTR, "actions");
    }    
}
