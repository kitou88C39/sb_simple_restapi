package simple_spring_restapi.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    private final List<TodoItem> _todoItems = new ArrayList<>(){
        
    }

    @RequestMapping(method = RequestMethod.GET, path = "/todos")
    public String getTodoItems() {
        return "get todo items";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/todos/{id}")
    public String getTodoItems() {
        return "get todo items";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/todos")
    public String creteTodoItems() {
        return "create todo items";
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/todos/{id}")
    public String updateTodoItems() {
        return "update todo items";
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/todos/{id}")
    public String removeTodoItems() {
        return "remove todo items";
    }
}
