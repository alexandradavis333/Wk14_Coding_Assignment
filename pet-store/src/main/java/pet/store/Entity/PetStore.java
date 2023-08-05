package pet.store.Entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;
import java.util.HashSet;
import jakarta.persistence.JoinColumn;
import pet.store.Entity.*;

@Entity
@Data
public class PetStore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long petStoreId;
	private String petStoreName;
	private String petStoreAddress;
	private String petStoreCity;
	private String petStoreState;
	private String petStoreZip;
	private String petStorePhone;
	

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinTable(name="pet_store_customer", joinColumns = @JoinColumn(name="pet_store_id"), inverseJoinColumns = @JoinColumn(name="customer_id"))
	private Set<Customer> customers = new HashSet<>();
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="petStore", cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<Employee> employees = new HashSet<>();
}
