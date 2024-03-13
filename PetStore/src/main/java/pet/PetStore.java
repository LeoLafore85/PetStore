package pet;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "PETSTORE")
public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "manager_name", nullable = false)
    private String managerName;

    @OneToMany(mappedBy = "petStore")
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) { this.managerName = managerName; }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
