package model;

public class ListItem {
    private String title;
    private int id;
    private String hint;

    public ListItem(String title, int id,String hint) {
        this.title = title;
        this.id = id;
        this.hint=hint;
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
        return "ListItem{" +
                "title=" + title+"}";
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}
