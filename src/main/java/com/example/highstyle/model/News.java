package com.example.highstyle.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity(name="news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    @Type(type="date")
    private Date date;

    private String image;

    @Column(length = 60000)
    @Type(type="text")
    private String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public News(){
    }
}
