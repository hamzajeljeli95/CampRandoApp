package com.wassi.camprandoapp.Beans;

import java.io.Serializable;
import java.sql.Date;

public class EventComments implements Serializable {
    private int id;
    private int idEvent;
    private String idUser;
    private String commentContent;
    private Date dateTimeComment;
    private Event eventByIdEvent;
    private AppUser appUserByIdUser;

    public EventComments() {
    }

    public EventComments(int id, int idEvent, String idUser, String commentContent, Date dateTimeComment, Event eventByIdEvent, AppUser appUserByIdUser) {
        this.id = id;
        this.idEvent = idEvent;
        this.idUser = idUser;
        this.commentContent = commentContent;
        this.dateTimeComment = dateTimeComment;
        this.eventByIdEvent = eventByIdEvent;
        this.appUserByIdUser = appUserByIdUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getDateTimeComment() {
        return dateTimeComment;
    }

    public void setDateTimeComment(Date dateTimeComment) {
        this.dateTimeComment = dateTimeComment;
    }

    public Event getEventByIdEvent() {
        return eventByIdEvent;
    }

    public void setEventByIdEvent(Event eventByIdEvent) {
        this.eventByIdEvent = eventByIdEvent;
    }

    public AppUser getAppUserByIdUser() {
        return appUserByIdUser;
    }

    public void setAppUserByIdUser(AppUser appUserByIdUser) {
        this.appUserByIdUser = appUserByIdUser;
    }
}
