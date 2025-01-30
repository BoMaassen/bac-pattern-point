package nl.bo.bacpatternpoint.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.List;

public class PatternCreateDto {
    @NotNull(message = "Titel is verplicht")
    @Size(min = 5, max = 50, message = "Titel moet tussen 5 en 50 karakters zijn")
    private String title;
    @NotNull(message = "Niveau is verplicht")
    private String level;
    @NotNull(message = "Beschrijving is verplicht")
    @Size(min = 5, max = 300, message = "Beschrijving moet tussen 5 en 300 karakters zijn")
    private String description;
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
    private List<StepCreateDto> steps;
    private List<AbbreviationCreateDto> abbreviations;

    public List<StepCreateDto> getSteps() {
        return steps;
    }

    public void setSteps(List<StepCreateDto> steps) {
        this.steps = steps;
    }

    public List<AbbreviationCreateDto> getAbbreviations() {
        return abbreviations;
    }

    public void setAbbreviations(List<AbbreviationCreateDto> abbreviations) {
        this.abbreviations = abbreviations;
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

}
