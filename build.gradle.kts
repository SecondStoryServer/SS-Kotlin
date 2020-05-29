import org.apache.tools.ant.filters.ReplaceTokens

plugins {
    kotlin("jvm") version "1.3.72"
}

group = "me.syari.ss.kotlin"
version = "1.3"

repositories {
    mavenCentral()
    maven {
        url = uri("https://papermc.io/repo/repository/maven-public/")
    }
}

val embed: Configuration by configurations.creating

configurations {
    api.get().extendsFrom(embed)
}

dependencies {
    implementation("com.destroystokyo.paper:paper-api:1.15.2-R0.1-SNAPSHOT")
    embed("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    processResources {
        from(sourceSets.main.get().resources.srcDirs) {
            val replaceMap = mapOf("version" to version)
            filter<ReplaceTokens>("tokens" to replaceMap)
        }
    }
}

val jar by tasks.getting(Jar::class) {
    from(configurations.getByName("embed").map {
        if (it.isDirectory) it else zipTree(it)
    })
}
