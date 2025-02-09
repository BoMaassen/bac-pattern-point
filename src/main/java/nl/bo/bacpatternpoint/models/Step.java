package nl.bo.bacpatternpoint.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "steps")
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Titel is verplicht")
    @Size(min = 5, max = 50, message = "Titel moet tussen 5 en 50 karakters zijn")
    private String title;
    @NotNull(message = "Beschrijving is verplicht")
    @Size(min = 5, max = 300, message = "Beschrijving moet tussen 5 en 300 karakters zijn")
    private String description;
    @ManyToOne
    @JoinColumn(name = "pattern_id", referencedColumnName = "id", nullable = false)
    private Pattern pattern;

    public Step() {
    }

    public Step(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Step(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Step(String title, String description, Pattern pattern) {
        this.title = title;
        this.description = description;
        this.pattern = pattern;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
