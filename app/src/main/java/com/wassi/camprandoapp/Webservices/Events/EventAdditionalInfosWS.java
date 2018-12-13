package com.wassi.camprandoapp.Webservices.Events;

import com.wassi.camprandoapp.Beans.EventAdditionalInfos;
import com.wassi.camprandoapp.helpers.WsCommunicator;

import java.util.List;

public class EventAdditionalInfosWS {

    private static String methodURI = EventWSBaseURI.BASE_URL+"/EAI";

    public List<EventAdditionalInfos> getEventAdditionalInfos(EventAdditionalInfos body)
    {
        return WsCommunicator.getListOfObjects(methodURI+"/get/",body,EventAdditionalInfos[].class);
        //return service.getEventAdditionalInfos(Integer.parseInt(body.get("eventId")));
    }

    public EventAdditionalInfos getSpecificEventAdditionalInfo(EventAdditionalInfos body)
    {
        return WsCommunicator.getObject(methodURI+"/getSpecific/",body,EventAdditionalInfos.class);
        //return service.getSpecificEventAdditionalInfo(Integer.parseInt(body.get("infoId")), Integer.parseInt(body.get("eventId")));
    }

    public boolean addEventAdditionalInfo(EventAdditionalInfos body)
    {
        return WsCommunicator.getObject(methodURI+"/add/",body,Boolean.class);
    }
}
