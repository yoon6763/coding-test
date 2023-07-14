plugins {
    kotlin("jvm") version "1.8.20"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.seleniumhq.selenium:selenium:2.0rc2")
    implementation("org.seleniumhq.selenium:selenium:2.0rc2")
    implementation("org.seleniumhq.selenium:selenium:2.0rc2")
    implementation("org.seleniumhq.selenium:selenium:2.0rc2")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("MainKt")
}