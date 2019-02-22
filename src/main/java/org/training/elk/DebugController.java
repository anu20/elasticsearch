package org.training.elk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class DebugController {
	
	@Autowired
	private JiraBugsRepository repository;
	
	@PostMapping("/saveJiraBugs")
	public int saveCustomer(@RequestBody List<JiraBugs> jiraBugs) {
		repository.saveAll(jiraBugs);
		return jiraBugs.size();
	}
	
	@GetMapping("/findAll")
	public Iterable<JiraBugs> findAllJiraBugs() {
		return repository.findAll();
	}

	@GetMapping("/findByStatus/{status}")
	public List<JiraBugs> findByStatus(@PathVariable String status) {
		return repository.findByStatus(status);
	}
	
	@DeleteMapping("/deleteAll") 
	public void deleteAll() {
		repository.deleteAll();
	}
}
