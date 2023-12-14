package simple_spring_restapi.services;

import java.util.List;

import com.juniordevmind.simplespringrestapi.models.TodoItem;

public class TodoServiceImpl implements TodoService {

    @Override
    public Todo getTodo(int id) {
        return todoDao.getTodo(id);
    }

    @Override
    public List<Todo> getTodos() {
        return todoDao.getTodos();
    }

    @Override
    public Todo createTodo(Todo todo) {
        return todoDao.createTodo(todo);
    }

    @Override
    public Todo updateTodo(Todo todo) {
        return todoDao.updateTodo(todo);
    }

    @Override
    public void deleteTodo(int id) {
        todoDao.deleteTodo(id);
    }
}
