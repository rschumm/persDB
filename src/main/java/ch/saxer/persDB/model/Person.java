package ch.saxer.persDB.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String vorname;

    private String email;

    @Id
    @Column(name = "PERS_PK")
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "ADR_FK", nullable = false)
    private Adresse adresse;

    @ManyToMany
    @JoinTable(name = "PERSON_ITEM", joinColumns = {@JoinColumn(name = "PERS_FK", referencedColumnName = "PERS_PK")}, inverseJoinColumns = {@JoinColumn(name = "ITEM_FK", referencedColumnName = "ITEM_PK")})
    private Set<Item> items;

    public Person(String name) {
        this.name = name;
        this.vorname = "";
        this.email = "";
        this.adresse = new Adresse();
        this.items = new HashSet<Item>();
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
