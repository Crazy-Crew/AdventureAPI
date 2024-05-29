plugins {
    id("io.papermc.paperweight.userdev") version "1.7.1"

    id("xyz.jpenilla.run-paper") version "2.3.0"

    `java-library`
}

repositories {

}

dependencies {
    paperweight.paperDevBundle("1.20.6-R0.1-SNAPSHOT")
}

tasks {
    runServer {
        minecraftVersion("1.20.6")
    }
}