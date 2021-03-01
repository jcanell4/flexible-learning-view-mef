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
package org.elsquatrecaps.flexiblelearning.eventcomposer.components;

import java.util.List;
import org.elsquatrecaps.flexiblelearning.eventactivity.processsing.RootEventProcessor;
import org.elsquatrecaps.flexiblelearning.eventactivity.processsing.factory.MefEventProcessorComponentSuppliersRegistrar;
import org.elsquatrecaps.flexiblelearning.eventcomposer.BaseActivityEventProcessorComposer;
import org.springframework.data.annotation.PersistenceConstructor;

/**
 *
 * @author josep
 */
@ActivityEventProcessorComposerConfigurator(registrarSuppliearsCalss = MefEventProcessorComponentSuppliersRegistrar.class)
public class MefActivityEventProcessorConfiguration extends BaseActivityEventProcessorConfiguration{

    public MefActivityEventProcessorConfiguration(ActivityEventProcessorId id) {
        super(
                id,
                new BaseEventComponentConfiguration("default", "SimpleMapActivityEventDataConverter"),
                new BaseEventComponentConfiguration("mef", "MefActivityEventResponseHandler")
        );
    }

    public MefActivityEventProcessorConfiguration(
            ActivityEventProcessorId id,
            EventComponentConfiguration eventDataModeConverterConfiguration, 
            EventComponentConfiguration eventResponseHandlerConfiguration) {
        super(id, eventDataModeConverterConfiguration, eventResponseHandlerConfiguration);
    }

    public MefActivityEventProcessorConfiguration(ActivityEventProcessorId id, String collection, String name,
            EventComponentConfiguration eventDataModeConverterConfiguration, 
            EventComponentConfiguration eventResponseHandlerConfiguration) {
        super(id, collection, name, eventDataModeConverterConfiguration, eventResponseHandlerConfiguration);
    }

    @PersistenceConstructor
    public MefActivityEventProcessorConfiguration(ActivityEventProcessorId id, String collection, String name,
            EventComponentConfiguration eventDataModeConverterConfiguration, 
            List<EventComponentConfiguration> eventComponentConfigurationList,
            EventComponentConfiguration eventResponseHandlerConfiguration,
            RootEventProcessor cache) {
        super(id, collection, name, eventDataModeConverterConfiguration, eventComponentConfigurationList, eventResponseHandlerConfiguration, cache);
    }
}
