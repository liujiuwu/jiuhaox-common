package com.jiuhaox.boot.application.model;

import com.jiuhaox.boot.application.model.resp.PageResp;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@JsonTest
@ContextConfiguration(classes = PageRespTest.class)
class PageRespTest {
    @Resource
    private JacksonTester<PageResp> jacksonTester;

    @SneakyThrows
    @Test
    void should_correct_result_when_toJson_given_pageResp() {
        final PageResp<String> pageResp = PageResp.<String>builder().content(Lists.list("1", "2", "3")).page(1).size(2).total(3L).build();
        final JsonContent<PageResp> jsonContent = jacksonTester.write(pageResp);
        assertThat(jsonContent).hasJsonPathArrayValue("@.content");
        assertThat(jsonContent).hasJsonPathNumberValue("@.total");
        assertThat(jsonContent).hasJsonPathNumberValue("@.page");
        assertThat(jsonContent).hasJsonPathNumberValue("@.size");

        assertThat(jsonContent).extractingJsonPathArrayValue("@.content").isNotEmpty();
        assertThat(jsonContent).extractingJsonPathNumberValue("@.total").isEqualTo(3);
        assertThat(jsonContent).extractingJsonPathNumberValue("@.page").isEqualTo(1);
        assertThat(jsonContent).extractingJsonPathNumberValue("@.size").isEqualTo(2);
    }
}