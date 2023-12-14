package simple_spring_restapi.models;

import jakarta.persistence.Column;
import jakarta.annotation.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "todos", schema = "business")
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.Auto)
    @Column(name = "id", nullable = false)
    private int id;
    @NotBlank(message = "Title must not be blank.")
    @Column(name = "id", nullable = false)
    private String title;

}
