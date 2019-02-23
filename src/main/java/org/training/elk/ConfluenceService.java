package org.training.elk;

import java.util.List;

import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@Service
public class ConfluenceService {
	@Autowired
	private ElasticsearchTemplate template;
	
	public List<Confluence> multiMatchConfluenceQuery(String textData) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.multiMatchQuery(textData).
				field("project_name^3").field("page_name").field("link").type(MultiMatchQueryBuilder.Type.PHRASE_PREFIX).minimumShouldMatch("90%").type("most_fields")).build();
		List<Confluence> confluence = template.queryForList(searchQuery, Confluence.class);
		System.out.println();
		return confluence;
	} 
	 
		public static String removeStopWords(String textFile) throws Exception {
				StringBuilder textOutput = new StringBuilder("");
				String[] words = textFile.split(" ");
				System.out.println(words);
				CharArraySet stopWords = EnglishAnalyzer.getDefaultStopSet();

				// Process sample input and remove stop words.
				for (String s : words) {
					if (stopWords.contains(s)) {
						// Do something with the stop words found in the sample input or discard them.
					} else {
						textOutput.append(s); // Append non-stop word to textOutput.
					}
				}
				return textOutput.toString();

			}

		
}
