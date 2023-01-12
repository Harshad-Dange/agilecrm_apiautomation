package com.agilecrm.types;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


//POJO  --> Plain Old Java Object
public class DealDto {
    private String name;
    private String expected_value;
    private String probability;
    private int close_date;
    private String milestone;
    private List<Long> contact_ids;
//    private List<Map<String,String>> custom_data;
private List<CustomDataDto> custom_data;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpected_value() {
        return expected_value;
    }

    public void setExpected_value(String expected_value) {
        this.expected_value = expected_value;
    }

    public String getProbability() {
        return probability;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }

    public int getClose_date() {
        return close_date;
    }

    public void setClose_date(int close_date) {
        this.close_date = close_date;
    }

    public String getMilestone() {
        return milestone;
    }

    public void setMilestone(String milestone) {
        this.milestone = milestone;
    }

    public List<Long> getContact_ids() {
        return contact_ids;
    }

    public void setContact_ids(List<Long> contact_ids) {
        this.contact_ids = contact_ids;
    }

    public List<CustomDataDto> getCustom_data() {
        return custom_data;
    }

    public void setCustom_data(List<CustomDataDto> custom_data) {
        this.custom_data = custom_data;
    }
}
