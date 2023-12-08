package simple_spring_restapi.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ResponseStatusException;
import org.springframework.web.servlet.function.EntityResponse;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import simple_spring_restapi.models.TodoItem;

@RequestMapping(path = TodoController.BASE_URL)
@RestController
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

    @GetMapping(path = "")
    public ResponseEntity<List<TodoItem>> getTodoItems() {
        return ResponseEntity.ok(_todoItems);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TodoItem> getTodoItems(@PathVariable int id) {
        TodoItem found = _findTodoItemById(id);
        if (found == null) {
            throw new resposeStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return ResponseEntity.ok(found);
    }

    @PostMapping(path="")
    public ResponseEntity<todoItem> creteTodoItems(@RequestBody TodoItem todoItem) {
        if (found == null) {
            throw new resposeStatusException(HttpStatus.BAD_REQUEST,reason: "Todo");
        }
        todoItem.setId(_counter.incrementAndGet());
        _todoItems.add(newTodoItem);
             .bulidAndExpand(todoItem.getId()).toUri();
        return ResponseEntity.created(location).body(newTodoItem);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateTodoItems(@RequestBody TodoItem todoItem, @PathVariable int id) {
        TodoItem found = _getTodoItemById(id);
        if (found == null) {
            throw new resposeStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        _todoItems.remove(found);
        _todoItems.add(todoItem);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> removeTodoItems(@PathVariable int id) {
        TodoItem found = _findTodoItemById(id);
        if (found == null) {
            throw new resposeStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        _todoItems.remove(found);
        return ResponseEntity.noContent().build();
    }

    private TodoItem _findTodoItemById(int id) {
        return _todoItems.stream().filter(item -> item.getId() == id).findAny().orElse(null);

    }
}