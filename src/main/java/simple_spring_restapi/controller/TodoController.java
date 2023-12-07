package simple_spring_restapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import simple_spring_restapi.models.TodoItem;

@RestController
@RequestMapping(path = TodoController.BASE_URL)
public class TodoController {
    public static final String BASE_URL = "/api/v1/todos";
    private final AtomicInteger _counter = new AtomicInteger();

    private final List<TodoItem> _todoItems = new ArrayList<>() {
        {
            add(new TodoItem(_counter.incrementAndGet(), title:"todo 1"));
            add(new TodoItem(_counter.incrementAndGet(), title:"todo 2"));
            add(new TodoItem(_counter.incrementAndGet(), title:"todo 3"));
        }
    };

    @RequestMapping(method = RequestMethod.GET, path = "")
    public List<TodoItem> getTodoItems() {
        return _todoItems;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public TodoItem getTodoItems(@PathVariable int id) {
        TodoItem found = _getTodoItemById(id);
        if (found == null) {
            throw new resposeStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return found;
    }

    @RequestMapping(method = RequestMethod.POST, path = "")
    public todoItem creteTodoItems(@RequestBody TodoItem todoItem) {
        todoItem.setId(_counter.incrementAndGet());
        _todoItems.add(todoItem);
        return todoItem;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public todoItem updateTodoItems(@RequestBody TodoItem todoItem, @PathVariable int id) {
        TodoItem found = _getTodoItemById(id);
        if (found == null) {
            throw new resposeStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        _todoItems.remove(found);
        _todoItems.add(todoItem);

        return todoItem;
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void removeTodoItems(@PathVariable int id) {
        TodoItem found = _getTodoItemById(id);
        if (found == null) {
            throw new resposeStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        _todoItems.remove(found);
    }

    private TodoItem _getTodoItemById(int id) {
        return _todoItems.stream().filter(item -> item.getId() == id).findAny().orElse(null);

    }
}