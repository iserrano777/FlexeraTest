package com.ismael.developer.app.people;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


/*
 * This class exposes  methods that are going to be invoked from our Rest Resource.
 */
@Service
public class PeopleHardcodedService {

	private static List<People> persons = new ArrayList<>();
	private static long idCounter = 0;
    //Some persons are hardcoded  so the app could start having some data
	static {
		persons.add(new People(++idCounter, "Jasson Grand", 35,5895.00,"jassson.grand@test.com","35 Adelaide street"));
		persons.add(new People(++idCounter, "Samuel Lyons", 27,16525.00 , "samuel.lyons@test.com", "80 Beersbridge Road"));
		persons.add(new People(++idCounter, "Stephen Hutchens", 32, 8567.00,  "stephen.hutchens@test.com", "156 Ann Street"));
		persons.add(new People(++idCounter, "Michael Clayton", 49, 56789.00, "michael.clayton@test.com","18 Clara Street"));
	}

	public List<People> findAll() {
		return persons;
	}

	public People save(People person) {
		if (person.getId() == -1 || person.getId() == 0) {
			person.setId(++idCounter);
			persons.add(person);
		} else {
			deleteById(person.getId());
			persons.add(person);
		}
		return person;
	}

	public People deleteById(long id) {
		People person = findById(id);

		if (person == null)
			return null;

		if (persons.remove(person)) {
			return person;
		}

		return null;
	}

	public People findById(long id) {
		for (People person : persons) {
			if (person.getId() == id) {
				return person;
			}
		}

		return null;
	}
	
}
