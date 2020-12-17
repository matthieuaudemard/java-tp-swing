package org.yal.app.cours.model;

import java.util.Set;

/**
 * @author YLE
 * 27 févr. 2019
 * 
 */
public class Lieu
{
  private String id;
  private String nom;
  private String description;
  private Set<Personnage> personnage;
  
  public Lieu()
  {}
  
  public String getId()
  {
    return id;
  }
  public void setId(String id)
  {
    this.id = id;
  }
  public String getNom()
  {
    return nom;
  }
  public void setNom(String nom)
  {
    this.nom = nom;
  }
  public String getDescription()
  {
    return description;
  }
  public void setDescription(String description)
  {
    this.description = description;
  }
  public Set<Personnage> getPersonnage()
  {
    return personnage;
  }
  public void setPersonnage(Set<Personnage> personnage)
  {
    this.personnage = personnage;
  }
}
