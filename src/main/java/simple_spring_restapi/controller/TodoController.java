package simple_spring_restapi.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    private final List<TodoItem> _todoItems = new ArrayList<>() {
        {
            add(new TodoItem(id:1, title:"todo 1"));
            add(new TodoItem(id:2, title:"todo 2"));
            add(new TodoItem(id:3, title:"todo 3"));
        }
    };

    @RequestMapping(method = RequestMethod.GET, path = "/todos")
    public List<TodoItem> getTodoItems() {
        return _todoItems;
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
