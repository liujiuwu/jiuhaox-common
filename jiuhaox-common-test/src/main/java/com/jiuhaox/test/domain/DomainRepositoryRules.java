package com.jiuhaox.test.domain;

import com.jiuhaox.ddd.domain.concepts.Repository;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class DomainRepositoryRules {
    @ArchTest
    public static final ArchRule base_rule = classes()
            .that().resideInAPackage("..domain..repository..")
            .should().haveSimpleNameEndingWith("Repository")
            .andShould().beInterfaces()
            .andShould().beAssignableTo(Repository.class)
            .allowEmptyShould(true);

    @ArchTest
    public static final ArchRule in_package_rule = classes()
            .that().haveSimpleNameEndingWith("Repository")
            .and().areInterfaces()
            .and().areAssignableTo(Repository.class)
            .should().resideInAPackage("..domain..repository..")
            .allowEmptyShould(true);
}
