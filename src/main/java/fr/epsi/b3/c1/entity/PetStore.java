package fr.epsi.b3.c1.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "petstore")
public class PetStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String managerName;

    @Embedded
    private Adresse adresse;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "petStores_products",
            joinColumns = @JoinColumn(name = "petStore_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_numero", referencedColumnName = "id")
    )
    private Set<Product> products;

    @OneToMany(mappedBy = "petStore", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<AbstractAnimal> animals;

    public PetStore() {
    }

    public PetStore(String name, String managerName, Adresse adresse) {
        this.name = name;
        this.managerName = managerName;
        this.adresse = adresse;
        this.products = new HashSet<>();
        this.animals = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<AbstractAnimal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<AbstractAnimal> animals) {
        this.animals = animals;
    }

    public void addAnimal(AbstractAnimal animal){
        this.animals.add(animal);
        animal.setPetStore(this);
    }

    public void addProduct(Product product){
        this.products.add(product);
        product.getPetStores().add(this);
    }
}
