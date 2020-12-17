package org.yal.app.cours.screens.ajout.model;

public class AjoutModel {
    private Long id;
    private String nom;
    private Long pv;
    private Long pvMax;

    public AjoutModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getPv() {
        return pv;
    }

    public void setPv(Long pv) {
        this.pv = pv;
    }

    public Long getPvMax() {
        return pvMax;
    }

    public void setPvMax(Long pvMax) {
        this.pvMax = pvMax;
    }
}
