package fr.epsi.b3.c1.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "cat")
public class Cat extends AbstractAnimal{

    private String chipId;

    public Cat() {
        super();
    }

    public Cat(Date birth, String couleur, String chipId) {
        super(birth, couleur);
        this.chipId = chipId;
    }

    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }
}
