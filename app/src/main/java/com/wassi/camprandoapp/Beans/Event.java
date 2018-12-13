package com.wassi.camprandoapp.Beans;

import java.io.Serializable;
import java.util.Collection;


public class Event implements Serializable {
    private int id;
    private String organizerId;
    private AppUser appUserByOrganizerId;
    private Collection<EventAdditionalInfos> eventAdditionalInfosById;
    private Collection<EventComments> eventCommentsById;
    private Collection<EventParticipants> eventParticipantsById;

    public Event() {
    }

    public Event(int id, String organizerId, AppUser appUserByOrganizerId, Collection<EventAdditionalInfos> eventAdditionalInfosById, Collection<EventComments> eventCommentsById, Collection<EventParticipants> eventParticipantsById) {
        this.id = id;
        this.organizerId = organizerId;
        this.appUserByOrganizerId = appUserByOrganizerId;
        this.eventAdditionalInfosById = eventAdditionalInfosById;
        this.eventCommentsById = eventCommentsById;
        this.eventParticipantsById = eventParticipantsById;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(String organizerId) {
        this.organizerId = organizerId;
    }

    public AppUser getAppUserByOrganizerId() {
        return appUserByOrganizerId;
    }

    public void setAppUserByOrganizerId(AppUser appUserByOrganizerId) {
        this.appUserByOrganizerId = appUserByOrganizerId;
    }

    public Collection<EventAdditionalInfos> getEventAdditionalInfosById() {
        return eventAdditionalInfosById;
    }

    public void setEventAdditionalInfosById(Collection<EventAdditionalInfos> eventAdditionalInfosById) {
        this.eventAdditionalInfosById = eventAdditionalInfosById;
    }

    public Collection<EventComments> getEventCommentsById() {
        return eventCommentsById;
    }

    public void setEventCommentsById(Collection<EventComments> eventCommentsById) {
        this.eventCommentsById = eventCommentsById;
    }

    public Collection<EventParticipants> getEventParticipantsById() {
        return eventParticipantsById;
    }

    public void setEventParticipantsById(Collection<EventParticipants> eventParticipantsById) {
        this.eventParticipantsById = eventParticipantsById;
    }
}
