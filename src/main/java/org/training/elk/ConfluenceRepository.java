package org.training.elk;


import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfluenceRepository extends ElasticsearchRepository<Confluence, String>{
	//List<Confluence> findByLink(String link);
}
