package com.wassi.camprandoapp.Beans;

import java.io.Serializable;
import java.util.Collection;

public class AppUser implements Serializable {
    private String username;
    private String passwordHash;
    private int isConfirmed;
    private int profile;
    private Collection<Event> eventsByUsername;
    private Collection<EventComments> eventCommentsByUsername;
    private Collection<EventParticipants> eventParticipantsByUsername;
    private Collection<UserAdditionalInfos> userAdditionalInfosByUsername;

    public AppUser() {
    }

    public AppUser(String username, String passwordHash, int isConfirmed, int profile, Collection<Event> eventsByUsername, Collection<EventComments> eventCommentsByUsername, Collection<EventParticipants> eventParticipantsByUsername, Collection<UserAdditionalInfos> userAdditionalInfosByUsername) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.isConfirmed = isConfirmed;
        this.profile = profile;
        this.eventsByUsername = eventsByUsername;
        this.eventCommentsByUsername = eventCommentsByUsername;
        this.eventParticipantsByUsername = eventParticipantsByUsername;
        this.userAdditionalInfosByUsername = userAdditionalInfosByUsername;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public int getIsConfirmed() {
        return isConfirmed;
    }

    public void setIsConfirmed(int isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public Collection<Event> getEventsByUsername() {
        return eventsByUsername;
    }

    public void setEventsByUsername(Collection<Event> eventsByUsername) {
        this.eventsByUsername = eventsByUsername;
    }

    public Collection<EventComments> getEventCommentsByUsername() {
        return eventCommentsByUsername;
    }

    public void setEventCommentsByUsername(Collection<EventComments> eventCommentsByUsername) {
        this.eventCommentsByUsername = eventCommentsByUsername;
    }

    public Collection<EventParticipants> getEventParticipantsByUsername() {
        return eventParticipantsByUsername;
    }

    public void setEventParticipantsByUsername(Collection<EventParticipants> eventParticipantsByUsername) {
        this.eventParticipantsByUsername = eventParticipantsByUsername;
    }

    public Collection<UserAdditionalInfos> getUserAdditionalInfosByUsername() {
        return userAdditionalInfosByUsername;
    }

    public void setUserAdditionalInfosByUsername(Collection<UserAdditionalInfos> userAdditionalInfosByUsername) {
        this.userAdditionalInfosByUsername = userAdditionalInfosByUsername;
    }
}
