package com.jiuhaox.foundation.model;

import cn.hutool.core.lang.Assert;
import com.jiuhaox.foundation.exceptions.AppErrorCode;
import com.jiuhaox.foundation.model.resp.Resp;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.ContextConfiguration;

import static com.jiuhaox.foundation.enums.RespStatus.FAIL;
import static com.jiuhaox.foundation.enums.RespStatus.SUCC;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@JsonTest
@ContextConfiguration(classes = RespTest.class)
class RespTest {
    @Resource
    private JacksonTester<Resp> jacksonTester;

    @Test
    void should_succ_when_ifSucc_given_ok_no_data() {
        Resp<String> resp = Resp.ok();
        resp.ifSucc(Assert::isNull);
    }

    @Test
    void should_succ_when_ifSucc_given_ok() {
        Resp<String> resp = Resp.ok("succ");
        resp.ifSucc(data -> assertThat(data).isEqualTo(resp.data()));
    }

    @Test
    void should_succ_when_ifSuccOrElse_given_ok() {
        Resp<String> resp = Resp.ok("succ");
        resp.ifSuccOrElse(data -> assertThat(data).isEqualTo(resp.data()), Assert::isNull);
    }

    @Test
    void should_fail_when_ifSuccOrElse_given_fail() {
        Resp<String> resp = Resp.fail("error");
        resp.ifSuccOrElse(Assert::isNull, (code, message) -> assertThat(message).isEqualTo(resp.msg()));
        resp.ifSucc(Assert::isNull);
    }

    @SneakyThrows
    @Test
    void should_succ_when_json_write_given_ok() {
        final Resp<String> succResp = Resp.ok("data");
        final JsonContent<Resp> jsonContent = jacksonTester.write(succResp);
        assertThat(jsonContent).hasJsonPathStringValue("@.status");
        assertThat(jsonContent).extractingJsonPathStringValue("@.status").isEqualTo(SUCC.toString());

        assertThat(jsonContent).hasJsonPathStringValue("@.data");
        assertThat(jsonContent).extractingJsonPathStringValue("@.data").isEqualTo(succResp.data());
    }

    @SneakyThrows
    @Test
    void should_succ_when_json_write_given_fail_error_message() {
        final Resp<String> failResp = Resp.fail("error");
        final JsonContent<Resp> jsonContent = jacksonTester.write(failResp);
        assertThat(jsonContent).hasJsonPathStringValue("@.status");
        assertThat(jsonContent).extractingJsonPathStringValue("@.status").isEqualTo(FAIL.toString());

        assertThat(jsonContent).hasJsonPathStringValue("@.code");
        assertThat(jsonContent).extractingJsonPathStringValue("@.code").isEqualTo(failResp.code());

        assertThat(jsonContent).hasJsonPathStringValue("@.msg");
        assertThat(jsonContent).extractingJsonPathStringValue("@.msg").isEqualTo(failResp.msg());
    }

    @SneakyThrows
    @Test
    void should_succ_when_json_write_given_fail_error_code() {
        final AppErrorCode errUnknownError = AppErrorCode.ERR_UNKNOWN_ERROR;
        final Resp<String> failResp = Resp.fail(errUnknownError);
        final JsonContent<Resp> jsonContent = jacksonTester.write(failResp);
        assertThat(jsonContent).hasJsonPathStringValue("@.status");
        assertThat(jsonContent).extractingJsonPathStringValue("@.status").isEqualTo(FAIL.toString());

        assertThat(jsonContent).hasJsonPathStringValue("@.code");
        assertThat(jsonContent).extractingJsonPathStringValue("@.code").isEqualTo(errUnknownError.name());

        assertThat(jsonContent).hasJsonPathStringValue("@.msg");
        assertThat(jsonContent).extractingJsonPathStringValue("@.msg").isEqualTo(errUnknownError.getMsg());
    }

    @Test
    void should_true_when_isFail_given_fail() {
        Resp<String> resp = Resp.fail("error");
        assertThat(resp.isFail()).isTrue();
        assertThat(resp.isSucc()).isFalse();
    }

    @Test
    void should_true_when_isFail_given_ok() {
        Resp<String> resp = Resp.ok();
        assertThat(resp.isSucc()).isTrue();
        assertThat(resp.isFail()).isFalse();
    }
}