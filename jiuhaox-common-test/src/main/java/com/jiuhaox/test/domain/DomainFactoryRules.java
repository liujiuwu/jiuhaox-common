package com.jiuhaox.test.domain;

import com.jiuhaox.ddd.domain.concepts.DomainFactory;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class DomainFactoryRules {
    @ArchTest
    public static final ArchRule base_rule = classes()
            .that().resideInAPackage("..domain..factory..")
            .should().haveSimpleNameEndingWith("DomainFactory")
            .andShould().implement(DomainFactory.class)
            .allowEmptyShould(true);

    @ArchTest
    public static final ArchRule in_package_rule = classes()
            .that().haveSimpleNameEndingWith("DomainFactory")
            .and().implement(DomainFactory.class)
            .should().resideInAPackage("..domain..factory..")
            .allowEmptyShould(true);
}
