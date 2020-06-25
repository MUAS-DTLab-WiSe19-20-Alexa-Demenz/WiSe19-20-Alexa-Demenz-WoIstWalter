/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package woistwalter.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import woistwalter.PhrasesAndConstants;
import woistwalter.model.Activity;
import woistwalter.model.Familymember;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import static com.amazon.ask.request.Predicates.intentName;

public class WhatsNewIntentHandler implements RequestHandler {

	public Random r = new Random();
	
    @Override
    public boolean canHandle(HandlerInput input) {
    	
        return input.matches(intentName("WhatsNewIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
   
    	String text = "";
    	
    	for(Familymember member : PhrasesAndConstants.Fam.getMembers()) {
    		List<Activity> activities = PhrasesAndConstants.Fam.getActivities().get(member);
    		text += member.getName() + "'s Aktivitäten sind: ";
    		for(Activity act : activities) {
    			text += act.getActivity() + ", ";
    		}
    		text += ". ";
    	}	
    	
        return input.getResponseBuilder().withSpeech(text).build();
    }
}
