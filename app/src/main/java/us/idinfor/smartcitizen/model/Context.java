package us.idinfor.smartcitizen.model;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "CONTEXT".
 */
public class Context {

    private Long id;
    private String user;
    private String deviceId;
    private Integer activity;
    private Double latitude;
    private Double longitude;
    private java.util.Date time;

    public Context() {
    }

    public Context(Long id) {
        this.id = id;
    }

    public Context(Long id, String user, String deviceId, Integer activity, Double latitude, Double longitude, java.util.Date time) {
        this.id = id;
        this.user = user;
        this.deviceId = deviceId;
        this.activity = activity;
        this.latitude = latitude;
        this.longitude = longitude;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getActivity() {
        return activity;
    }

    public void setActivity(Integer activity) {
        this.activity = activity;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public java.util.Date getTime() {
        return time;
    }

    public void setTime(java.util.Date time) {
        this.time = time;
    }

}