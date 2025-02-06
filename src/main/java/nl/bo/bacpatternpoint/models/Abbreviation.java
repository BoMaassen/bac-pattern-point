package nl.bo.bacpatternpoint.models;

import jakarta.persistence.*;

@Entity
@Table(name = "abbreviations")
public class Abbreviation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String abbreviated;
    private String fullForm;
    @ManyToOne
    @JoinColumn(name = "pattern_id", referencedColumnName = "id")
    private Pattern pattern;

    public Abbreviation(String abbreviated, String fullForm) {
        this.abbreviated = abbreviated;
        this.fullForm = fullForm;
    }

    public Abbreviation() {
    }

    public String getFullForm() {
        return fullForm;
    }

    public void setFullForm(String fullForm) {
        this.fullForm = fullForm;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }


    public String getAbbreviated() {
        return abbreviated;
    }

    public void setAbbreviated(String abbreviated) {
        this.abbreviated = abbreviated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
