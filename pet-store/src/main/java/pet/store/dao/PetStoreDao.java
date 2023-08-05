package pet.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.store.Entity.PetStore;

public interface PetStoreDao extends JpaRepository<PetStore, Long> {

}
