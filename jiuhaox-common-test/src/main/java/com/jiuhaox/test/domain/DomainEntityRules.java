package com.jiuhaox.test.domain;

import com.jiuhaox.ddd.domain.concepts.AggregateRoot;
import com.jiuhaox.ddd.domain.concepts.Entity;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class DomainEntityRules {
    @ArchTest
    public static final ArchRule base_rule = classes()
            .that().resideInAnyPackage("..domain..model..")
            .and().haveSimpleNameNotContaining("Builder")
            .should().implement(Entity.class)
            .orShould().implement(AggregateRoot.class)
            .allowEmptyShould(true);

    @ArchTest
    public static final ArchRule in_package_rule = classes()
            .that().implement(Entity.class).or().implement(AggregateRoot.class)
            .and().haveSimpleNameNotContaining("Builder")
            .should().resideInAnyPackage("..domain..model..")
            .allowEmptyShould(true);
}
