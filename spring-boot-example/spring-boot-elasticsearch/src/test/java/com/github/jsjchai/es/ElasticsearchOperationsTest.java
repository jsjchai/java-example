package com.github.jsjchai.es;

import com.github.jsjchai.es.domain.Conference;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;

import java.text.ParseException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

/**
 * @author jsjchai
 */
@SpringBootTest(classes = ElasticsearchApplication.class)
class ElasticsearchOperationsTest {



    @Autowired
    ElasticsearchOperations operations;

    @Test
    void textSearch() throws ParseException {

        String expectedDate = "2014-10-29";
        String expectedWord = "java";
        CriteriaQuery query = new CriteriaQuery(
                new Criteria("keywords").contains(expectedWord).and(new Criteria("date").greaterThanEqual(expectedDate)));

        List<Conference> result = operations.queryForList(query, Conference.class);

        assertThat(result, hasSize(3));


    }
}
