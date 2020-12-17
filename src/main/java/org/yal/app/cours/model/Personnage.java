package org.yal.app.cours.model;

import java.util.HashSet;
import java.util.Set;

import org.yal.app.cours.model.interfaces.IPersonnage;

/**
 * @author YLE 27 févr. 2019
 * 
 */
public class Personnage implements IPersonnage
{
  public enum Property {id, nom, typeElement, typeDePersonne, pvMax, pv}
  
  private Long    id;
  private String  nom;
  private String  typeElement;
  private Integer typeDePersonne;
  
  private Long    pvMax;
  private Long    pv;
  
  private Set<Arme> armes;
  private Set<Lieu> lieux;
  
  public Personnage()
  {
    armes = new HashSet<>();
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
  public String getTypeElement()
  {
    return typeElement;
  }
  public void setTypeElement(String typeElement)
  {
    this.typeElement = typeElement;
  }
  public Integer getTypeDePersonne()
  {
    return typeDePersonne;
  }
  public void setTypeDePersonne(Integer typeDePersonne)
  {
    this.typeDePersonne = typeDePersonne;
  }
  public Long getPvMax()
  {
    return pvMax;
  }
  public void setPvMax(Long pvMax)
  {
    this.pvMax = pvMax;
  }
  public Long getPv()
  {
    return pv;
  }
  public void setPv(Long pv)
  {
    this.pv = pv;
  }

  public Set<Arme> getArmes()
  {
    return armes;
  }

  public void setArmes(Set<Arme> armes)
  {
    this.armes = armes;
  }

  public Set<Lieu> getLieux()
  {
    return lieux;
  }

  public void setLieux(Set<Lieu> lieux)
  {
    this.lieux = lieux;
  }
}
