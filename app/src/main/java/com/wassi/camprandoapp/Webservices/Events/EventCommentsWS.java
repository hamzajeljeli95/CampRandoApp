package com.wassi.camprandoapp.Webservices.Events;

import com.wassi.camprandoapp.Beans.EventComments;
import com.wassi.camprandoapp.helpers.WsCommunicator;

import java.util.List;

public class EventCommentsWS {

    private static String methodURI = EventWSBaseURI.BASE_URL+"/comments";

    public List<EventComments> getCommentsByEventId(EventComments body)
    {
        return WsCommunicator.getListOfObjects(methodURI+"/getComments/",body,EventComments[].class);
        //return service.getCommentsByEventId(Integer.parseInt(body.get("idEvent")));
    }


    public EventComments getUserCommentByEventId(EventComments body)
    {
        return WsCommunicator.getObject(methodURI+"/getUserComments/",body,EventComments.class);
        //return service.getUserCommentByEventId(Integer.parseInt(body.get("idEvent")), body.get("idUser"));
    }

    /**
     * URI Not yet implemented
     */
    public boolean newComment(EventComments body)
    {
        return WsCommunicator.getObject(methodURI+"/new/",body,Boolean.class);
    }
}
