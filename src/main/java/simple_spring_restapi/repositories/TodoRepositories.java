package simple_spring_restapi.repositories;

import org.springframework.stereotype.Repository;

import com.juniordevmind.simplespringrestapi.models.TodoItem;

@Repository
public interface TodoRepositories extends JpaRepository<TodoItem, Integer> {

}
