package pet.store.service;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import pet.store.controller.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;
import pet.store.controller.*;
import pet.store.Entity.PetStore;
import pet.store.controller.model.PetStoreData;
import pet.store.dao.PetStoreDao;

@Service
public class PetStoreService {
	
	@Autowired
	private static PetStoreDao petStoreDao;
	
	@Transactional(readOnly = false)
	public PetStoreData savePetStore(PetStoreData petStoreData) {
		Long petStoreId = petStoreData.getPetStoreId();
		PetStore petStore = null;
		
		if(Objects.isNull(petStoreId)) {
			petStore = new PetStore();
		}
		else {
		petStore = findOrCreatePetStoreById(petStoreId);
		
		copyPetStoreFields(petStore, petStoreData);
	}
		return new PetStoreData(petStoreDao.save(petStore));

	}
	
	private static PetStore findPetStoreById(Long petStoreId) {
		return petStoreDao.findById(petStoreId).orElseThrow(() -> new NoSuchElementException("Pet store id cannot be found."));	
		}

	private void copyPetStoreFields(PetStore petStore, PetStoreData petStoreData) {
		petStore.setPetStoreId(petStore.getPetStoreId());
		petStore.setPetStoreName(petStore.getPetStoreName());
		petStore.setPetStoreAddress(petStore.getPetStoreAddress());
		petStore.setPetStoreCity(petStore.getPetStoreCity());
		petStore.setPetStoreState(petStore.getPetStoreState());
		petStore.setPetStoreZip(petStore.getPetStoreZip());
		petStore.setPetStorePhone(petStore.getPetStorePhone());
		
	}

	private PetStore findOrCreatePetStoreById(Long petStoreId) {
		PetStore petStore;
		if(Objects.isNull(petStoreId)) {
			petStore = new PetStore();
		}
		else {
		petStore = findOrCreatePetStoreById(petStoreId);
		}
		return petStore;
}

	@Transactional(readOnly = true)
	public static List<PetStoreData> retrieveAllPetStores() {
		List<PetStore> petStores = petStoreDao.findAll();
		List<PetStoreData> result = new LinkedList<>();
		
		for(PetStore petStore : petStores) {
			result.add(new PetStoreData(petStore));
		}
		return result;
	}

	public static PetStoreData retrievePetStoreById(Long petStoreId) {
		PetStore petStore = findPetStoreById(petStoreId);
		return new PetStoreData(petStore);
	}

}
