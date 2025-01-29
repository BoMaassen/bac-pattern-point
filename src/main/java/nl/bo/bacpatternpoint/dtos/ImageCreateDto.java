package nl.bo.bacpatternpoint.dtos;

import jakarta.validation.constraints.NotBlank;

public class ImageCreateDto {
    @NotBlank
    private String fileName;
    @NotBlank(message = "URL cannot be blank")
    /*@Pattern(regexp = "^https?:\\/\\/[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)+(:\\d+)?(\\/[^\\s]*)?$", message = "Geen geldig URL format")*/
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
