package simple_spring_restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.juniordevmind.simplespringrestapi.models.TodoItem;

import simple_spring_restapi.repositories.TodoRepositories;

@Service
@Primary
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository _todoRepository;

    @Override
    public Todo getTodoItemsById(int id) {
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
