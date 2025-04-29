package be.thomasmore.familieplanner.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
@Entity
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titel;
    @Column
    private String beschrijving;
    @DateTimeFormat
    private LocalDateTime starttijd;
    @DateTimeFormat
    private LocalDateTime eindtijd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public LocalDateTime getStarttijd() {
        return starttijd;
    }

    public void setStarttijd(LocalDateTime starttijd) {
        this.starttijd = starttijd;
    }

    public LocalDateTime getEindtijd() {
        return eindtijd;
    }

    public void setEindtijd(LocalDateTime eindtijd) {
        this.eindtijd = eindtijd;
    }
}
