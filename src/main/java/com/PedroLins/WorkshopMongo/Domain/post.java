package com.PedroLins.WorkshopMongo.Domain;

import com.PedroLins.WorkshopMongo.dto.authorDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Document(collection = "post")
public class post implements Serializable {
    private final static long serialVersionUID = 1L;

    @Id
    private String id;

    private authorDTO author;
    private Date date;
    private String title;
    private String body;

    //CONSTRUCTORS

    public post() {
    }

    public post(String id, authorDTO author, Date date, String title, String body) {
        this.id = id;
        this.author = author;
        this.date = date;
        this.title = title;
        this.body = body;
    }

    //GETTERS AND SETTERS


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public authorDTO getAuthor() {
        return author;
    }

    public void setAuthor(authorDTO author) {
        this.author = author;
    }

    //HASHCODE AND EQUALS

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        post post = (post) o;
        return Objects.equals(id, post.id) && Objects.equals(author, post.author) && Objects.equals(date, post.date)
                && Objects.equals(title, post.title) && Objects.equals(body, post.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, date, title, body);
    }
}
