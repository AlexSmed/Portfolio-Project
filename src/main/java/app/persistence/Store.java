package app.persistence;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Store {

    @Id
    @Column(name = "store_id")
    private int  store_id;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Products> products = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Routines> routines = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bulletin> bulletins = new ArrayList<>();

}
