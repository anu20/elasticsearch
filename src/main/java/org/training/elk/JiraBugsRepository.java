package org.training.elk;


import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface JiraBugsRepository extends ElasticsearchRepository<JiraBugs, String>{
	 List<JiraBugs> findByStatus(String status);
}
