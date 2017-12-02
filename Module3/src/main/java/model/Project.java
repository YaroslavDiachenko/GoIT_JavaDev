package model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private BigDecimal cost;

    @ManyToMany
    @JoinTable(name = "projects_developers",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "developer_id"))
    private Set<Developer> developers;

    @ManyToMany
    @JoinTable(name = "companies_projects",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id"))
    private Set<Company> companies;

    @ManyToMany
    @JoinTable(name = "customers_projects",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private Set<Customer> customers;

    public Project() {
    }

    public Project(String name, BigDecimal cost, Set<Developer> developers, Set<Company> companies, Set<Customer> customers) {
        this.name = name;
        this.cost = cost;
        this.developers = developers;
        this.companies = companies;
        this.customers = customers;
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

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public void show() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\tProject {id=");
        stringBuilder.append(id);
        stringBuilder.append(", name=");
        stringBuilder.append(name);
        stringBuilder.append(", cost=");
        stringBuilder.append(cost);
        stringBuilder.append(", developers=(");
        if (developers != null && developers.size() > 0) {
            for (Developer i : developers) stringBuilder.append(i.getLastName()).append(",");
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        } else stringBuilder.append("no assigned developers");
        stringBuilder.append("), companies=(");
        if (companies != null && companies.size() > 0) {
            for (Company i : companies) stringBuilder.append(i.getName()).append(",");
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        } else stringBuilder.append("no assigned companies");
        stringBuilder.append("), customers=(");
        if (customers != null && customers.size() > 0) {
            for (Customer i : customers) stringBuilder.append(i.getName()).append(",");
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        } else stringBuilder.append("no assigned customers");
        stringBuilder.append(")}");

        System.out.println("\t" + stringBuilder.toString());
    }
}
