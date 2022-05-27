package com.jiuhaox.test.domain;

import com.jiuhaox.ddd.domain.concepts.DomainService;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class DomainServiceRules {
    @ArchTest
    public static final ArchRule base_rule = classes()
            .that().resideInAPackage("..domain..service..")
            .should().haveSimpleNameEndingWith("DomainService")
            .andShould().implement(DomainService.class)
            .allowEmptyShould(true);


    @ArchTest
    public static final ArchRule in_package_rule = classes()
            .that().haveSimpleNameEndingWith("DomainService")
            .and().implement(DomainService.class)
            .should().resideInAPackage("..domain..service..")
            .allowEmptyShould(true);
}
