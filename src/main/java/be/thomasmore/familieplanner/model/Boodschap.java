package be.thomasmore.familieplanner.model;

import jakarta.persistence.*;

@Entity
public class Boodschap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String naam;
    @Column
    private String hoeveelheid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getHoeveelheid() {
        return hoeveelheid;
    }

    public void setHoeveelheid(String hoeveelheid) {
        this.hoeveelheid = hoeveelheid;
    }
}
