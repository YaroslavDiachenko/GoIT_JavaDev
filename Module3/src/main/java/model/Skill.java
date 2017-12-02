package model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "developers_skills",
            joinColumns = @JoinColumn(name = "skill_id"),
            inverseJoinColumns = @JoinColumn(name = "developer_id"))
    private Set<Developer> developers;

    public Skill() {
    }

    public Skill(String name, Set<Developer> developers) {
        this.name = name;
        this.developers = developers;
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

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }

    public void show() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Skill {id=");
        stringBuilder.append(id);
        stringBuilder.append(", name=");
        stringBuilder.append(name);
        stringBuilder.append(", developers=(");
        if (developers != null && developers.size() > 0) {
            for (Developer i : developers) stringBuilder.append(i.getLastName()).append(",");
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        } else stringBuilder.append("no assigned developers");
        stringBuilder.append(")}");
        System.out.println(stringBuilder.toString());
    }
}