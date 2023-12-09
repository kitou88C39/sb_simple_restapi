package simple_spring_restapi.services;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import simple_spring_restapi.models.TodoItem;

@Service
public class TodoServiceImpl implements TodoService {
    private final AtomicInteger _counter = new AtomicInteger();
    private final List<TodoItem> _todoItems = new ArrayList<>() {
        {
            add(new TodoItem(_counter.incrementAndGet(), title:"todo 1"));
            add(new TodoItem(_counter.incrementAndGet(), title:"todo 2"));
            add(new TodoItem(_counter.incrementAndGet(), title:"todo 3"));
        }
    };

    @Override
    public TodoItem saveTodoItem(TodoItem todoItem) {
        if (Object.isNull(todoItem)) {
        throw new resposeStatusException(HttpStatus.BAD_REQUEST,reason: "Todo item must not be null.");
        }
         todoItem.setId(_counter.incrementAndGet());
         _todoItems.add(TodoItem);

         return todoItem;
    }

    @Override
    public List<TodoItem> getTodoItems() {
        return this._todoItems;
    }

    @Override
    public TodoItem updateTodoItem(int id, TodoItem todoItem) {
        TodoItem found = findTodoItemById(id);
        _todoItems.remove(found);
        _todoItems.add(todoItem);
        return todoItem;
    }

    @Override
    public void deleteTodoItem(int id) {
        TodoItem found = _findTodoItemById(id);
        _todoItems.remove(found);

    }

    private TodoItem _findTodoItemById(int id) {
        Optional<TodoItem> found = _todoItems.stream().filter(item -> item.getId() == id).findAny();
        if (!found.isPresent()) {
            throw new resposeStatusException(HttpStatus.NOT_FOUND, reason:"Not found");
        }
        return found.get();
    }
}
