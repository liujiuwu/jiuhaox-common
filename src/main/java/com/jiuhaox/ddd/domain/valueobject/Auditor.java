package com.jiuhaox.ddd.domain.valueobject;

import com.jiuhaox.ddd.domain.concepts.ValueObject;

public record Auditor(String id, String name) implements ValueObject {
}
