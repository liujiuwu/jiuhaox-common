pluginManagement {
    repositories {
        maven { url = uri("https://repo.spring.io/milestone") }
        gradlePluginPortal()
    }

    /*resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "org.springframework.boot") {
                useVersion("3.0.0-M2")
            }
        }
    }*/
}



rootProject.name = "jiuhaox-common"
include("jiuhaox-common-ddd")
include("jiuhaox-common-boot")
include("jiuhaox-common-test")
include("jiuhaox-common-dependencies")
