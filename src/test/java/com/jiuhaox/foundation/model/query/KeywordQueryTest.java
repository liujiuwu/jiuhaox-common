package com.jiuhaox.foundation.model.query;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class KeywordQueryTest {
    @Test
    void should_correct_when_keywordQuery_given_keywordQuery() {
        final KeywordQuery keywordQuery = new KeywordQuery();
        keywordQuery.setKeyword("test").setPage(1).setSize(10);

        assertThat(keywordQuery.getKeyword()).isEqualTo("test");
        assertThat(keywordQuery.getPage()).isEqualTo(1);
        assertThat(keywordQuery.getSize()).isEqualTo(10);
    }
}