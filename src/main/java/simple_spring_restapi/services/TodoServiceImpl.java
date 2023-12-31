package simple_spring_restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.juniordevmind.simplespringrestapi.models.TodoItem;

import simple_spring_restapi.repositories.TodoRepositories;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository _todoRepository;

    @Override
    public TodoItem getTodoItemsById(int id) {
        return _findTodoItemById(id);
    }

    @Override
    public List<TodoItem> getTodoItems() {
        return _todoRepository.findAll();
    }

    @Override
    public Todo removeTodoItemById(int id) {
        _todoRepository.deleteById(id);
    }

    @Override
    public TodoItem saveTodoItem(TodoItem todoItem) {
        return _todoRepository.save(todoItem);
    }

    @Override
    public TodoItem updateTodoItem(int id, TodoItem todoItem) {
        return _todoRepository.save(todoItem);
    }

    private TodoItem _findTodoItemById(int id) throws NotFoundException {
        Optional<TodoItem> found = _todoRepository.findById(id);
        if (!found.isPresent()) {
            throw new NotFoundException("The todo item is not available");
        }
        return found.get();
    }
}