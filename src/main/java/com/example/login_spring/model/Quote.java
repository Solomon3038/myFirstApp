package com.example.login_spring.model;



import javax.persistence.*;
import java.util.Objects;


@Table(name = "quote")
@Entity
public class Quote {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private String text;

    @ManyToOne(fetch = FetchType.EAGER) //kak sdes
    @JoinColumn(name = "author")
    private User author;

    public Quote(String text, User author) {
        this.text = text;
        this.author = author;
    }

    public Quote() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote = (Quote) o;
        return Objects.equals(getId(), quote.getId()) &&
                Objects.equals(getText(), quote.getText()) &&
                Objects.equals(getAuthor(), quote.getAuthor());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getText(), getAuthor());
    }
}
