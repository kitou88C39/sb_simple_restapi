package simple_spring_restapi.repositories;

import com.juniordevmind.simplespringrestapi.models.TodoItem;

public interface TodoRepositories extends JpaRepository<TodoItem, Integer> {

}
