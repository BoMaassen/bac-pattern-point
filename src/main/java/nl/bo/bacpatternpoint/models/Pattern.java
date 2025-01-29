package nl.bo.bacpatternpoint.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Patterns")
public class Pattern {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String level;
    private String description;
    private double hookSize;
    private int amountOfYarn;
    private String typeYarn;
    private boolean scissor;
    private boolean darningNeedle;
    private boolean measuringTape;
    private double length;
    private double width;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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


