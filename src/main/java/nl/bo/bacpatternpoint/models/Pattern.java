package nl.bo.bacpatternpoint.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "patterns")
public class Pattern extends Content{
    @NotNull(message = "Niveau is verplicht")
    private String level;
    @Positive(message = "Haaknaald moet groter dan 0mm zijn")
    private double hookSize;
    @Min(value = 1, message = "Aantal gram wol moet minimaal 1 zijn")
    private int amountOfYarn;
    private String typeYarn;
    private boolean scissor;
    private boolean darningNeedle;
    private boolean measuringTape;
    @Positive(message = "Lengte moet groter dan 0cm zijn")
    private double length;
    @Positive(message = "Breedte moet groter dan 0cm zijn")
    private double width;
    @OneToOne(cascade = CascadeType.ALL)
    private Image image;
    @OneToMany(mappedBy = "pattern", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Step> steps;
    @OneToMany(mappedBy = "pattern", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Abbreviation> abbreviations;
    @OneToMany(mappedBy = "pattern", cascade = CascadeType.ALL)
    private List<Comment> comments;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post post;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Abbreviation> getAbbreviations() {
        return abbreviations;
    }

    public void setAbbreviations(List<Abbreviation> abbreviations) {
        this.abbreviations = abbreviations;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public boolean isMeasuringTape() {
        return measuringTape;
    }

    public void setMeasuringTape(boolean measuringTape) {
        this.measuringTape = measuringTape;
    }

    public boolean isDarningNeedle() {
        return darningNeedle;
    }

    public void setDarningNeedle(boolean darningNeedle) {
        this.darningNeedle = darningNeedle;
    }

    public boolean isScissor() {
        return scissor;
    }

    public void setScissor(boolean scissor) {
        this.scissor = scissor;
    }

    public String getTypeYarn() {
        return typeYarn;
    }

    public void setTypeYarn(String typeYarn) {
        this.typeYarn = typeYarn;
    }

    public int getAmountOfYarn() {
        return amountOfYarn;
    }

    public void setAmountOfYarn(int amountOfYarn) {
        this.amountOfYarn = amountOfYarn;
    }

    public double getHookSize() {
        return hookSize;
    }

    public void setHookSize(double hookSize) {
        this.hookSize = hookSize;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}


