package pet.store.App;
import pet.store.Entity.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Lombok;
import lombok.ToString;
import lombok.NoArgsConstructor;
import java.util.Set;
import java.util.HashSet;

@Data
@NoArgsConstructor
public class PetStoreCustomer {

	public PetStoreCustomer(Customer customer) {
		// TODO Auto-generated constructor stub
	}
	private Long customerId;
	private String customerFirstName;
	private String customerLastName;
	private String customerEmail;
}
