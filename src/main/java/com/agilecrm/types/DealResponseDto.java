package com.agilecrm.types;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DealResponseDto {
    private String colorName;
    private long id;
    private boolean apply_discount;
    private double discount_value;
    private double discount_amt;
    private String discount_type;
    private String name;
    private List<String> contact_ids;
    private List<CustomDataDto> custom_data;
    private List<Object> products;
    private double expected_value;
    private String milestone;
    private int probability;
    private int close_date;
    private String owner_id;
    private int created_time;
    private int milestone_changed_time;
    private String entity_type;
    private List<Object> notes;
    private List<Object> note_ids;
    private int note_created_time;
    private long pipeline_id;
    private int won_date;
    private boolean archived;
    private int lost_reason_id;
    private int deal_source_id;
    private double total_deal_value;
    private int updated_time;
    private boolean isCurrencyUpdateRequired;

    private List<Object> tags;
    private double currency_conversion_value;
    private List<Object> tagsWithTime;
    private OwnerDto owner;



    private List<Object> contacts;

    @JsonProperty("colorName")
    public String getColorName() {
        return this.colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    @JsonProperty("id")
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty("apply_discount")
    public boolean getApply_discount() {
        return this.apply_discount;
    }

    public void setApply_discount(boolean apply_discount) {
        this.apply_discount = apply_discount;
    }


    @JsonProperty("discount_value")
    public double getDiscount_value() {
        return this.discount_value;
    }

    public void setDiscount_value(double discount_value) {
        this.discount_value = discount_value;
    }


    @JsonProperty("discount_amt")
    public double getDiscount_amt() {
        return this.discount_amt;
    }

    public void setDiscount_amt(double discount_amt) {
        this.discount_amt = discount_amt;
    }


    @JsonProperty("discount_type")
    public String getDiscount_type() {
        return this.discount_type;
    }

    public void setDiscount_type(String discount_type) {
        this.discount_type = discount_type;
    }


    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @JsonProperty("contact_ids")
    public List<String> getContact_ids() {
        return this.contact_ids;
    }

    public void setContact_ids(List<String> contact_ids) {
        this.contact_ids = contact_ids;
    }

    @JsonProperty("custom_data")
    public List<CustomDataDto> getCustom_data() {
        return this.custom_data;
    }

    public void setCustom_data(List<CustomDataDto> custom_data) {
        this.custom_data = custom_data;
    }


    @JsonProperty("products")
    public List<Object> getProducts() {
        return this.products;
    }

    public void setProducts(List<Object> products) {
        this.products = products;
    }


    @JsonProperty("expected_value")
    public double getExpected_value() {
        return this.expected_value;
    }

    public void setExpected_value(double expected_value) {
        this.expected_value = expected_value;
    }


    @JsonProperty("milestone")
    public String getMilestone() {
        return this.milestone;
    }

    public void setMilestone(String milestone) {
        this.milestone = milestone;
    }


    @JsonProperty("probability")
    public int getProbability() {
        return this.probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }


    @JsonProperty("close_date")
    public int getClose_date() {
        return this.close_date;
    }

    public void setClose_date(int close_date) {
        this.close_date = close_date;
    }


    @JsonProperty("owner_id")
    public String getOwner_id() {
        return this.owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }


    @JsonProperty("created_time")
    public int getCreated_time() {
        return this.created_time;
    }

    public void setCreated_time(int created_time) {
        this.created_time = created_time;
    }


    @JsonProperty("milestone_changed_time")
    public int getMilestone_changed_time() {
        return this.milestone_changed_time;
    }

    public void setMilestone_changed_time(int milestone_changed_time) {
        this.milestone_changed_time = milestone_changed_time;
    }


    @JsonProperty("entity_type")
    public String getEntity_type() {
        return this.entity_type;
    }

    public void setEntity_type(String entity_type) {
        this.entity_type = entity_type;
    }


    @JsonProperty("notes")
    public List<Object> getNotes() {
        return this.notes;
    }

    public void setNotes(List<Object> notes) {
        this.notes = notes;
    }


    @JsonProperty("note_ids")
    public List<Object> getNote_ids() {
        return this.note_ids;
    }

    public void setNote_ids(List<Object> note_ids) {
        this.note_ids = note_ids;
    }


    @JsonProperty("note_created_time")
    public int getNote_created_time() {
        return this.note_created_time;
    }

    public void setNote_created_time(int note_created_time) {
        this.note_created_time = note_created_time;
    }


    @JsonProperty("pipeline_id")
    public long getPipeline_id() {
        return this.pipeline_id;
    }

    public void setPipeline_id(long pipeline_id) {
        this.pipeline_id = pipeline_id;
    }


    @JsonProperty("archived")
    public boolean getArchived() {
        return this.archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }


    @JsonProperty("won_date")
    public int getWon_date() {
        return this.won_date;
    }

    public void setWon_date(int won_date) {
        this.won_date = won_date;
    }


    @JsonProperty("lost_reason_id")
    public int getLost_reason_id() {
        return this.lost_reason_id;
    }

    public void setLost_reason_id(int lost_reason_id) {
        this.lost_reason_id = lost_reason_id;
    }


    @JsonProperty("deal_source_id")
    public int getDeal_source_id() {
        return this.deal_source_id;
    }

    public void setDeal_source_id(int deal_source_id) {
        this.deal_source_id = deal_source_id;
    }


    @JsonProperty("total_deal_value")
    public double getTotal_deal_value() {
        return this.total_deal_value;
    }

    public void setTotal_deal_value(double total_deal_value) {
        this.total_deal_value = total_deal_value;
    }


    @JsonProperty("updated_time")
    public int getUpdated_time() {
        return this.updated_time;
    }

    public void setUpdated_time(int updated_time) {
        this.updated_time = updated_time;
    }


    @JsonProperty("isCurrencyUpdateRequired")
    public boolean getIsCurrencyUpdateRequired() {
        return this.isCurrencyUpdateRequired;
    }

    public void setIsCurrencyUpdateRequired(boolean isCurrencyUpdateRequired) {
        this.isCurrencyUpdateRequired = isCurrencyUpdateRequired;
    }


    @JsonProperty("currency_conversion_value")
    public double getCurrency_conversion_value() {
        return this.currency_conversion_value;
    }

    public void setCurrency_conversion_value(double currency_conversion_value) {
        this.currency_conversion_value = currency_conversion_value;
    }


    @JsonProperty("tags")
    public List<Object> getTags() {
        return this.tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }


    @JsonProperty("tagsWithTime")
    public List<Object> getTagsWithTime() {
        return this.tagsWithTime;
    }

    public void setTagsWithTime(List<Object> tagsWithTime) {
        this.tagsWithTime = tagsWithTime;
    }


    @JsonProperty("owner")
    public OwnerDto getOwner() {
        return this.owner;
    }

    public void setOwner(OwnerDto owner) {
        this.owner = owner;
    }


    @JsonProperty("contacts")
    public List<Object> getContacts() {
        return this.contacts;
    }

    public void setContacts(List<Object> contacts) {
        this.contacts = contacts;
    }

}
