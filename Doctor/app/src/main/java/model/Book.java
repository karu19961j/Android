package model;

/**
 * Created by juhi bhatnagar on 3/7/2017.
 */

public class Book {
    private String title;
    private int id;

    public Book(String title, int id) {
        this.title = title;
        this.id = id;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title=" + title +"}";
    }




}
