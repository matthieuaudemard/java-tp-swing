package org.yal.app.cours.screens.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstants;
import org.yal.app.cours.screens.ajout.view.AjoutConstructeur;
import org.yal.app.cours.screens.login.view.LoginConstructeur;
import org.yal.app.cours.screens.main.view.MainConstructeur;

/**
 * @author YLE
 * 11 mars 2019
 *
 */
public class WindowsManager
{
  private final JFrame window;
  private final List<ConstructeurEcran> ecrans;
  private ConstructeurEcran dernierEcran;
  private final Iterator<ConstructeurEcran> ecranIterator;

  public WindowsManager()
  {
    this.window = new JFrame();
    ecrans = new ArrayList<>(Arrays.asList(new LoginConstructeur(this), new MainConstructeur(this), new AjoutConstructeur()));
    ecranIterator = ecrans.iterator();
    window.getContentPane().setLayout(new TableLayout(new double[][] {{10,TableLayoutConstants.FILL,10} ,{.33, TableLayoutConstants.PREFERRED, .33}}));
  }

  public ConstructeurEcran get(int index) {
    return ecrans.get(index);
  }

  public ConstructeurEcran nextEcran() {
    if (ecranIterator != null) {
      return ecranIterator.hasNext() ? ecranIterator.next() : dernierEcran;
    }
    return dernierEcran;
  }

  public void ouvrirEcran(ConstructeurEcran constructeurEcran)
  {
    if (dernierEcran != null)
    {
      // Impossible de supprimer un component qui n'a pas été ajouté
      // -> dernierEcran.construireEcran() crée une nouvelle instance de JPanel
      window.getContentPane().remove(dernierEcran.construireEcran());
      ecrans.add(dernierEcran);
      dernierEcran.construireEcran().setVisible(false);
    }

    dernierEcran = constructeurEcran;
    constructeurEcran.construireEcran().setVisible(true);
    if (window.getContentPane().getComponentCount() > 0) {
      window.getContentPane().remove(0);
    }
    window.getContentPane().add(constructeurEcran.construireEcran(), "1,1,f,f");
    SwingUtilities.invokeLater(() -> {
      window.getContentPane().revalidate();
      window.getContentPane().repaint();
    });
  }

  public void fermerEcranCourant()
  {
    if (dernierEcran != null)
    {
      window.getContentPane().remove(dernierEcran.construireEcran());
      dernierEcran.construireEcran().setVisible(false);
      if (ecrans.size() > 0)
      {
        dernierEcran = ecrans.remove(0);
        dernierEcran.construireEcran().setVisible(true);
        window.getContentPane().add(dernierEcran.construireEcran(), "1,1");
      }
    }



    SwingUtilities.invokeLater(new Runnable()
    {
      @Override
      public void run()
      {
        window.getContentPane().revalidate();
        window.getContentPane().repaint();
      }
    });
  }

  public JFrame getWindow()
  {
    return window;
  }

}
