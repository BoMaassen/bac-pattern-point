package nl.bo.bacpatternpoint.dtos;

public class AbbreviationUpdateDto {
    private String abbreviated;
    private String full;

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getAbbreviated() {
        return abbreviated;
    }

    public void setAbbreviated(String abbreviated) {
        this.abbreviated = abbreviated;
    }

}
