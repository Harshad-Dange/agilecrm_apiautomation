package com.agilecrm.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OwnerDto {
    @JsonProperty("id")
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;

    @JsonProperty("domain")
    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    private String domain;

    @JsonProperty("email")
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    @JsonProperty("phone")
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String phone;

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @JsonProperty("pic")
    public String getPic() {
        return this.pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    private String pic;

    @JsonProperty("schedule_id")
    public String getSchedule_id() {
        return this.schedule_id;
    }

    public void setSchedule_id(String schedule_id) {
        this.schedule_id = schedule_id;
    }

    private String schedule_id;

    @JsonProperty("calendar_url")
    public String getCalendar_url() {
        return this.calendar_url;
    }

    public void setCalendar_url(String calendar_url) {
        this.calendar_url = calendar_url;
    }

    private String calendar_url;

    @JsonProperty("calendarURL")
    public String getCalendarURL() {
        return this.calendarURL;
    }

    public void setCalendarURL(String calendarURL) {
        this.calendarURL = calendarURL;
    }

    private String calendarURL;
}
