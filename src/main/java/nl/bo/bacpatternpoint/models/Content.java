package nl.bo.bacpatternpoint.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@MappedSuperclass
public abstract class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Titel is verplicht")
    @Size(min = 5, max = 50, message = "Titel moet tussen 5 en 50 karakters zijn")
    private String title;
    @NotNull(message = "Beschrijving is verplicht")
    @Size(min = 5, max = 300, message = "Beschrijving moet tussen 5 en 300 karakters zijn")
    private String description;
    private int likes;
    private boolean isDraft;
    @OneToOne(cascade = CascadeType.ALL)
    private Image image;

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isDraft() {
        return isDraft;
    }

    public void setDraft(boolean draft) {
        isDraft = draft;
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