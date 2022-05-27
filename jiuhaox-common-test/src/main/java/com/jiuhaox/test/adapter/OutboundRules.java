package com.jiuhaox.test.adapter;

import com.jiuhaox.boot.adapter.outbound.concepts.DomainConverter;
import com.jiuhaox.boot.adapter.outbound.concepts.PersistenceObject;
import com.jiuhaox.ddd.domain.concepts.Repository;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class OutboundRules {
    @ArchTest
    public static final ArchRule base_rule = classes()
            .that().resideInAPackage("..repository..")
            .and().implement(Repository.class)
            .should().haveSimpleNameEndingWith("RepositoryImpl")
            .andShould().beAssignableTo(Repository.class)
            .allowEmptyShould(true);

    @ArchTest
    public static final ArchRule base_po_rule = classes()
            .that().resideInAPackage("..repository..")
            .and().implement(PersistenceObject.class)
            .should().haveSimpleNameEndingWith("PO")
            .andShould().resideInAnyPackage("..repository.model")
            .allowEmptyShould(true);

    @ArchTest
    public static final ArchRule base_converter_rule_name_and_implement_DomainConverter = classes()
            .that().resideInAPackage("..repository.converter")
            .should().haveSimpleNameContaining("Converter")
            .andShould().beAssignableTo(DomainConverter.class)
            .allowEmptyShould(true);

    @ArchTest
    public static final ArchRule base_converter_rule_package = classes()
            .that().resideInAPackage("..repository..")
            .and().haveSimpleNameContaining("Converter")
            .should().beAssignableTo(DomainConverter.class)
            .andShould().resideInAPackage("..repository.converter")
            .allowEmptyShould(true);
}
