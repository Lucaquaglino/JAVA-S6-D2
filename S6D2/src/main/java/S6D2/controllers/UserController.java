package S6D2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import S6D2.entities.User;
import S6D2.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;

//Metodo per salvare l oggetto utente con POST
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User saveUser(@RequestBody User body) {
		User createdUser = userService.createUser(body);
		return createdUser;
	}

	// Metodo per ricevere lista utenti con GET
	@GetMapping
	public List<User> getUsers() {
		return userService.getUsers();
	}

//Metodo per ricevere utente tramite ID con GET
	@GetMapping("/{userId}")
	public User findById(@PathVariable int userId) throws Exception {
		return userService.findById(userId).orElseThrow(() -> new Exception("NON TROVATO"));
	}

	// Metodo per modificare utente tramite ID con PUT
	@PutMapping("/{userId}")
	public User findAndUpdate(@PathVariable int userId, @RequestBody User body) throws Exception {
		return userService.findByIdAndUpdate(userId, body).orElseThrow(() -> new Exception("NON TROVATO"));
	}

	// Metodo per eliminare utente tramite ID con DELETE
	@DeleteMapping("/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void findAndDelete(@PathVariable int userId) {
		userService.findByIdAndDelete(userId);
	}
}
