package simple_spring_restapi.services;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
        return null;
    }

    @Override
    public TodoItem getTodoItemById(int id) {
        return null;
    }

    @Override
    public TodoItem saveTodoItem(int id, TodoItem todoItem) {
        return null;
    }
}
