package simple_spring_restapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import simple_spring_restapi.models.TodoItem;

@Service
public class TodoServiceImpl implements TodoService {

    @Override
    public TodoItem saveTodoItem(TodoItem todoItem) {
        return null;
    }

    @Override
    public List<TodoItem> getTodoItems() {
        return null;
    }

    @Override
    public TodoItem getTodoItemById(int id) {
        return null;
    }

    @Override
    public TodoItem saveTodoItem(int id, TodoItem todoItem) {
        return null;
    }
}
