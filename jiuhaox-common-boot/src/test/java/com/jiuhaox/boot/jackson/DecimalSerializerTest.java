package com.jiuhaox.boot.jackson;

import com.jiuhaox.boot.jackson.Decimal;
import com.jiuhaox.boot.jackson.DecimalSerializer;
import jakarta.annotation.Resource;
import lombok.Builder;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.ContextConfiguration;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@JsonTest
@ContextConfiguration(classes = DecimalSerializer.class)
class DecimalSerializerTest {
    @Resource
    private JacksonTester<TestDecimal> jacksonTester;

    @Builder
    static class TestDecimal {
        private @Decimal BigDecimal price1;
        private @Decimal BigDecimal price2;
        private @Decimal(trimZero = false) BigDecimal price3;
        private @Decimal BigDecimal price4;
    }

    @SneakyThrows
    @Test
    void test() {
        final TestDecimal testDecimal = TestDecimal.builder().price1(new BigDecimal("12.340")).build();
        final JsonContent<TestDecimal> jsonContent = jacksonTester.write(testDecimal);
        assertThat(jsonContent).extractingJsonPathNumberValue("@.price1").isEqualTo(12.34);
    }

    @SneakyThrows
    @Test
    void test2() {
        final TestDecimal testDecimal = TestDecimal.builder().price2(new BigDecimal("12.345")).build();
        final JsonContent<TestDecimal> jsonContent = jacksonTester.write(testDecimal);
        assertThat(jsonContent).extractingJsonPathNumberValue("@.price2").isEqualTo(12.35);
    }

    @SneakyThrows
    @Test
    void test3() {
        final TestDecimal testDecimal = TestDecimal.builder().price3(new BigDecimal("12.30")).build();
        final JsonContent<TestDecimal> jsonContent = jacksonTester.write(testDecimal);
        assertThat(jsonContent).extractingJsonPathNumberValue("@.price3").isEqualTo(12.30);
    }

    @SneakyThrows
    @Test
    void test4() {
        final TestDecimal testDecimal = TestDecimal.builder().price4(new BigDecimal("12.30")).build();
        final JsonContent<TestDecimal> jsonContent = jacksonTester.write(testDecimal);
        assertThat(jsonContent).extractingJsonPathNumberValue("@.price4").isEqualTo(12.3);
    }
}