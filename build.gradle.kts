plugins {
    java
    jacoco
    `maven-publish`
}

group = "com.jiuhaox"
version = "0.0.1-SNAPSHOT"

val springBootVersion = "3.0.0-M2"
val lombokVersion = "1.18.24"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    withSourcesJar()
}

tasks.compileJava {
    options.compilerArgs.add("-Xlint:unchecked")
    options.compilerArgs.add("-Xlint:deprecation")
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenLocal()
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
}

extra["archunitVersion"] = "0.23.1"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:$springBootVersion") {
        exclude("org.springframework.boot", "spring-boot-starter-tomcat")
    }
    implementation("org.springframework.boot:spring-boot-autoconfigure:$springBootVersion")
    implementation("org.springframework.boot:spring-boot-starter-validation:$springBootVersion")
    implementation("cn.hutool:hutool-all:5.8.1")

    compileOnly("org.projectlombok:lombok:$lombokVersion")

    annotationProcessor("org.projectlombok:lombok:$lombokVersion")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:$springBootVersion")

    testImplementation("org.projectlombok:lombok:$lombokVersion")
    testAnnotationProcessor("org.projectlombok:lombok:$lombokVersion")
    testImplementation("org.springframework.boot:spring-boot-starter-test:$springBootVersion")
    testImplementation("com.tngtech.archunit:archunit:${property("archunitVersion")}")
    testImplementation("com.tngtech.archunit:archunit-junit5:${property("archunitVersion")}")
}

tasks.withType<Test> {
    useJUnitPlatform()
}


tasks {
    test {
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
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}