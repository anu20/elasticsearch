package org.training.elk;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class JiraBugsController {
	
	@Autowired
	private JiraBugsService service;

	
/*
	@GetMapping("/search/{text}")
	public List<JiraBugs> doMultimatchQuery(@PathVariable String text) {
		return service.multiMatchQuery(text);
	}
	*/
	@GetMapping("/searchJira/{text}")
	public List<JiraBugs> doFullStringSearch(@PathVariable String text) throws Exception{
			String textData = service.removeStopWords(text);
			return service.multiMatchQuery(textData);
		} 

}
