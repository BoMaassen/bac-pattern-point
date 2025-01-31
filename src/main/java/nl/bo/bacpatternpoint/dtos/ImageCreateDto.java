package nl.bo.bacpatternpoint.dtos;

import jakarta.validation.constraints.NotBlank;

public class ImageCreateDto {
    @NotBlank
    private String fileName;
    @NotBlank(message = "URL cannot be blank")
    private String url;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
