package com.jiuhaox.boot.application.model.query;

import com.jiuhaox.ddd.domain.concepts.Query;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class PageQuery implements Query {
    public static final int MAX_SIZE = 200;
    public static final int DEFAULT_SIZE = 10;

    private int page;

    private int size;

    public int getPage() {
        if (this.page < 0) {
            this.page = 0;
        }
        return this.page;
    }

    public int getSize() {
        if (this.size <= 0 || this.size > MAX_SIZE) {
            this.size = DEFAULT_SIZE;
        }
        return this.size;
    }
}
