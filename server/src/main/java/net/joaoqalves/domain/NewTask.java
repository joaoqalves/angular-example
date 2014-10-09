package net.joaoqalves.domain;

import javax.validation.constraints.NotNull;

public class NewTask {

    @NotNull
    private String title;

    public NewTask() {

    }

    public NewTask(String title) {
        this.title = title;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
