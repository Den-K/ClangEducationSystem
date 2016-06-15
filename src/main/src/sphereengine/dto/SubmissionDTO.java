package sphereengine.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubmissionDTO {

    @JsonProperty("sourceCode")
    private String sourceCode;

    @JsonProperty("language")
    private String language;

    @JsonProperty("input")
    private String input;

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "SubmissionDTO{" +
                "sourceCode='" + sourceCode + '\'' +
                ", language='" + language + '\'' +
                ", input='" + input + '\'' +
                '}';
    }
}
