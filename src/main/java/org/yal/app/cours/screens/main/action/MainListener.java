package org.yal.app.cours.screens.main.action;

import org.yal.app.cours.model.Personnage;
import org.yal.app.cours.screens.ajout.model.AjoutModel;
import org.yal.app.cours.screens.ajout.view.AjoutConstructeur;
import org.yal.app.cours.screens.common.ConstructeurEcran;
import org.yal.app.cours.screens.common.WindowsManager;
import org.yal.app.cours.screens.main.view.MainConstructeur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class MainListener implements ActionListener {
    private final JFileChooser fileDialog = new JFileChooser();
    private final WindowsManager windowsManager;
    private List<Personnage> personnages;
    private final String SEPARATOR = ",";

    public MainListener(List<Personnage> personnages, WindowsManager windowsManager) {
        this.personnages = personnages;
        this.windowsManager = windowsManager;
    }

    private void sauvegarderOnClick() {
        int response = fileDialog.showOpenDialog(windowsManager.getWindow());
        if (response == JFileChooser.APPROVE_OPTION) {
            File csvFile = fileDialog.getSelectedFile();
            try (PrintWriter csvWriter = new PrintWriter(new FileWriter(csvFile))) {
                for (Personnage personnage : personnages) {
                    csvWriter.print(personnage.getId() + SEPARATOR);
                    csvWriter.print(personnage.getNom() + SEPARATOR);
                    csvWriter.print(personnage.getPv() + SEPARATOR);
                    csvWriter.println(personnage.getPvMax());
                }
            } catch (IOException ex) {
                // TODO: Handle exception
                ex.printStackTrace();
            }
        }
    }

    private void ajouterOnClick() {
        final ConstructeurEcran constructeurEcran = windowsManager.get(2);
        ((AjoutConstructeur) constructeurEcran).setModel(new AjoutModel());
        windowsManager.ouvrirEcran(constructeurEcran);
    }

    private void supprimerOnClick() {
        final MainConstructeur constructeurEcran = (MainConstructeur) windowsManager.get(1);
        constructeurEcran.removeCurrentRow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final Object source = e.getSource();
        if (source instanceof JButton) {
            final String buttonText = ((JButton) source).getText();
            switch (buttonText) {
                case "sauvegarder":
                    sauvegarderOnClick();
                    break;
                case "supprimer":
                    supprimerOnClick();
                    break;
                case "ajouter":
                    ajouterOnClick();
                    break;
                default: break;
            }
        }
    }
}
