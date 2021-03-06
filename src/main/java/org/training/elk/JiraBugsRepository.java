package org.training.elk;


import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JiraBugsRepository extends ElasticsearchRepository<JiraBugs, String>{
	 List<JiraBugs> findByStatus(String status);
}
