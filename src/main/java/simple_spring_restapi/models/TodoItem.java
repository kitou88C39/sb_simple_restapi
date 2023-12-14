package simple_spring_restapi.models;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoItem {
    @Column
    private int id;
    @NotBlank(message = "Title must not be blank.")
    private String title;

}
