package com.mytesttask.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Department")
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "head_of_department_id")
    private Lector headOfDepartment;


    @ManyToMany(cascade = CascadeType.ALL,
                fetch = FetchType.EAGER)
    @JoinTable(name = "department_lector",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "lector_id"))
    private Set<Lector> lectors;

    public void addLectorToDepartment(Lector lector){
        if(lectors == null){
            lectors = new HashSet<>();
        }
        lectors.add(lector);
    }

    public Department() {
    }

    public Department(String name, Lector headOfDepartment) {
        this.name = name;
        this.headOfDepartment = headOfDepartment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lector getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(Lector headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    public Set<Lector> getLectors() {
        return lectors;
    }

    public void setLectors(Set<Lector> lectors) {
        this.lectors = lectors;
    }
}
