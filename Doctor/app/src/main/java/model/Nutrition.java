package model;

/**
 * Created by juhi bhatnagar on 3/9/2017.
 */

public class Nutrition {
    private String title;
    private String hint;

    public Nutrition(String title,String hint) {
        this.title = title;
        this.hint=hint;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Nutrition{" +
                "title='" + title + '\'' +
                '}';
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}
