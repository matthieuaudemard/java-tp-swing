package org.yal.app.cours.model.interfaces;

/**
 * @author YLE
 * 27 févr. 2019
 * 
 */
public interface IPersonnage
{
  Long getId();
  String getNom();
  String getTypeElement();
  Integer getTypeDePersonne();
  
  Long getPvMax();
  Long getPv();
}
