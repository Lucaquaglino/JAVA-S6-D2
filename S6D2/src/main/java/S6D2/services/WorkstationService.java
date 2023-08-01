package S6D2.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import S6D2.entities.Workstation;

@Service
public class WorkstationService {
	private List<Workstation> workstations = new ArrayList<>();

	// Metodo per tornare le postazioni
	public List<Workstation> getWorkstations() {
		return this.workstations;
	}

	// Metodo per cercare postazione per ID
	public Optional<Workstation> findById(int id) {
		Workstation w = null;

		for (Workstation workstation : workstations) {
			if (workstation.getId() == id)
				w = workstation;
		}
		return Optional.ofNullable(w);
		// ritorno un Optional, quindi vuol dire che potrebbe essere o User o null
	}

//	// Metodo per ottenere le postazioni in base alla città e al tipo di postazione
//	public List<Workstation> getPostazioniByCittàETipo(String city, TypeOfWorkstation typeOfWorkstation) {
//		List<Workstation> result = new ArrayList<>();
//		for (Workstation workstation : workstations) {
//			if (workstation.getCity().equalsIgnoreCase(city)
//					&& workstation.getTypeOfWorkstation() == typeOfWorkstation) {
//				result.add(workstation);
//			}
//		}
//		return result;
//	}

	// Metodo per creare postazione
	public Workstation createWorkstation(Workstation newWorkstation) {
		Random rndm = new Random();
		newWorkstation.setId(rndm.nextInt());
		this.workstations.add(newWorkstation);

		return newWorkstation;
	}

}
