packge com.example.demo.model;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.AllArgsContructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
@Data
@AllArgsContructor
@NoArgsConsturctor
public class User{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
}