package com.product.entity;

// import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "MST_STORE")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private String owner;

    // @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // @JoinColumn(name="MST_PRODUCT")
    // private List<Product> products;
}
