package nl.bo.bacpatternpoint.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CommentCreateDto {
    @NotNull(message = "Reactie is verplicht")
    @Size(min = 1, max = 150, message = "Reactie moet tussen 1 en 150 karakters zijn")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
