package model;

/**
 * Created by juhi bhatnagar on 3/7/2017.
 */

public class Find {
    private String title;
    private String hint;

    public Find(String title,String hint) {
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
        return "Find{" +
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
