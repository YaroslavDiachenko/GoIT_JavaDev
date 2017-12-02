package model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "developers")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "salary")
    private BigDecimal salary;

    @ManyToMany
    @JoinTable(name = "developers_skills",
            joinColumns = @JoinColumn(name = "developer_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<Skill> skills;

    @ManyToMany
    @JoinTable(name = "projects_developers",
            joinColumns = @JoinColumn(name = "developer_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    private Set<Project> projects;

    public Developer() {
    }

    public Developer(String firstName, String lastName, BigDecimal salary, Set<Skill> skills, Set<Project> projects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.skills = skills;
        this.projects = projects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public void show() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\tDeveloper {id=");
        stringBuilder.append(id);
        stringBuilder.append(", firstName=");
        stringBuilder.append(firstName);
        stringBuilder.append(", lastName=");
        stringBuilder.append(lastName);
        stringBuilder.append(", salary=");
        stringBuilder.append(salary);
        stringBuilder.append(", skills=(");
        if (skills != null && skills.size() > 0) {
            for (Skill i : skills) stringBuilder.append(i.getName()).append(",");
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        } else stringBuilder.append("no assigned skills");
        stringBuilder.append("), projects=(");
        if (projects != null && projects.size() > 0) {
            for (Project i : projects) stringBuilder.append(i.getName()).append(",");
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        } else stringBuilder.append("no assigned projects");
        stringBuilder.append(")}");
        System.out.println("\t" + stringBuilder.toString());
    }
}
