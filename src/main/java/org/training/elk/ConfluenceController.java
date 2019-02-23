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
public class ConfluenceController {
	
	@Autowired
	private ConfluenceService confluenceservice;
	
	@Autowired
	private ConfluenceRepository confluenceRepository;

	@GetMapping("/searchConfluence/{text}")
	public List<Confluence> doFullStringSearch(@PathVariable String text) throws Exception{
			String textData = confluenceservice.removeStopWords(text);
			return confluenceservice.multiMatchConfluenceQuery(textData);
		} 
	
	@PostMapping("/saveConfluence")
	public int saveConfluence(@RequestBody List<Confluence> confluence) {
		confluenceRepository.saveAll(confluence);
		return confluence.size();
	}
	
	@GetMapping("/findAllConfluence")
	public Iterable<Confluence> findAllConfluence() {
		return confluenceRepository.findAll();
	}
	
	@DeleteMapping("/deleteAllConfluence") 
	public void deleteAll() {
		confluenceRepository.deleteAll();
	}

}
