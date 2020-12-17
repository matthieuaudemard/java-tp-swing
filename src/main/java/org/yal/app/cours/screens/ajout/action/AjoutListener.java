package org.yal.app.cours.screens.ajout.action;

import org.yal.app.cours.model.Personnage;
import org.yal.app.cours.screens.ajout.model.AjoutModel;
import org.yal.app.cours.screens.ajout.view.AjoutConstructeur;
import org.yal.app.cours.screens.common.ConstructeurEcran;
import org.yal.app.cours.screens.common.WindowsManager;
import org.yal.app.cours.screens.main.view.MainConstructeur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AjoutListener implements ActionListener {

    private WindowsManager windowsManager;

    public AjoutListener(WindowsManager windowsManager, AjoutModel model) {
        this.windowsManager = windowsManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final Object source = e.getSource();
        if (source instanceof JButton) {
            JButton button = (JButton) source;
            if (button.getText().equals("ajouter")) {
                final MainConstructeur mainConstructeur = (MainConstructeur) windowsManager.get(1);
                Personnage p = new Personnage();
                AjoutModel model = ((AjoutConstructeur) windowsManager.get(2)).getModel();
                p.setId(model.getId());
                p.setNom(model.getNom());
                p.setPv(model.getPv());
                p.setPvMax(model.getPvMax());
                mainConstructeur.getModel().add(p);
                mainConstructeur.refreshModel();
                windowsManager.ouvrirEcran(windowsManager.get(1));
            }
            else {
                windowsManager.ouvrirEcran(windowsManager.get(1));
            }
        }

    }
}
