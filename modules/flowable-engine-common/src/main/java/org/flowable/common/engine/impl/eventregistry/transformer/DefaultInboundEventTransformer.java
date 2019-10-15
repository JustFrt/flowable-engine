/* Licensed under the Apache License, Version 2.0 (the "License");
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
package org.flowable.common.engine.impl.eventregistry.transformer;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.flowable.common.engine.api.eventbus.FlowableEventBusEvent;
import org.flowable.common.engine.api.eventregistry.EventProcessingContext;
import org.flowable.common.engine.api.eventregistry.InboundEventTransformer;
import org.flowable.common.engine.impl.eventregistry.FlowableEventBusEventImpl;

/**
 * @author Joram Barrez
 */
public class DefaultInboundEventTransformer implements InboundEventTransformer {

    @Override
    public List<FlowableEventBusEvent> transform(EventProcessingContext eventProcessingContext) {
        FlowableEventBusEventImpl eventBusEvent = new FlowableEventBusEventImpl();
        eventBusEvent.setType(eventProcessingContext.getEventDefinition().getKey());

        // TODO: temporary
        Map<String, Object> data = new HashMap<>();
        data.put("eventInstances", eventProcessingContext.getEventInstances());
        eventBusEvent.setData(data);

        return Collections.singletonList(eventBusEvent);
    }

}
