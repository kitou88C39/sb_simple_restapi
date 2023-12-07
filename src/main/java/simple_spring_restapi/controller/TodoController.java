package simple_spring_restapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
            add(new TodoItem(id:1, title:"todo 1"));
            add(new TodoItem(id:2, title:"todo 2"));
            add(new TodoItem(id:3, title:"todo 3"));
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
            // return 404
        }
        return found;
    }

    @RequestMapping(method = RequestMethod.POST, path = "")
    public todoItem creteTodoItems(@RequestBody TodoItem todoItem) {
        todoItem.setId(id:4);
        _todoItems.add(todoItem);
        return todoItem;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public todoItem updateTodoItems(@RequestBody TodoItem todoItem, @PathVariable int id) {
        TodoItem found = _getTodoItemById(id);
        if (found == null) {
            // return 404
        }
        _todoItems.remove(found);
        _todoItems.add(todoItem);

        return todoItem;
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void removeTodoItems(@PathVariable int id) {
        TodoItem found = _getTodoItemById(id);
        if (found == null) {
            // return 404
        }
        _todoItems.remove(found);
    }

    private TodoItem _getTodoItemById(int id) {
        return _todoItems.stream().filter(item -> item.getId() == id).findAny().orElse(null);

    }
}