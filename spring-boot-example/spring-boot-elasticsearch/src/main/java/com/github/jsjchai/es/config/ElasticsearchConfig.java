package com.github.jsjchai.es.config;

import com.github.jsjchai.es.dao.ConferenceRepository;
import com.github.jsjchai.es.domain.Conference;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.geo.GeoPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;

/**
 * @author jsjchai
 */
@Configuration
@EnableElasticsearchRepositories
@Slf4j
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {

    /**
     *  Elasticsearch 6.8.5
     */
    @Override
    public RestHighLevelClient elasticsearchClient() {
        return RestClients.create(ClientConfiguration.localhost()).rest();
    }

    @Autowired
    ElasticsearchOperations elasticsearchOperations;

    @Autowired
    ConferenceRepository repository;

    @PreDestroy
    public void deleteIndex() {
        elasticsearchOperations.deleteIndex(Conference.class);
    }

    @PostConstruct
    public void insertDataSample() {
        long count = repository.count();
        log.info("conference-index count:{}",count);
        if (count > 0) {
            repository.deleteAll();
            elasticsearchOperations.refresh(Conference.class);
        }

        // Save data sample
        repository.save(Conference.builder().date("2014-11-06").name("Spring eXchange 2014 - London")
                .keywords(Arrays.asList("java", "spring")).location(new GeoPoint(51.500152D, -0.126236D)).build());
        repository.save(Conference.builder().date("2014-12-07").name("Scala eXchange 2014 - London")
                .keywords(Arrays.asList("scala", "play", "java")).location(new GeoPoint(51.500152D, -0.126236D)).build());
        repository.save(Conference.builder().date("2014-11-20").name("Elasticsearch 2014 - Berlin")
                .keywords(Arrays.asList("java", "elasticsearch", "kibana")).location(new GeoPoint(52.5234051D, 13.4113999))
                .build());
        repository.save(Conference.builder().date("2014-11-12").name("AWS London 2014")
                .keywords(Arrays.asList("cloud", "aws")).location(new GeoPoint(51.500152D, -0.126236D)).build());
        repository.save(Conference.builder().date("2014-10-04").name("JDD14 - Cracow")
                .keywords(Arrays.asList("java", "spring")).location(new GeoPoint(50.0646501D, 19.9449799)).build());
    }
}
