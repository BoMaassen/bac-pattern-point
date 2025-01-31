package nl.bo.bacpatternpoint.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import nl.bo.bacpatternpoint.models.Image;

public class PostResponseDto {
    private long id;
    private String title;
    private String category;
    private String description;
    private int likes;
    private boolean isDraft;
    @JsonIgnoreProperties(value = {"contents", "contentType"})
    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean isDraft() {
        return isDraft;
    }

    public void setDraft(boolean draft) {
        isDraft = draft;
    }
}
