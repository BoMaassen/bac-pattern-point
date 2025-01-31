package nl.bo.bacpatternpoint.dtos;

import nl.bo.bacpatternpoint.models.Pattern;

public class AbbreviationUpdateDto {
    private String abbreviated;
    private String fullForm;

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
