package com.jiuhaox.boot.application.model.query;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class KeywordQuery extends PageQuery {
    private String keyword;
}
