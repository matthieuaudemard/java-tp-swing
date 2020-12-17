package org.yal.app.cours.screens.ajout.view;

import org.yal.app.cours.screens.ajout.model.AjoutModel;
import org.yal.app.cours.screens.common.ConstructeurEcran;

import javax.swing.*;
import java.awt.*;

public class AjoutConstructeur implements ConstructeurEcran {

    private AjoutModel model;

    public AjoutModel getModel() {
        return model;
    }

    public void setModel() {
        this.model = new AjoutModel();
    }

    @Override
    public JPanel construireEcran() {
        JPanel panel = new JPanel(new GridLayout(5, 2));
        JTextField idText = new JTextField(model != null ? String.valueOf(model.getId()) : "");
        JLabel idLabel = new JLabel("Id");
        JTextField nomText = new JTextField(model != null ? model.getNom() : "");
        JLabel nomLabel = new JLabel("nom");
        JTextField pvText = new JTextField(model != null ? String.valueOf(model.getPv()) : "");
        JLabel pvLabel = new JLabel("Pv");
        JTextField pvMaxText = new JTextField(model != null ? String.valueOf(model.getPvMax()) : "");
        JLabel pvMaxLabel = new JLabel("Pv Max");
        panel.add(idLabel);
        panel.add(idText);
        panel.add(nomLabel);
        panel.add(pvLabel);
        panel.add(pvText);
        panel.add(pvMaxLabel);
        panel.add(pvMaxText);
        return panel;
    }
}