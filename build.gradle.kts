plugins {
    id("java")
    id("com.gradleup.shadow") version "8.3.7"
}

group = "me.while1cry"
version = "dev-0.1"
description = "A simple permission management plugin for JKook"
java.targetCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
    maven("https://www.jitpack.io")
    maven("https://repo.panda-lang.org/releases")
}

dependencies {
    compileOnly("com.github.SNWCreations:KookBC:0.32.2")
    implementation("com.zaxxer:HikariCP:6.3.0") {
        exclude("org.slf4j", "slf4j-api")
    }
    implementation("com.fasterxml.jackson.core:jackson-databind:2.19.1")
}

tasks.build {
    dependsOn("shadowJar")
}

tasks.shadowJar {
    archiveFileName.set("LitePerms.jar")

    relocate("com.fasterxml", "me.while1cry.liteperms.lib.com.fasterxml")
    relocate("com.zaxxer", "me.while1cry.liteperms.lib.com.zaxxer")

    mergeServiceFiles()
}

tasks.compileJava {
    options.encoding = "UTF-8"
}
