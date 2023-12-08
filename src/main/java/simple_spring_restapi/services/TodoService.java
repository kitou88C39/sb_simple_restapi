package simple_spring_restapi.services;

import java.util.List;

import simple_spring_restapi.models.TodoItem;

public interface TodoService {
    public TodoItem saveTodoItem(TodoItem todoItem);

    public List<TodoItem> getTodoItems();

    public TodoItem getTodoItemById(int id);

    public TodoItem updateTodoItems(int id, TodoItem todoItem);

    public void deleteTodoItem(int id);
}
