package nl.bo.bacpatternpoint.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class StepResponseDto {
    private Long id;
    @NotNull(message = "Titel is verplicht")
    @Size(min = 5, max = 50, message = "Titel moet tussen 5 en 50 karakters zijn")
    private String title;
    @NotNull(message = "Beschrijving is verplicht")
    @Size(min = 5, max = 300, message = "Beschrijving moet tussen 5 en 300 karakters zijn")
    private String description;

    public StepResponseDto(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public StepResponseDto() {
    }

    public StepResponseDto(String title, String description) {
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
