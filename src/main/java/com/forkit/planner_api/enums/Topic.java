package com.forkit.planner_api.enums;

public enum Topic {

    BUCKET_LIST("Bucket List"),

    SHOPPING_LIST("Shopping List"),

    GIFT_IDEAS("Gift Ideas"),

    TO_WATCH_LIST("To Watch List"),

    DO_NOT_FORGET("Things not to forget...");

    private final String topicTitle;

    private Topic(String topicTitle){
        this.topicTitle = topicTitle;
    }
    public String getTopicTitle() {
        return topicTitle;
    }
}
