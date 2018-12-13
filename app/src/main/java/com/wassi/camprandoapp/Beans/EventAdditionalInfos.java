package com.wassi.camprandoapp.Beans;

import java.io.Serializable;

public class EventAdditionalInfos implements Serializable {
    private int id;
    private int eventId;
    private int infoId;
    private String infoContent;
    private Event eventByEventId;
    private EventInfo eventInfoByInfoId;

    public EventAdditionalInfos() {
    }

    public EventAdditionalInfos(int id, int eventId, int infoId, String infoContent, Event eventByEventId, EventInfo eventInfoByInfoId) {
        this.id = id;
        this.eventId = eventId;
        this.infoId = infoId;
        this.infoContent = infoContent;
        this.eventByEventId = eventByEventId;
        this.eventInfoByInfoId = eventInfoByInfoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent;
    }

    public Event getEventByEventId() {
        return eventByEventId;
    }

    public void setEventByEventId(Event eventByEventId) {
        this.eventByEventId = eventByEventId;
    }

    public EventInfo getEventInfoByInfoId() {
        return eventInfoByInfoId;
    }

    public void setEventInfoByInfoId(EventInfo eventInfoByInfoId) {
        this.eventInfoByInfoId = eventInfoByInfoId;
    }
}
