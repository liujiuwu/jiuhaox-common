package com.jiuhaox.test.domain;

import com.jiuhaox.ddd.domain.concepts.ValueObject;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ValueObjectRules {
    @ArchTest
    public static final ArchRule base_rule = classes()
            .that().resideInAPackage("..valueobject..")
            .should().implement(ValueObject.class)
            .allowEmptyShould(true);

    @ArchTest
    public static final ArchRule in_package_rule = classes()
            .that().implement(ValueObject.class)
            .should().resideInAPackage("..valueobject..")
            .allowEmptyShould(true);
}
