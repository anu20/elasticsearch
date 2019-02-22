package org.training.elk;

import java.util.List;

import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

@Service
public class JiraBugsService {
	@Autowired
	private ElasticsearchTemplate template;
	
	public List<JiraBugs> searchMultiField(String summary, String status) {
		QueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("summary", summary))
				.must(QueryBuilders.matchQuery("status", status));
		NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder().withQuery(query).build();
		
		List<JiraBugs> jiraBugs = template.queryForList(nativeSearchQuery, JiraBugs.class);
		return jiraBugs;
	}
	
	public List<JiraBugs> getJiraBugsSearchData(String input) {
		
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withFilter(QueryBuilders.matchQuery("summary", input)).build();
		List<JiraBugs> jiraBugs = template.queryForList(searchQuery, JiraBugs.class);
		System.out.println(template);
		return jiraBugs;

	}
	public List<JiraBugs> multiMatchQuery(String text) {
		
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.multiMatchQuery(text)
				.field("description").field("summary").field("status").type(MultiMatchQueryBuilder.Type.BEST_FIELDS).minimumShouldMatch("50%").type("most_fields")).build();
		List<JiraBugs> jiraBugs = template.queryForList(searchQuery, JiraBugs.class);
		
		System.out.println();
		

		return jiraBugs;
	}
}
