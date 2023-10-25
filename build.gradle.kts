import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("fabric-loom") version "1.3.8"
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.serialization") version "1.9.0"
    id("org.teamvoided.iridium") version "3.0.2"
}

val modid = "shippost"


group = project.properties["maven_group"]!!
version = project.properties["mod_version"]!!
base.archivesName.set(project.properties["archives_base_name"] as String)
description = "Just a normal mod dont worry!"

repositories {
    mavenCentral()
    maven {
        name = "brokenfuseReleases"
        url = uri("https://maven.teamvoided.org/releases")
    }
}

modSettings {
    modId(modid)
    modName("The Shippost Mod")

    entrypoint("main", "org.teamvoided.shippost.TheShippostMod::mainInit")
    entrypoint("client", "org.teamvoided.shippost.TheShippostMod::clientInit")
    entrypoint("fabric-datagen", "org.teamvoided.shippost.TheShippostData")
}

dependencies {
    modImplementation("org.teamvoided:voidlib-core:1.5.8+1.20.1")
}


loom {
    runs {
        create("data") {
            client()
            configName = "Data Gen"
            ideConfigGenerated(true)
            vmArg("-Dfabric-api.datagen")
            vmArg("-Dfabric-api.datagen.output-dir=${file("src/main/generated")}")
            vmArg("-Dfabric-api.datagen.modid=${modid}")
            runDir("build/datagen")
        }

        create("TestWorld") {
            client()
            configName = "Run Test World"
            ideConfigGenerated(true)
            runDir("run")
            programArg("--quickPlaySingleplayer \"test\"")
        }

    }
}
tasks {
    val targetJavaVersion = 17
    withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.release.set(targetJavaVersion)
    }

    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = targetJavaVersion.toString()
    }

    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of(JavaVersion.toVersion(targetJavaVersion).toString()))
        withSourcesJar()
    }
}
sourceSets["main"].resources.srcDir("src/main/generated")