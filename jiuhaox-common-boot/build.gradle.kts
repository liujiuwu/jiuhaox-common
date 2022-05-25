plugins {
    `java-library`
    `maven-publish`
    jacoco
    id("org.springframework.boot") version "3.0.0-M2" apply false
}

group = "com.jiuhaox"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    withSourcesJar()
}

tasks {
    compileJava {
        options.compilerArgs.addAll(
            listOf(
                "-Xlint:unchecked",
                "-Xlint:deprecation",
            )
        )
    }

    test {
        useJUnitPlatform()
        finalizedBy(jacocoTestReport)
    }

    jacocoTestReport {
        dependsOn(test)
        classDirectories.setFrom(
            sourceSets.main.get().output.asFileTree.matching {
                exclude(
                    "**/enums/**",
                    "**/consts/**",
                    "**/errorcode/**",
                    "**/exception/**",
                )
            }
        )
    }

    check {
        dependsOn(
            listOf(
                "jacocoTestReport",
                "jacocoTestCoverageVerification",
            )
        )
    }
}

configure<PublishingExtension>() {
    publications {
        create<MavenPublication>("maven") {
            from(components.getByName("java"))
        }
    }
}

dependencies {
    implementation(platform(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES))

    api(project(":jiuhaox-common-ddd"))

    implementation("org.springframework.boot:spring-boot-starter-web") {
        exclude("org.springframework.boot", "spring-boot-starter-tomcat")
    }
    implementation("org.springframework.boot:spring-boot-autoconfigure")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    implementation("cn.hutool:hutool-all:${property("hutoolVersion")}")
    implementation("com.alibaba:transmittable-thread-local:2.12.6")

    compileOnly("org.projectlombok:lombok:${property("lombokVersion")}")
    annotationProcessor("org.projectlombok:lombok:${property("lombokVersion")}")

    testCompileOnly("org.projectlombok:lombok:${property("lombokVersion")}")
    testAnnotationProcessor("org.projectlombok:lombok:${property("lombokVersion")}")
    testImplementation("com.tngtech.archunit:archunit:${property("archunitVersion")}")
    testImplementation("com.tngtech.archunit:archunit-junit5:${property("archunitVersion")}")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}