package es.us.hermes.smartcitizen.data.api.google.fit.entity;


public class ActivitySampleFit{

    String name;
    Float confidence;
    Long startTime;
    Long endTime;

    public ActivitySampleFit() {
    }

    public ActivitySampleFit(String name, Float confidence, Long startTime, Long endTime) {
        this.name = name;
        this.confidence = confidence;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getConfidence() {
        return confidence;
    }

    public void setConfidence(Float confidence) {
        this.confidence = confidence;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }
}
