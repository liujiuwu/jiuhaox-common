plugins {
    `java-platform`
    `maven-publish`
}

group = "com.jiuhaox"
version = "0.0.1-SNAPSHOT"

javaPlatform {
    allowDependencies()
}

configure<PublishingExtension>() {
    publications {
        create<MavenPublication>("jiuhaoxPlatform") {
            from(components.getByName("javaPlatform"))
        }
    }
}


val archunitVersion = "0.23.1"
dependencies {
    constraints {
        api(project(":jiuhaox-common-ddd"))
        api(project(":jiuhaox-common-boot"))

        api("cn.hutool:hutool-all:5.8.1")
        api("com.alibaba:transmittable-thread-local:2.12.6")

        api("com.tngtech.archunit:archunit:$archunitVersion")
        api("com.tngtech.archunit:archunit-junit5:$archunitVersion")
    }
}