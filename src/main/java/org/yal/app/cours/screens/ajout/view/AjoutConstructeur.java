package org.yal.app.cours.screens.ajout.view;

import org.yal.app.cours.screens.ajout.action.AjoutListener;
import org.yal.app.cours.screens.ajout.model.AjoutModel;
import org.yal.app.cours.screens.common.ConstructeurEcran;
import org.yal.app.cours.screens.common.WindowsManager;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class AjoutConstructeur implements ConstructeurEcran {

    private final WindowsManager windowsManager;
    private final ActionListener ajoutListner;
    private AjoutModel model;

    public AjoutConstructeur(WindowsManager windowsManager) {
        this.windowsManager = windowsManager;
        model = new AjoutModel();
        this.ajoutListner = new AjoutListener(this.windowsManager, model);
    }

    public AjoutModel getModel() {
        return model;
    }

    public void setModel(AjoutModel ajoutModel) {
        this.model = ajoutModel;
    }

    @Override
    public JPanel construireEcran() {
        JPanel panel = new JPanel(new GridLayout(5, 2));
        JTextField idText = new JTextField(model != null && String.valueOf(model.getId()) != null ? String.valueOf(model.getId()) : "");
        idText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    model.setId(Long.parseLong(idText.getText()));
                } catch (NumberFormatException exception) {
                    // Nothing to do
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    model.setId(Long.parseLong(idText.getText()));
                } catch (NumberFormatException exception) {
                    // Nothing to do
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                try {
                    model.setId(Long.parseLong(idText.getText()));
                } catch (NumberFormatException exception) {
                    // Nothing to do
                }
            }
        });
        JLabel idLabel = new JLabel("Id");
        JTextField nomText = new JTextField(model != null && String.valueOf(model.getNom()) != null ? model.getNom() : "");
        nomText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                model.setNom(nomText.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                model.setNom(nomText.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                model.setNom(nomText.getText());
            }
        });
        JLabel nomLabel = new JLabel("nom");
        JTextField pvText = new JTextField(model != null && String.valueOf(model.getPv()) != null ? String.valueOf(model.getPv()) : "");
        pvText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    model.setPv(Long.parseLong(pvText.getText()));
                }  catch (NumberFormatException exception) {
                    // Nothing to do
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    model.setPv(Long.parseLong(pvText.getText()));
                }  catch (NumberFormatException exception) {
                    // Nothing to do
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                try {
                    model.setPv(Long.parseLong(pvText.getText()));
                }  catch (NumberFormatException exception) {
                    // Nothing to do
                }
            }
        });
        JLabel pvLabel = new JLabel("Pv");
        JTextField pvMaxText = new JTextField(model != null && String.valueOf(model.getPvMax()) != null ? String.valueOf(model.getPvMax()) : "");
        pvMaxText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    model.setPvMax(Long.parseLong(pvMaxText.getText()));
                } catch (NumberFormatException exception) {
                    // Nothing to do
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    model.setPvMax(Long.parseLong(pvMaxText.getText()));
                }  catch (NumberFormatException exception) {
                    // Nothing to do
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                try {
                    model.setPvMax(Long.parseLong(pvMaxText.getText()));
                }  catch (NumberFormatException exception) {
                    // Nothing to do
                }
            }
        });
        JLabel pvMaxLabel = new JLabel("Pv Max");
        panel.add(idLabel);
        panel.add(idText);
        panel.add(nomLabel);
        panel.add(nomText);
        panel.add(pvLabel);
        panel.add(pvText);
        panel.add(pvMaxLabel);
        panel.add(pvMaxText);
        final JButton ajouter = new JButton("ajouter");
        ajouter.addActionListener(ajoutListner);
        panel.add(ajouter);
        final JButton annulerButton = new JButton("annuler");
        annulerButton.addActionListener(ajoutListner);
        panel.add(annulerButton);
        return panel;
    }
}
