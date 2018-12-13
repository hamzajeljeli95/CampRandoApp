package com.wassi.camprandoapp.Webservices.Events;

import com.wassi.camprandoapp.Beans.EventParticipants;
import com.wassi.camprandoapp.helpers.WsCommunicator;

import java.util.List;

public class EventParticipantsWS {

    private static String methodURI = EventWSBaseURI.BASE_URL+"/eventParticipants";

    public List<EventParticipants> getParticipantsByEvent(EventParticipants body){
        return WsCommunicator.getListOfObjects(methodURI+"/getParticipants/",body,EventParticipants[].class);
        //return service.getParticipantsByEvent(Integer.parseInt(body.get("eventId")));
    }

    public List<EventParticipants> getEventsByParticipant(EventParticipants body) {
        return WsCommunicator.getListOfObjects(methodURI+"/getEventsByParticipant/",body,EventParticipants[].class);
        //return service.getEventsByParticipant(body.get("participantId"));
    }

    public boolean participateToEvent(EventParticipants body) {
        return WsCommunicator.getObject(methodURI+"/add/",body,Boolean.class);
        //return service.participateToEvent(Integer.parseInt(body.get("eventId")),body.get("participantId"));
    }

}
