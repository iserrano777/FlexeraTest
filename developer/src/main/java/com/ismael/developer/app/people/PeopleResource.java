package com.ismael.developer.app.people;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


/*
 * This class expose all the service methods
 */
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class PeopleResource {
	
	@Autowired
	private PeopleHardcodedService personManagementService;

	
	// Retrieve  all the people 
	@GetMapping("/people")
	public List<People> getAllPeople() {
		return personManagementService.findAll();
	}

	@GetMapping("/people/{id}")
	public People getPeople(@PathVariable long id) {
		return personManagementService.findById(id);
	}

	// Delete people
	@DeleteMapping("/people/{id}")
	public ResponseEntity<Void> deletePeople(@PathVariable long id) {

		People person = personManagementService.deleteById(id);

		if (person != null) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}

	//Update existing people
	@PutMapping("/people/{id}")
	public ResponseEntity<People> updateCourse(@PathVariable long id,
			@RequestBody People person) {

		People peopleUpdated = personManagementService.save(person);

		return new ResponseEntity<People>(person, HttpStatus.OK);
	}
	
   //To add new people
	@PostMapping("/people")
	public ResponseEntity<Void> createPeople(@RequestBody People person) {

		People createdPerson = personManagementService.save(person);

		// Location
		// Get current resource url
		/// {id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdPerson.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

}
