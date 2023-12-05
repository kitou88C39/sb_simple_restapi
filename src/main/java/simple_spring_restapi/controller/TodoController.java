package simple_spring_restapi.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
    public String getTodoItems() {
        return "get todo items";

    }

}
