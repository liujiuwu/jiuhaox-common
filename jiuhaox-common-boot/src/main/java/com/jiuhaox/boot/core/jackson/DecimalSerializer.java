package com.jiuhaox.boot.core.jackson;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Objects;

@Slf4j
@JsonComponent
public class DecimalSerializer extends JsonSerializer<BigDecimal> implements ContextualSerializer {
    private String decimalFormat;
    private RoundingMode roundingMode;
    private int scale;
    private boolean trimZero;

    public DecimalSerializer() {
        this.decimalFormat = "";
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 2;
        this.trimZero = true;
    }

    public DecimalSerializer(String decimalFormat, RoundingMode roundingMode, int scale, boolean trimZero) {
        this.decimalFormat = decimalFormat;
        this.roundingMode = roundingMode;
        this.scale = scale;
        this.trimZero = trimZero;
    }

    @Override
    public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value != null) {
            if (StrUtil.isNotBlank(decimalFormat)) {
                gen.writeNumber(new BigDecimal(new DecimalFormat(decimalFormat).format(value)));
                return;
            }

            if (this.trimZero) {
                gen.writeNumber(new BigDecimal(NumberUtil.toStr(NumberUtil.round(value, this.scale, this.roundingMode))));
                return;
            }

            gen.writeNumber(NumberUtil.round(value, this.scale, this.roundingMode));
        }
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) throws JsonMappingException {
        if (property != null) {
            if (Objects.equals(property.getType().getRawClass(), BigDecimal.class)) {
                Decimal format = property.getAnnotation(Decimal.class);
                if (format == null) {
                    format = property.getContextAnnotation(Decimal.class);
                }

                if (format != null) {
                    return new DecimalSerializer(format.decimalFormat(), format.roundingMode(), format.scale(), format.trimZero());
                }
            }
            return prov.findValueSerializer(property.getType(), property);
        }
        return prov.findNullValueSerializer(null);
    }

}