package nl.bo.bacpatternpoint.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class PostCreateDto {
    @NotNull(message = "Titel is verplicht")
    @Size(min = 5, max = 50, message = "Titel moet tussen 5 en 50 karakters zijn")
    private String title;
    @NotNull(message = "Categorie is verplicht")
    private String category;
    @NotNull(message = "Beschrijving is verplicht")
    @Size(min = 5, max = 300, message = "Beschrijving moet tussen 5 en 300 karakters zijn")
    private String description;
    private boolean isDraft;

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
