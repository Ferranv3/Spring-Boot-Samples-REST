package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AstroPic {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String date;

  @Column(columnDefinition = "LONGTEXT")
  private String explanation;
  
  private String hdurl;
  private String url;
  private String title;
  private String mediaType;

  protected AstroPic() {}

  public AstroPic(String date, String explanation, String hdurl, String url, String title, String mediaType) {
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
        "AstroPics[id=%d, date='%s', explanation='%s', hdurl='%s', url='%s', title='%s']",
        id, date, explanation, hdurl, url, title);
  }

  public Long getId() {
    return id;
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
