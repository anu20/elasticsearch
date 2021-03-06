package org.training.elk;

import java.util.List;

import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

@Service
public class JiraBugsService {
	@Autowired
	private ElasticsearchTemplate template;
	
	public List<JiraBugs> multiMatchQuery(String text) {
			SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.multiMatchQuery(text)
					.field("description").field("summary").field("status").type(MultiMatchQueryBuilder.Type.BEST_FIELDS).minimumShouldMatch("90%").type("most_fields")).build();
			List<JiraBugs> jiraBugs = template.queryForList(searchQuery, JiraBugs.class);
			System.out.println();
			

			return jiraBugs;
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
