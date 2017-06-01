package model;

/**
 * Created by juhi bhatnagar on 3/8/2017.
 */

public class Ayurved {
    private String title;

    public Ayurved(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Ayurved{" +
                "title='" + title + '\'' +
                '}';
    }
}
