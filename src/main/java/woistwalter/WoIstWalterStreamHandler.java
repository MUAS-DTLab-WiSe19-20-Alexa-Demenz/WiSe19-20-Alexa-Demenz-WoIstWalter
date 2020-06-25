/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package woistwalter;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

import woistwalter.handlers.AddPersonIntentHandler;
import woistwalter.handlers.CancelandStopIntentHandler;
import woistwalter.handlers.DeletePersonIntentHandler;
import woistwalter.handlers.FallbackIntentHandler;
import woistwalter.handlers.HelpIntentHandler;
import woistwalter.handlers.LaunchRequestHandler;
import woistwalter.handlers.SessionEndedRequestHandler;
import woistwalter.handlers.WhatHappenedToPersonIntentHandler;
import woistwalter.handlers.WhatsNewIntentHandler;

public class WoIstWalterStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new WhatsNewIntentHandler(),
                        new WhatHappenedToPersonIntentHandler(),
                        new LaunchRequestHandler(),
                        new CancelandStopIntentHandler(),
                        new SessionEndedRequestHandler(),
                        new HelpIntentHandler(),
                        new DeletePersonIntentHandler(),
                        new AddPersonIntentHandler(),
                        new FallbackIntentHandler())
                .build();
    }

    public WoIstWalterStreamHandler() {
        super(getSkill());
    }

}
