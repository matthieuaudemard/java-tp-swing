package org.yal.app.cours.screens.login.view;

import org.yal.app.cours.screens.common.ConstructeurEcran;
import org.yal.app.cours.screens.common.WindowsManager;
import org.yal.app.cours.screens.login.action.LoginListener;
import org.yal.app.cours.screens.login.model.LoginModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginConstructeur implements ConstructeurEcran {
    private final LoginModel model = new LoginModel();

    private final ActionListener loginActionListener;

    public LoginConstructeur(WindowsManager windowsManager) {
        this.loginActionListener = new LoginListener(windowsManager, this);
    }

    public LoginModel getModel() {
        return model;
    }

    @Override
    public JPanel construireEcran() {
        JLabel loginLabel = new JLabel("login");
        JTextField loginText = new JTextField(model.getLogin());
        JLabel passwordLabel = new JLabel("password");
        JPasswordField passwordText = new JPasswordField();
        JButton connexionButton = new JButton("connexion");
        JButton fermtureButton = new JButton("fermeture");

        loginText.getDocument().addDocumentListener(
                new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        updateModel();
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        updateModel();
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        updateModel();
                    }

                    public void updateModel() {
                        model.setLogin(loginText.getText());
                    }
                }
        );

        passwordText.getDocument().addDocumentListener(
                new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        updateModel();
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        updateModel();
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        updateModel();
                    }
                    public void updateModel() {
                        model.setPassword(passwordText.getText());
                    }
                }
        );

        connexionButton.addActionListener(loginActionListener);
        fermtureButton.addActionListener(loginActionListener);

        JPanel mainPanel = new JPanel(new GridLayout(3, 1));

        mainPanel.add(loginLabel);
        mainPanel.add(loginText);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordText);
        mainPanel.add(connexionButton);
        mainPanel.add(fermtureButton);

        return mainPanel;
    }
}
