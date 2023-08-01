package S6D2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import S6D2.entities.Workstation;
import S6D2.services.WorkstationService;

@RestController
@RequestMapping("/workstations")
public class WorkstationController {

	@Autowired
	WorkstationService workstationServices;

//	 Metodo per ricevere lista postazioni con GET
	@GetMapping
	public List<Workstation> getWorkstations() {
		return workstationServices.getWorkstations();
	}

	// Metodo per ricevere postazioni tramite ID con GET
	@GetMapping("/{workstationId}")
	public Workstation findById(@PathVariable int workstationId) throws Exception {
		return workstationServices.findById(workstationId).orElseThrow(() -> new Exception("NON TROVATO"));
	}

//	@GetMapping
//	public ResponseEntity<List<Workstation>> getPostazioniByCittàETipo(String city,
//			TypeOfWorkstation typeOfWorkstation) {
//
//		List<Workstation> postazioni = workstationServices.getPostazioniByCittàETipo(city, typeOfWorkstation);
//		return new ResponseEntity<>(postazioni, HttpStatus.OK);
//	}

	// Metodo per salvare l oggetto utente con POST
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Workstation createWorkstation(@RequestBody Workstation body) {
		Workstation createdWorkstation = workstationServices.createWorkstation(body);
		return createdWorkstation;
	}

}
