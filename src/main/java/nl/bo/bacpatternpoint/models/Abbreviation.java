package nl.bo.bacpatternpoint.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Abbreviations")
public class Abbreviation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String abbreviated;
    private String full;
    @ManyToOne
    @JoinColumn(name = "pattern_id", referencedColumnName = "id")
    private Pattern pattern;

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
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
