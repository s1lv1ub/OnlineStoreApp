package ing.store.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    @NotBlank
    @Size(min = 2, message = "Category name must be at least 2 characters long")
    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;
}
