package simple_spring_restapi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import simple_spring_restapi.models.TodoItem;
import simple_spring_restapi.services.TodoService;

@RequestMapping(path = TodoController.BASE_URL)
@RestController
public class TodoController {
    public static final String BASE_URL = "/api/v1/todos";
    @Autowired
    private TodoService _todoService;

    @GetMapping(path = "")
    public ResponseEntity<List<TodoItem>> getTodoItems() {
        List<TodoItem> todoItems = _todoService.getTodoItems();
        return ResponseEntity.ok(todoItems);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TodoItem> getTodoItems(@PathVariable int id) {
        TodoItem found = _todoService.getTodoItemById(id);
        return ResponseEntity.ok(found);
    }

    @PostMapping(path="")
    public ResponseEntity<todoItem> creteTodoItems(@Valid @RequestBody TodoItem newTodoItem) {
        TodoItem saveTodoItem = _todoService.saveTodoItem(newTodoItem);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}");
             .bulidAndExpand(saveTodoItem.getId()).toUri();
        return ResponseEntity.created(location).body(newTodoItem);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateTodoItems(@RequestBody TodoItem newTodoItem, @PathVariable int id) {
        _todoService.updateTodoItems(id, newTodoItem);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> removeTodoItems(@PathVariable int id) {
        _todoService.deleteTodoItem(id);
        return ResponseEntity.noContent().build();
    }

}