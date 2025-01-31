package nl.bo.bacpatternpoint.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

public class Comment {
    private Long id;
    @NotNull(message = "Reactie is verplicht")
    @Size(min = 1, max = 150, message = "Reactie moet tussen 1 en 150 karakters zijn")
    private String message;
    @CreationTimestamp
    private LocalDate timeStamp;
    private int likes;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
