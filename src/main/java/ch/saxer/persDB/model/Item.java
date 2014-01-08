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

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ITEM_PK")
    @GeneratedValue
    private int id;

    @LazyCollection(LazyCollectionOption.FALSE)
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

    @JsonIgnore
    public Set<Person> getPersonen() {
        return personen;
    }

    @JsonIgnore
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
