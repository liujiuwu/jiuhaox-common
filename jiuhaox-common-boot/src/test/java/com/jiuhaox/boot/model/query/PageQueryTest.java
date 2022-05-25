package com.jiuhaox.boot.model.query;

import com.jiuhaox.boot.model.query.PageQuery;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PageQueryTest {
    @Test
    void should_correct_page_when_query_given_page() {
        PageQuery query = new PageQuery().setSize(10);
        query.setPage(-1);
        assertThat(query.getPage()).isEqualTo(0);
    }

    @Test
    void should_correct_page_when_query_given_correct_page() {
        PageQuery query = new PageQuery().setSize(10);
        query.setPage(1);
        assertThat(query.getPage()).isEqualTo(1);
    }

    @Test
    void should_correct_size_when_query_given_error_size() {
        PageQuery query = new PageQuery();
        query.setSize(-1);
        assertThat(query.getSize()).isEqualTo(PageQuery.DEFAULT_SIZE);

        query.setSize(0);
        assertThat(query.getSize()).isEqualTo(PageQuery.DEFAULT_SIZE);

        query.setSize(100);
        assertThat(query.getSize()).isEqualTo(100);

        query.setSize(3000);
        assertThat(query.getSize()).isEqualTo(PageQuery.DEFAULT_SIZE);
    }
}