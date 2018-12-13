package com.wassi.camprandoapp.Webservices.Events;

import com.wassi.camprandoapp.Beans.EventInfo;
import com.wassi.camprandoapp.helpers.WsCommunicator;

import java.util.List;

public class EventInfoWS {

    private static String methodURI = EventWSBaseURI.BASE_URL+"/eventInfos";

    public List<EventInfo> getAll() {
        return WsCommunicator.getListOfObjects(methodURI+"/get/",null,EventInfo[].class);
    }
}
