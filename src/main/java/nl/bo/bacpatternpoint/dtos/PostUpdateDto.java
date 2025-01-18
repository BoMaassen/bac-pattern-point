package nl.bo.bacpatternpoint.dtos;

import java.util.List;

public class PostUpdateDto {
    private String title;
    private String category;
    private String description;
    private boolean isDraft;
    private List<ImageUpdateDto> images;

    public List<ImageUpdateDto> getImages() {
        return images;
    }

    public void setImages(List<ImageUpdateDto> images) {
        this.images = images;
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

    public boolean isDraft() {
        return isDraft;
    }

    public void setDraft(boolean draft) {
        isDraft = draft;
    }
}
