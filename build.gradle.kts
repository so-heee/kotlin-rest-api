import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.openapi.generator") version "4.3.1"
    kotlin("jvm") version "1.5.21"
    kotlin("plugin.spring") version "1.5.21"
    kotlin("plugin.jpa") version "1.5.21"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springdoc:springdoc-openapi-ui:1.4.8")
    implementation("io.swagger:swagger-annotations:1.5.21")
    implementation("org.openapitools:jackson-databind-nullable:0.1.0")
    runtimeOnly("mysql:mysql-connector-java")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

val generatedSourcesDir = "$buildDir/generated/openapi"

openApiGenerate {
    generatorName.set("spring")
    inputSpec.set("${rootProject.projectDir}/specs/openapi.yml")
    outputDir.set(generatedSourcesDir)
    apiPackage.set("com.example.api.openapi.api")
    modelPackage.set("com.example.api.openapi.model")
    modelNameSuffix.set("Dto")

    configOptions.apply {
        put("serializableModel", "true")
        //        put("serializationLibrary", "gson")
        put("interfaceOnly", "true")
        put("skipDefaultInterface", "true")
    }
}

sourceSets {
    getByName("main") {
        java {
            srcDir("$generatedSourcesDir/src/main/java")
        }
    }
}

tasks.withType<KotlinCompile> {
    dependsOn(tasks.openApiGenerate)
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
