package nl.bo.bacpatternpoint.dtos;

public class AbbreviationCreateDto {
    private String abbreviated;
    private String fullForm;

    public AbbreviationCreateDto() {
    }
    public AbbreviationCreateDto(String abbreviated, String fullForm) {
        this.abbreviated = abbreviated;
        this.fullForm = fullForm;
    }
    public String getFullForm() {
        return fullForm;
    }

    public void setFullForm(String fullForm) {
        this.fullForm = fullForm;
    }

    public String getAbbreviated() {
        return abbreviated;
    }

    public void setAbbreviated(String abbreviated) {
        this.abbreviated = abbreviated;
    }
}
