package com.jiuhaox.ddd.domain.valueobject;

import com.jiuhaox.ddd.domain.concepts.ValueObject;

public record GeoPoint(double longitude, double latitude) implements ValueObject {
}
