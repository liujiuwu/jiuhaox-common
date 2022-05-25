package com.jiuhaox.boot.model.query;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class KeywordQuery extends PageQuery {
    private String keyword;
}
