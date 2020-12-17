package org.yal.app.cours.screens.login.action;

import org.yal.app.cours.screens.common.WindowsManager;
import org.yal.app.cours.screens.login.view.LoginConstructeur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginListener implements ActionListener {

    final WindowsManager windowsManager;
    final LoginConstructeur loginConstructeur;

    public LoginListener(WindowsManager windowsManager, LoginConstructeur loginConstructeur) {
        this.windowsManager = windowsManager;
        this.loginConstructeur = loginConstructeur;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final Object source = e.getSource();
        if (source instanceof JButton) {
            if (((JButton) source).getText().equals("fermeture")) {
                System.exit(0);
            }
            else if (((JButton) source).getText().equals("connexion")) {
                windowsManager.ouvrirEcran(windowsManager.nextEcran());
            }
        }
    }
}
