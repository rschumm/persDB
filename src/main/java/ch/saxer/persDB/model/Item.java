package ch.saxer.persDB.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    public Item() {
        // TODO Auto-generated constructor stub
    }

    public Item(String nr) {
        this.nr = nr;
    }

    @Id
    @Column(name = "ITEM_PK")
    @GeneratedValue
    int id;

    @ManyToMany
    @JoinTable(name = "PERSON_ITEM", joinColumns = {@JoinColumn(name = "ITEM_FK", referencedColumnName = "ITEM_PK")}, inverseJoinColumns = {@JoinColumn(name = "PERS_FK", referencedColumnName = "PERS_PK")})
    private Set<Person> personen;

    private String nr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Person> getPersonen() {
        return personen;
    }

    public void setPersonen(Set<Person> personen) {
        this.personen = personen;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

}
