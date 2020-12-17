package org.yal.app.cours.screens.main.model;

import org.yal.app.cours.model.Personnage;

import java.util.ArrayList;
import java.util.List;

public class MainModel {
    List<Personnage> personnages;

    public MainModel() {
        personnages = new ArrayList<>();
        Personnage p = new Personnage();
        p.setId(1L);
        p.setNom("Jack Bauer");
        p.setPv(8000L);
        p.setPvMax(8000L);
        p.setTypeDePersonne(1);
        personnages.add(p);
    }

    public List<Personnage> getPersonnages() {
        return personnages;
    }

    public void add(Personnage p) {
        personnages.add(p);
    }

    public void remove(int selectedRow) {
        personnages.remove(selectedRow);
    }
}
