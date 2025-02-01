package nl.bo.bacpatternpoint.dtos;

import java.util.List;

public class PatternResponseDto {
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
    private ImageResponseDto image;
    private List<StepResponseDto> steps;
    private List<AbbreviationResponseDto> abbreviations;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ImageResponseDto getImage() {
        return image;
    }

    public void setImage(ImageResponseDto image) {
        this.image = image;
    }

    public List<StepResponseDto> getSteps() {
        return steps;
    }

    public void setSteps(List<StepResponseDto> steps) {
        this.steps = steps;
    }

    public List<AbbreviationResponseDto> getAbbreviations() {
        return abbreviations;
    }

    public void setAbbreviations(List<AbbreviationResponseDto> abbreviations) {
        this.abbreviations = abbreviations;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getHookSize() {
        return hookSize;
    }

    public void setHookSize(double hookSize) {
        this.hookSize = hookSize;
    }

    public int getAmountOfYarn() {
        return amountOfYarn;
    }

    public void setAmountOfYarn(int amountOfYarn) {
        this.amountOfYarn = amountOfYarn;
    }

    public String getTypeYarn() {
        return typeYarn;
    }

    public void setTypeYarn(String typeYarn) {
        this.typeYarn = typeYarn;
    }

    public boolean isScissor() {
        return scissor;
    }

    public void setScissor(boolean scissor) {
        this.scissor = scissor;
    }

    public boolean isDarningNeedle() {
        return darningNeedle;
    }

    public void setDarningNeedle(boolean darningNeedle) {
        this.darningNeedle = darningNeedle;
    }

    public boolean isMeasuringTape() {
        return measuringTape;
    }

    public void setMeasuringTape(boolean measuringTape) {
        this.measuringTape = measuringTape;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
