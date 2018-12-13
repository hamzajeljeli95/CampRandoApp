package com.wassi.camprandoapp.Beans;

import java.io.Serializable;
import java.util.Collection;

public class EventInfo implements Serializable {
    private int id;
    private String infoType;
    private Collection<EventAdditionalInfos> eventAdditionalInfosById;

    public EventInfo() {
    }

    public EventInfo(int id, String infoType, Collection<EventAdditionalInfos> eventAdditionalInfosById) {
        this.id = id;
        this.infoType = infoType;
        this.eventAdditionalInfosById = eventAdditionalInfosById;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    public Collection<EventAdditionalInfos> getEventAdditionalInfosById() {
        return eventAdditionalInfosById;
    }

    public void setEventAdditionalInfosById(Collection<EventAdditionalInfos> eventAdditionalInfosById) {
        this.eventAdditionalInfosById = eventAdditionalInfosById;
    }
}
