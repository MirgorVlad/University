package com.mytesttask.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Lector")
@Table(name = "lectors")
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private Integer salary;

    @Column(name="degree")
    @Enumerated(EnumType.STRING)
    private Degree degree;

    @ManyToMany(mappedBy = "lectors")
    private Set<Department> departments;

    public void addDepartmentToLector(Department department){
        if(departments == null){
            departments = new HashSet<>();
        }
        departments.add(department);
    }

    public Lector() {
    }

    public Lector(String name, Integer salary, Degree degree) {
        this.name = name;
        this.salary = salary;
        this.degree = degree;
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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }
}

