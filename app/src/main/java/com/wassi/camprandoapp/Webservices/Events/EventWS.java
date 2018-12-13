package com.wassi.camprandoapp.Webservices.Events;

import com.wassi.camprandoapp.Beans.Event;
import com.wassi.camprandoapp.helpers.WsCommunicator;

import java.util.List;

public class EventWS {

    private static String methodURI = EventWSBaseURI.BASE_URL+"/event";

    public Event newEventMethod(Event body)
    {
        return WsCommunicator.getObject(methodURI+"/new/",body,Event.class);
        //return service.newEvent(body.get("organizerId"));
    }

    public Event getEventMethod(Event body)
    {
        return WsCommunicator.getObject(methodURI+"/get/",body,Event.class);
    }

    public List<Event> getEventsByUserMethod(Event body)
    {
        return WsCommunicator.getListOfObjects(methodURI+"/getListByUser/",body,Event[].class);
        //return service.getEventsByUser(body.get("organizerId"));
    }
}
