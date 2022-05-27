package com.jiuhaox.test;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

public class LayeredArchRules {
    @ArchTest
    public static final ArchRule checkLayer = layeredArchitecture()
            .layer("AdapterLayer").definedBy("..adapter..")
            .layer("ApplicationLayer").definedBy("..application..")
            .layer("DomainLayer").definedBy("..domain..")

            .whereLayer("AdapterLayer").mayNotBeAccessedByAnyLayer()
            .whereLayer("ApplicationLayer").mayOnlyBeAccessedByLayers("AdapterLayer")
            .whereLayer("DomainLayer").mayOnlyBeAccessedByLayers("AdapterLayer", "ApplicationLayer");

}
