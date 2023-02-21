package fr.epsi.b3.c1.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "animal")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractAnimal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date birth;

    private String couleur;

    @ManyToOne
    @JoinColumn(name = "petStore_id")
    private PetStore petStore;

    public AbstractAnimal() {
    }

    public AbstractAnimal(Date birth, String couleur) {
        this.birth = birth;
        this.couleur = couleur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        if (this.petStore != null){
            this.petStore.getAnimals().remove(this);
        }

        this.petStore = petStore;

        if (this.petStore != null){
            this.petStore.getAnimals().add( this);
        }
    }

    @Override
    public String toString() {
        return "AbstractAnimal{" +
                "id=" + id +
                ", birth=" + birth +
                ", couleur='" + couleur + '\'' +
                ", petStore=" + petStore +
                "}\n";
    }
}
