package com.jiuhaox.test.adapter;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class InboundRules {
    @ArchTest
    public static final ArchRule base_api_rule = classes()
            .that().resideInAPackage("..rest.api..")
            .should().haveSimpleNameEndingWith("Api")
            .andShould().beAnnotatedWith(RestController.class)
            .andShould().beAnnotatedWith(RequestMapping.class)
            .allowEmptyShould(true);

    @ArchTest
    public static final ArchRule base_rpc_rule = classes()
            .that().resideInAPackage("..rest.rpc..")
            .should().haveSimpleNameEndingWith("Rpc")
            .andShould().beAnnotatedWith(RestController.class)
            .andShould().beAnnotatedWith(RequestMapping.class)
            .allowEmptyShould(true);
}
