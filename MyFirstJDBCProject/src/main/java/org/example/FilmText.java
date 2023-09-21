package org.example;

public class FilmText {

    private int id;
    private String title;
    private String description;

    public FilmText() {}

    public FilmText(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    //setters & getters
    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


    //methods
    @Override
    public String toString(){
        return String.format("%d\t%s\t%s", id, title, description);
    }
}
