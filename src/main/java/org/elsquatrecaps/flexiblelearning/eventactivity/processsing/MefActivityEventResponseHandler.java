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
package org.elsquatrecaps.flexiblelearning.eventactivity.processsing;

import java.util.function.BiConsumer;
import org.elsquatrecaps.flexiblelearning.eventactivity.processsing.ActivityEventResponseHandler;
import org.elsquatrecaps.flexiblelearning.eventactivity.processsing.EventDataToProcess;
import org.elsquatrecaps.flexiblelearning.eventactivity.request.EventDataMap;
import org.elsquatrecaps.flexiblelearning.eventactivity.responses.CallableJavascript;
import org.elsquatrecaps.flexiblelearning.eventactivity.responses.DataEventResponse;
import org.elsquatrecaps.flexiblelearning.eventactivity.responses.EventResponseData;

/**
 *
 * @author josep
 */
public class MefActivityEventResponseHandler implements ActivityEventResponseHandler{
    public EventResponseData getResponseData(EventDataToProcess prodessedData){
        EventDataMap data = (EventDataMap) prodessedData.getReceivedEventData();
        StringBuilder p = new StringBuilder();
        DataEventResponse ret = new DataEventResponse();
        CallableJavascript call = new CallableJavascript();
        p.append("PROVA DE ECO. Els paràmetres enviats al servidor han estat:<br/>\n<br/>\n");
        data.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String value) {
                p.append(key + ": " + value +"<br/>\n"); 
            }
        });
        call.setName("alert");
        call.setParam("text", p.toString());
        ret.setOnReciveCallable(call);        
        return ret;
    }
}
