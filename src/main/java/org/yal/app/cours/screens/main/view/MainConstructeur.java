package org.yal.app.cours.screens.main.view;

import org.yal.app.cours.screens.common.ConstructeurEcran;
import org.yal.app.cours.screens.common.WindowsManager;
import org.yal.app.cours.screens.main.action.MainListener;
import org.yal.app.cours.screens.main.model.MainModel;
import org.yal.app.cours.screens.main.model.TableModel;

import javax.swing.*;
import java.awt.*;

public class MainConstructeur implements ConstructeurEcran {

    private final MainListener listener;
    private final MainModel model = new MainModel();
    private final WindowsManager windowsManager;

    public MainConstructeur(WindowsManager windowsManager) {
        this.windowsManager = windowsManager;
        this.listener = new MainListener(model.getPersonnages(), this.windowsManager);
    }

    @Override
    public JPanel construireEcran() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel menuBar = createMenuBar();
        panel.add(menuBar, BorderLayout.NORTH);
        JScrollPane tablePanel = createTablePanel();
        panel.add(tablePanel, BorderLayout.CENTER);
        return panel;
    }

    private JScrollPane createTablePanel() {
        return new JScrollPane(new JTable(new TableModel(model.getPersonnages())));
    }

    private JPanel createMenuBar() {
        JPanel menuBar = new JPanel();
        JButton ajouterButton = new JButton("ajouter");
        JButton supprimerButton = new JButton("suprimer");
        JButton sauvegarderButton = new JButton("sauvegarder");
        menuBar.add(ajouterButton);
        menuBar.add(supprimerButton);
        menuBar.add(sauvegarderButton);
        ajouterButton.addActionListener(listener);
        supprimerButton.addActionListener(listener);
        sauvegarderButton.addActionListener(listener);
        return menuBar;
    }
}
