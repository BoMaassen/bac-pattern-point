package nl.bo.bacpatternpoint.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String title;
    private String contentType;
    @NotBlank(message = "URL cannot be blank")
    private String url;
    @Lob
    private byte[] contents;

    public Image() {
    }

    public Image(String title, String url, String contentType, byte[] contents) {
        this.title = title;
        this.url = url;
        this.contentType = contentType;
        this.contents = contents;
    }

    /*public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }*/

 /*   public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }*/

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getContents() {
        return contents;
    }

    public void setContents(byte[] contents) {
        this.contents = contents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String fileName) {
        this.title = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
