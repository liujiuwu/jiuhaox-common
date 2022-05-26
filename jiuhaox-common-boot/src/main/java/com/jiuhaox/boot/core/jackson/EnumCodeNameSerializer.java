package com.jiuhaox.boot.core.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.jiuhaox.boot.core.enums.EnumCodeName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@JsonComponent
public class EnumCodeNameSerializer extends JsonSerializer<EnumCodeName> {
    private static final String KEY_CODE = "code";

    private static final String KEY_NAME = "name";

    @Override
    public void serialize(final EnumCodeName value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {
        Map<String, String> data = new LinkedHashMap<>(2);
        data.put(KEY_CODE, value.name());
        data.put(KEY_NAME, value.getName());
        gen.writeObject(data);
    }
}
