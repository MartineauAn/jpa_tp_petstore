package fr.epsi.b3.c1.entity;

import fr.epsi.b3.c1.enums.ProdType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String code;

    private String label;

    @Enumerated(EnumType.STRING)
    private ProdType type;

    private Double price;

    @ManyToMany(mappedBy = "products", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<PetStore> petStores;

    public Product() {
    }

    public Product(String code, String label, ProdType type, Double price) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
        this.petStores = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ProdType getType() {
        return type;
    }

    public void setType(ProdType type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<PetStore> getPetStores() {
        return petStores;
    }

    public void setPetStores(Set<PetStore> petStores) {
        this.petStores = petStores;
    }

    public void addPetStore(PetStore petStore){
        this.petStores.add(petStore);
        petStore.getProducts().add(this);
    }
}
