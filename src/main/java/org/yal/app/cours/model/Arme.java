package org.yal.app.cours.model;

import org.yal.app.cours.model.interfaces.IArme;

/**
 * @author YLE 27 févr. 2019
 * 
 */
public class Arme implements IArme
{
  public enum Property {id, nom, typeElement, typeDePersonne, pvMax, pv}
  
  private Long    id;
  private String  nom;
  private Long degats;
  private String typeDegat;
  private Personnage personnage;
  
  public Arme()
  {
    // TODO Auto-generated constructor stub
  }
  
  
  public Long getId()
  {
    return id;
  }
  public void setId(Long id)
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


  public Long getDegats()
  {
    return degats;
  }


  public void setDegats(Long degats)
  {
    this.degats = degats;
  }


  public String getTypeDegat()
  {
    return typeDegat;
  }


  public void setTypeDegat(String typeDegat)
  {
    this.typeDegat = typeDegat;
  }


  public Personnage getPersonnage()
  {
    return personnage;
  }


  public void setPersonnage(Personnage personnage)
  {
    this.personnage = personnage;
  }
}
