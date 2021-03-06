package es.us.hermes.smartcitizen.data.api.google.fit.entity;


public class HeartRateSampleFit {

    Float bpm;
    Long startTime;
    Long endTime;

    public HeartRateSampleFit() {
    }

    public HeartRateSampleFit(Float bpm, Long startTime, Long endTime) {
        this.bpm = bpm;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Float getBpm() {
        return bpm;
    }

    public void setBpm(Float bpm) {
        this.bpm = bpm;
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
