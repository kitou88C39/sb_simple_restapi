package simple_spring_restapi.models;

import lombok.Data;

@Data
public class TodoItem {
    private int id;
    private String title;

    public TodoItem() {

    }

    public TodoItem(int id, String title) {
        this.id = id;
        this.title = title;
    }
}
