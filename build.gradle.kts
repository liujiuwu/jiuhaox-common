subprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        maven { url = uri("https://repo.spring.io/milestone") }
    }

    extra["springBootVersion"] = "3.0.0-M2"
    extra["lombokVersion"] = "1.18.24"
    extra["archunitVersion"] = "0.23.1"
    extra["hutoolVersion"] = "5.8.1"
}