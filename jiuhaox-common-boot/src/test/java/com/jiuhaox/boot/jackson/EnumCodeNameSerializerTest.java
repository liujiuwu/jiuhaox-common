package com.jiuhaox.boot.jackson;

import com.jiuhaox.boot.enums.EnumCodeName;
import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@JsonTest
@ContextConfiguration(classes = EnumCodeNameSerializer.class)
class EnumCodeNameSerializerTest {
    @Resource
    private JacksonTester<EnumCodeName> jacksonTester;

    @Getter
    @RequiredArgsConstructor
    enum TestEnumCodeName implements EnumCodeName {
        TEST1("测试1"),
        TEST2("测试2");

        private final String name;
    }

    @SneakyThrows
    @Test
    void serialize() {
        final TestEnumCodeName test1 = TestEnumCodeName.TEST1;
        final JsonContent<EnumCodeName> jsonContent = jacksonTester.write(TestEnumCodeName.TEST1);
        assertThat(jsonContent).hasJsonPathStringValue("@.code");
        assertThat(jsonContent).extractingJsonPathStringValue("@.code").isEqualTo(test1.name());

        assertThat(jsonContent).hasJsonPathStringValue("@.name");
        assertThat(jsonContent).extractingJsonPathStringValue("@.name").isEqualTo(test1.getName());
    }
}