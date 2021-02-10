plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.3.70"

    // Apply the java-library plugin for API and implementation separation.
    `java-library`
}

repositories {
    // Use jcenter for resolving dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
}

dependencies {
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("org.jsoup:jsoup:1.13.1")

    implementation("org.springframework.boot:spring-boot-starter:2.4.1")

    implementation("com.github.seratch:kotliquery:1.3.1")
    implementation("org.liquibase:liquibase-core:4.2.2")
    implementation("org.postgresql:postgresql:42.2.5")


    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    testImplementation("com.github.kristofa:mock-http-server:4.1")

}
