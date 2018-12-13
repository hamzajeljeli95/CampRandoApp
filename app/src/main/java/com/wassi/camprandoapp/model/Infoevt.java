package com.wassi.camprandoapp.model;

import java.io.Serializable;

public class Infoevt implements Serializable {
    private String Nom;
    private String type;
    private String date;
    private String hd;
    private String hf;
    private String origin;
    private String des;
    private int nb_place;
    private String transport;
    private String evt_img;
    private String prix;

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    public String getHf() {
        return hf;
    }

    public void setHf(String hf) {
        this.hf = hf;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getNb_place() {
        return nb_place;
    }

    public void setNb_place(int nb_place) {
        this.nb_place = nb_place;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getEvt_img() {
        return evt_img;
    }

    public void setEvt_img(String evt_img) {
        this.evt_img = evt_img;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public Infoevt(String nom, String type, String date, String hd, String hf, String origin, String des, int nb_place, String transport, String evt_img, String prix) {
        Nom = nom;
        this.type = type;
        this.date = date;
        this.hd = hd;
        this.hf = hf;
        this.origin = origin;
        this.des = des;
        this.nb_place = nb_place;
        this.transport = transport;
        this.evt_img = evt_img;
        this.prix = prix;
    }
}
