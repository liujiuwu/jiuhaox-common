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
    compileOnly(project(":jiuhaox-common-ddd"))
    compileOnly(project(":jiuhaox-common-boot"))
    implementation("cn.hutool:hutool-all:${property("hutoolVersion")}")

    compileOnly("org.springframework.boot:spring-boot-starter-web:${property("springBootVersion")}")

    compileOnly("org.projectlombok:lombok:${property("lombokVersion")}")
    annotationProcessor("org.projectlombok:lombok:${property("lombokVersion")}")

    implementation("com.tngtech.archunit:archunit:${property("archunitVersion")}")
    implementation("com.tngtech.archunit:archunit-junit5:${property("archunitVersion")}")

    testCompileOnly("org.projectlombok:lombok:${property("lombokVersion")}")
    testAnnotationProcessor("org.projectlombok:lombok:${property("lombokVersion")}")
    testImplementation("org.springframework.boot:spring-boot-starter-test:${property("springBootVersion")}")
    testImplementation("com.tngtech.archunit:archunit:${property("archunitVersion")}")
    testImplementation("com.tngtech.archunit:archunit-junit5:${property("archunitVersion")}")
}