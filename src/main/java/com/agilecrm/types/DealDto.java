package com.agilecrm.types;

import java.util.List;
import java.util.Map;


//POJO  --> Plain Old Java Object
public class DealDto {
    private String name;
    private String expected_value;
    private String probability;
    private String milestone;
    private Integer close_date;
    private List<Long> contact_ids;
    private List<Map<String, String>> custom_data;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setExpected_value(String expectedValue) {
        this.expected_value = expectedValue;
    }

    public String getExpectedValue() {
        return expected_value;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }

    public String getProbability() {
        return probability;
    }

    public void setMilestone(String milestone) {
        this.milestone = milestone;
    }

    public String getMilestone() {
        return milestone;
    }

    public void setClose_date(Integer closeDate) {
        this.close_date = closeDate;
    }

    public Integer getCloseDate() {
        return close_date;
    }

    public void setContact_ids(List<Long> contactIds) {
        this.contact_ids = contactIds;
    }

    public List<Long> getContactIds() {
        return this.contact_ids;
    }

    public void setCustom_data(List<Map<String, String>> customData) {
        this.custom_data = customData;
    }

    public List<Map<String, String>> getCustomData() {
        return custom_data;
    }

}
