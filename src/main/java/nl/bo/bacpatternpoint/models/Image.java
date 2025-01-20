package nl.bo.bacpatternpoint.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String fileName;
    @NotBlank(message = "URL cannot be blank")
   /* @Pattern(regexp = "^https?:\\/\\/[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)+(:\\d+)?(\\/[^\\s]*)?$", message = "Geen geldig URL format")*/
    private String url;
    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post post;

    public Image() {
    }

    public Image(String fileName, String url) {
        this.fileName = fileName;
        this.url = url;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
