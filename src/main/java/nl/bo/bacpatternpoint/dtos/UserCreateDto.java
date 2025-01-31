package nl.bo.bacpatternpoint.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserCreateDto {
    @NotBlank(message = "Gebruikersnaam is verplicht")
    @Size(max = 255, message = "Gebruikersnaam mag maximaal 255 tekens lang zijn")
    private String username;
    @NotBlank(message = "Wachtwoord is verplicht")
    @Size(min = 8, max = 255, message = "Wachtwoord moet tussen 8 en 255 tekens lang zijn")
    private String password;
    @NotBlank(message = "Rol is verplicht")
    private String role;
    @NotBlank(message = "Email is verplicht")
    @Email(message = "Email moet een geldig e-mailadres zijn")
    private String email;
    @Size(max = 500, message = "Biografie mag maximaal 500 tekens lang zijn")
    private String biography;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
