package com.mrdiaz.retrofitobjects12022018;

/**
 * Created by mrdiaz on 12/02/2018.
 */

public class TaskModel {

    private long userId;
    private long id;
    private String title;
    private String body;

    public TaskModel() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUserId() {

        return userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
