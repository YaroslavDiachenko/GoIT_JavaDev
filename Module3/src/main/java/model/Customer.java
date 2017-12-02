package model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "customers_projects",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    private Set<Project> projects;

    public Customer() {
    }

    public Customer(String name, Set<Project> projects) {
        this.name = name;
        this.projects = projects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public void show() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\tCustomer {id=");
        stringBuilder.append(id);
        stringBuilder.append(", name=");
        stringBuilder.append(name);
        stringBuilder.append(", projects=(");
        if (projects != null && projects.size() > 0) {
            for (Project i : projects) stringBuilder.append(i.getName()).append(",");
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        } else stringBuilder.append("no assigned projects");
        stringBuilder.append(")}");
        System.out.println(stringBuilder.toString());
    }
}
