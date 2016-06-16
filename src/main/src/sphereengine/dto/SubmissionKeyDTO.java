package sphereengine.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubmissionKeyDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("error")
    private String error;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "SubmissionKeyDTO{" +
                "id='" + id + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
