package org.training.elk;


import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;

@Configuration
@EnableElasticsearchRepositories(basePackages = "org.training.elk")
@ComponentScan(basePackages = { "org.training.elk" })
public class EsConfig {
  
    @Value("${elasticsearch.home:D:\\Public\\elasticsearch-6.3.2\\bin\\elasticsearch}")
    private String elasticsearchHome;

    @Value("${elasticsearch.cluster.name:elasticsearch}")
    private String clusterName;
    

    @Bean
    public Client client() throws Exception {
    	Settings elasticsearchSettings = Settings.builder()
    	          .put("client.transport.sniff", true)
    	          .put("path.home", elasticsearchHome)
    	          .put("cluster.name", clusterName).build();
    	        TransportClient client = new PreBuiltTransportClient(elasticsearchSettings);
    	        client.addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));
    	        return client;
    }

 
    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(client());
    }

}
