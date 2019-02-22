package org.training.elk;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JiraBugsController {
	
	@Autowired
	private JiraBugsService service;

	@GetMapping("/serachMultiField/{summary}/{status}")
	public List<JiraBugs> serachByMultiField(@PathVariable String summary, @PathVariable String status) {
		return service.searchMultiField(summary, status);
	}

	@GetMapping("/customSearch/{summary}")
	public List<JiraBugs> getJiraBugsByField(@PathVariable String summary) {
		return service.getJiraBugsSearchData(summary);
	}

	@GetMapping("/search/{text}")
	public List<JiraBugs> doMultimatchQuery(@PathVariable String text) {
		return service.multiMatchQuery(text);
	}
}
