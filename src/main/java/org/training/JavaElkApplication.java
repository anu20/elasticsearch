package org.training;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.training.elk.JiraBugs;
import org.training.elk.JiraBugsRepository;

@SpringBootApplication
@RestController
public class JavaElkApplication {
	
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
	
	public static void main(String[] args) {
		SpringApplication.run(JavaElkApplication.class, args);
	}
	
	
}

