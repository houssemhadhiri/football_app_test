package Matawan.football.equipe.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "equipe")
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String acronym;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "equipe")
    private List<Joueur> joueurs;
    private double budget;


    public Equipe() {
    }

    public Equipe(Long id, String name, String acronym, List<Joueur> joueurs, double budget) {
        this.id = id;
        this.name = name;
        this.acronym = acronym;
        this.joueurs = joueurs;
        this.budget = budget;

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

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }


    @Override
    public String toString() {
        return "Equipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", acronym='" + acronym + '\'' +
                ", joueurs=" + joueurs +
                ", budget=" + budget +
                '}';
    }
}

