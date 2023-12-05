package simple_spring_restapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
    @RequestMapping(method = RequestMethod.GET, path = "/todos")
    public String getTodoItems() {
        return "get todo items";
    }

@RestController
public class TodoController {
    @RequestMapping(method = RequestMethod.GET, path = "/todos")
    public String getTodoItems() {
        return "get todo items";
    }
    @RequestMapping(method = RequestMethod.GET, path = "/todos")
    public String getTodoItems() {
        return "get todo items";
    }
    @RequestMapping(method = RequestMethod.POST, path = "/todos")
    public String creteTodoItems() {
        return "get todo items";
    }
    @RequestMapping(method = RequestMethod.PUT, path = "/todos")
    public String updateTodoItems() {
        return "get todo items";
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "/todos")
    public String deleteTodoItems() {
        return "get todo items";
    }
}
