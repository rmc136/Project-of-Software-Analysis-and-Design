package domain;

import java.util.ArrayList;
import java.util.List;

public class UserCatalog {
	private List<User> users;
	
	public UserCatalog() {
		users = new ArrayList<>();
		
		User user1 = new User("Mary", "123");
		User user2 = new User("Peter", "ABC");
		User user3 = new User("John Snow", "123ABC");
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
		
	}
	
	public void addUser(User user) {
		users.add(user);
	}

	public User getUserByName(String name) {
		for (User user : users) {
			if (user.getName().equals(name)) {
				return user;
			}
		}
		return null;
	}
	
}
