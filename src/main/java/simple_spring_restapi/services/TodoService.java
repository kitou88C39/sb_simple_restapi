package simple_spring_restapi.services;

import simple_spring_restapi.models.TodoItem;

public interface TodoService {
    public TodoItem saveTodoItem(TodoItem todoItem);
}
