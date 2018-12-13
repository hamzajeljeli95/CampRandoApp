package com.wassi.camprandoapp.Beans;


import java.io.Serializable;

public class EventParticipants implements Serializable {
    private int id;
    private int eventId;
    private String participantId;
    private Event eventByEventId;
    private AppUser appUserByParticipantId;

    public EventParticipants() {
    }

    public EventParticipants(int id, int eventId, String participantId, Event eventByEventId, AppUser appUserByParticipantId) {
        this.id = id;
        this.eventId = eventId;
        this.participantId = participantId;
        this.eventByEventId = eventByEventId;
        this.appUserByParticipantId = appUserByParticipantId;
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

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public Event getEventByEventId() {
        return eventByEventId;
    }

    public void setEventByEventId(Event eventByEventId) {
        this.eventByEventId = eventByEventId;
    }

    public AppUser getAppUserByParticipantId() {
        return appUserByParticipantId;
    }

    public void setAppUserByParticipantId(AppUser appUserByParticipantId) {
        this.appUserByParticipantId = appUserByParticipantId;
    }
}
