package com.agilecrm.types;

import java.util.List;

public class CompanyDto {
    private String type;
    private int star_value;
    private int lead_score;
    private List<String> tags;
    private List<PropertyDto> properties;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStar_value() {
        return star_value;
    }

    public void setStar_value(int star_value) {
        this.star_value = star_value;
    }

    public int getLead_score() {
        return lead_score;
    }

    public void setLead_score(int lead_score) {
        this.lead_score = lead_score;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<PropertyDto> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyDto> properties) {
        this.properties = properties;
    }
}
