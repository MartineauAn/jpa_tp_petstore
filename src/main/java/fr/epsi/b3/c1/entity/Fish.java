package fr.epsi.b3.c1.entity;

import fr.epsi.b3.c1.enums.FishLivEnv;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "fish")
public class Fish extends AbstractAnimal {

    @Enumerated(EnumType.STRING)
    private FishLivEnv livingEnv;

    public Fish() {
        super();
    }

    public Fish(Date birth, String couleur, FishLivEnv livingEnv) {
        super(birth, couleur);
        this.livingEnv = livingEnv;
    }

    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }
}
