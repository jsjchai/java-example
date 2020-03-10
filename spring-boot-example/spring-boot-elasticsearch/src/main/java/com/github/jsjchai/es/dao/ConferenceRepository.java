package com.github.jsjchai.es.dao;

import com.github.jsjchai.es.domain.Conference;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author jsjchai
 */
public interface ConferenceRepository extends ElasticsearchRepository<Conference, String> {
}
