package org.yal.app.cours;


/**
 * @author YL
 * 24 févr. 2010
 * 
 */
public interface ConfigConstants
{
  String DEFAULT_CONFIG = "config.xml";

  String VERSION_PGR = "version.pgr";
  String VERSION_BUILDNUMBER = "version.buildNumber";
  String VERSION_MAIN_CLASS= "version.man.class";
  
  String CFECIHM = "cfecIhm";
  String CFEC = CFECIHM + ".cfec";
  String CFEC_ID = CFEC + ".cfecId";
  String SAFE_ID = CFEC + ".safeId";
  String LOCK_FILE = CFECIHM + ".lockFile";
  String SAVE_FILE = CFECIHM + ".saveFile";
  String LOG_CONF_FILE = CFECIHM + ".logConfFile";
  String CRTL_URL = CFEC + ".url";
  String CRTL_P12 = CFEC + ".p12";
  String CRTL_PEM = CFEC + ".pem";
  String CRTL_KEYPASSWORD = CFEC + ".p12Password";
  String USER = CFEC + ".users.user";
  String USER_LOGIN = USER + ".login";
  String USER_PASSWORD = USER + ".password";
}

