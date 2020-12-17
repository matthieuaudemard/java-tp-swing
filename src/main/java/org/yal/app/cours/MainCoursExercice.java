package org.yal.app.cours;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yal.app.cours.screens.common.ConstructeurEcran;
import org.yal.app.cours.screens.common.WindowsManager;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import org.yal.app.cours.screens.login.view.LoginConstructeur;


/**
 * @author YL 19 janv. 2011
 *
 */
public class MainCoursExercice
{
  private static final Logger logger = LoggerFactory.getLogger(MainCoursExercice.class);


  public MainCoursExercice() {

  }

  public static void main(String[] args)
  {
    try
    {
      initLog();
      WindowsManager windowsManager = new WindowsManager();
      JFrame fenetrePrincipale = windowsManager.getWindow();
      windowsManager.ouvrirEcran(windowsManager.nextEcran());

      Dimension dimension = new Dimension(510, 540);
      fenetrePrincipale.setSize(dimension);
      fenetrePrincipale.setVisible(true);
      fenetrePrincipale.setMinimumSize(dimension);
      fenetrePrincipale.setMaximumSize(dimension);
      fenetrePrincipale.setResizable(false);
      
      fenetrePrincipale.addWindowListener(new WindowAdapter()
      {
        @Override
        public void windowClosing(WindowEvent e)
        {
          System.exit(0);
        }
      });
    }
    catch (Exception e1)
    {
      logger.error("problème trouvé ", e1);
      e1.printStackTrace();
    }
    
  }
  
  static void initLog() throws Exception
  {
    LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
    JoranConfigurator configurator = new JoranConfigurator();
    loggerContext.setName("CoursJavaPerf");
    
    configurator.setContext(loggerContext);
    loggerContext.reset();
    
    configurator.doConfigure(MainCoursExercice.class.getResource("/org/yal/app/cours/resources/logback.xml"));
  }
}
