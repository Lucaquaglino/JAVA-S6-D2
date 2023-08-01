package S6D2.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import S6D2.entities.User;

@Service
public class UserService {

	private List<User> userList = new ArrayList<>();

	public User createUser(User user) {
		Random rndm = new Random();
		user.setId(rndm.nextInt());
		this.userList.add(user);
		return user;
	}

	public List<User> getUsers() {
		return this.userList;
	}

	public Optional<User> findById(int id) {
		User u = null;

		for (User user : userList) {
			if (user.getId() == id)
				u = user;
		}

		return Optional.ofNullable(u);
		// ritorno un Optional, quindi vuol dire che potrebbe essere o User o null
	}

	public void findByIdAndDelete(int id) {
		ListIterator<User> iterator = this.userList.listIterator();

		while (iterator.hasNext()) {
			User currentUser = iterator.next();
			if (currentUser.getId() == id) {
				iterator.remove();
			}
		}
	}

	public Optional<User> findByIdAndUpdate(int id, User user) {
		User found = null;

		for (User currentUser : userList) {
			if (currentUser.getId() == id) {
				found = currentUser;
				found.setName(user.getName());
				found.setSurname(user.getSurname());
				found.setId(id);
				found.setEmail(user.getEmail());
			}
		}
		return Optional.ofNullable(found);

	}
}
