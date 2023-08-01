package S6D2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lang")

public class Es1Controller {

	@GetMapping("/{lang}")
	public String getMessage(@PathVariable String l) {

		if (l.equals("IT")) {
			return "Ciao, mondo!";

		} else if (l.equals("EN")) {
			return "Hello World";

		} else {
			return "ERROR, please choose between EN or IT/ERRORE, scegli tra EN o IT";
		}
	}
}
