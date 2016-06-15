package sphereengine.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultDTO {

    @JsonProperty("langId")
    private String langId;
    @JsonProperty("langName")
    private String langName;
    @JsonProperty("langVersion")
    private String langVersion;
    @JsonProperty("time")
    private String time;
    @JsonProperty("date")
    private String date;
    @JsonProperty("status")
    private String status;
    @JsonProperty("result")
    private String result;
    @JsonProperty("memory")
    private String memory;
    @JsonProperty("signal")
    private String signal;
    @JsonProperty("source")
    private String source;
    @JsonProperty("input")
    private String input;
    @JsonProperty("output")
    private String output;
    @JsonProperty("stderr")
    private String stderr;
    @JsonProperty("cmpinfo")
    private String cmpinfo;

    @JsonProperty("langId")
    public String getLangId() {
        return langId;
    }

    @JsonProperty("langId")
    public void setLangId(String langId) {
        this.langId = langId;
    }

    @JsonProperty("langName")
    public String getLangName() {
        return langName;
    }

    @JsonProperty("langName")
    public void setLangName(String langName) {
        this.langName = langName;
    }

    @JsonProperty("langVersion")
    public String getLangVersion() {
        return langVersion;
    }

    @JsonProperty("langVersion")
    public void setLangVersion(String langVersion) {
        this.langVersion = langVersion;
    }

    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("result")
    public String getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(String result) {
        this.result = result;
    }

    @JsonProperty("memory")
    public String getMemory() {
        return memory;
    }

    @JsonProperty("memory")
    public void setMemory(String memory) {
        this.memory = memory;
    }

    @JsonProperty("signal")
    public String getSignal() {
        return signal;
    }

    @JsonProperty("signal")
    public void setSignal(String signal) {
        this.signal = signal;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("input")
    public String getInput() {
        return input;
    }

    @JsonProperty("input")
    public void setInput(String input) {
        this.input = input;
    }

    @JsonProperty("output")
    public String getOutput() {
        return output;
    }

    @JsonProperty("output")
    public void setOutput(String output) {
        this.output = output;
    }

    @JsonProperty("stderr")
    public String getStderr() {
        return stderr;
    }

    @JsonProperty("stderr")
    public void setStderr(String stderr) {
        this.stderr = stderr;
    }

    @JsonProperty("cmpinfo")
    public String getCmpinfo() {
        return cmpinfo;
    }

    @JsonProperty("cmpinfo")
    public void setCmpinfo(String cmpinfo) {
        this.cmpinfo = cmpinfo;
    }

    @Override
    public String toString() {
        return "ResultDTO{" +
                "langId='" + langId + '\'' +
                ", langName='" + langName + '\'' +
                ", langVersion='" + langVersion + '\'' +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", result='" + result + '\'' +
                ", memory='" + memory + '\'' +
                ", signal='" + signal + '\'' +
                ", source='" + source + '\'' +
                ", input='" + input + '\'' +
                ", output='" + output + '\'' +
                ", stderr='" + stderr + '\'' +
                ", cmpinfo='" + cmpinfo + '\'' +
                '}';
    }
}
