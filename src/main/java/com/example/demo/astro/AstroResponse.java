package com.example.demo.astro;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AstroResponse {
    private String date;
    private String explanation;
    private String hdurl;
    private String url;
    private String title;
    @JsonProperty("media_type")
    private String mediaType;

    protected AstroResponse() {}

    public AstroResponse(String date, String explanation, String hdurl, String url, String title, String mediaType) {
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.url = url;
        this.title = title;
        this.mediaType = mediaType;
    }
    
    @Override
    public String toString() {
        return String.format(
            "AstroResponse[date='%s', explanation='%s', hdurl='%s', url='%s', title='%s']",
            date, explanation, hdurl, url, title);
    }

    public String getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }
    
    public String getHdurl(){
        return hdurl;
    }

    public String getUrl(){
        return url;
    }

    public String getTitle(){
        return title;
    }

    public String getMediaType(){
        return mediaType;
    }
}
