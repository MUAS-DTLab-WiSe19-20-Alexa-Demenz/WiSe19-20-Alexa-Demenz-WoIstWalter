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

import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Slot;

import java.util.Map;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import woistwalter.PhrasesAndConstants;
import woistwalter.model.Familymember;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class DeletePersonIntentHandler implements RequestHandler {
	
	@Override
	public boolean canHandle(HandlerInput input) {

		return input.matches(intentName("DeletePersonIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {

		String speechText = "";

		String repromptText = "Sage: Lösche und anschließend den Namen der Person";
		
		Request request = input.getRequestEnvelope().getRequest();
		IntentRequest intentRequest = (IntentRequest) request;
		Intent intent = intentRequest.getIntent();
		Map<String, Slot> slots = intent.getSlots();

		
		// Get the name slot from user input.
		Slot nameSlot = slots.get(PhrasesAndConstants.NAME_TO_DELETE);
		String name = nameSlot.getValue();

		Familymember member = PhrasesAndConstants.Fam.returnByName(name);
		
		if(member == null) {
			speechText += name + " existiert nicht in der Familie und kann nicht gelöscht werden!";
		} else {
			PhrasesAndConstants.Fam.deleteFamilymember(member);
			speechText += member.getName() + " wurde aus der Familie entfernt und seine Aktivitäten gelöscht!";
		}

		return input.getResponseBuilder().withSimpleCard("wo ist walter", speechText)
										 .withSpeech(speechText)
										 .withReprompt(repromptText)
										 .build();
	}
}
