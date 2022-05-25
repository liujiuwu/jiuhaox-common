plugins {
    `java-library`
    `maven-publish`
    jacoco
}

group = "com.jiuhaox"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    withSourcesJar()
}

configure<PublishingExtension>() {
    publications {
        create<MavenPublication>("maven") {
            from(components.getByName("java"))
        }
    }
}


dependencies {
    implementation("cn.hutool:hutool-all:${property("hutoolVersion")}")

    compileOnly("org.projectlombok:lombok:${property("lombokVersion")}")
    annotationProcessor("org.projectlombok:lombok:${property("lombokVersion")}")

    testCompileOnly("org.projectlombok:lombok:${property("lombokVersion")}")
    testAnnotationProcessor("org.projectlombok:lombok:${property("lombokVersion")}")
    testImplementation("org.springframework.boot:spring-boot-starter-test:${property("springBootVersion")}")
    testImplementation("com.tngtech.archunit:archunit:${property("archunitVersion")}")
    testImplementation("com.tngtech.archunit:archunit-junit5:${property("archunitVersion")}")
}