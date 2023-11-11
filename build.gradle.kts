plugins {
    kotlin("jvm")
    id("fabric-loom")
    id("me.modmuss50.mod-publish-plugin") version "0.4.2"
    `maven-publish`
    java
}

group = property("maven_group")!!
version = "${property("mod_version")}+mc${property("minecraft_version")}"

repositories {
    // maven("https://jitpack.io")
}

dependencies {
    minecraft("com.mojang:minecraft:${property("minecraft_version")}")
    mappings("net.fabricmc:yarn:${property("yarn_mappings")}:v2")
    modImplementation("net.fabricmc:fabric-loader:${property("loader_version")}")

    modImplementation("net.fabricmc:fabric-language-kotlin:${property("fabric_kotlin_version")}")
    modImplementation("net.fabricmc.fabric-api:fabric-api:${property("fabric_api_version")}")

    // include("com.github.Draylar.omega-config:omega-config-base:${property("omega_config_version")}")
    // modImplementation("com.github.Draylar.omega-config:omega-config-base:${property("omega_config_version")}")
}

tasks {
    processResources {
        inputs.property("version", project.version)
        filesMatching("fabric.mod.json") {
            expand(mutableMapOf("version" to project.version))
        }
    }

    jar {
        from("LICENSE")
    }

    publishMods {
        changelog = file("CHANGELOG.md").readText(Charsets.UTF_8)
        type = STABLE
        file.set(remapJar.get().archiveFile)
        version.set("${project.version}")
        displayName.set("[Fabric ${property("minecraft_version")}] ${property("mod_version")}")
        modLoaders.addAll("fabric", "quilt")

        modrinth {
            accessToken = providers.environmentVariable("MODRINTH_API_KEY")
            projectId = "PVN8P7kZ"
            minecraftVersions.add("${property("minecraft_version")}")
        }

        curseforge {
            accessToken = providers.environmentVariable("CURSEFORGE_API_KEY")
            projectId = "514716"
            minecraftVersions.add("${property("minecraft_version")}")
        }
    }

    publishing {
        publications {
            create<MavenPublication>("mavenJava") {
                artifact(remapJar) {
                    builtBy(remapJar)
                }
                artifact(kotlinSourcesJar) {
                    builtBy(remapSourcesJar)
                }
            }
        }

        // select the repositories you want to publish to
        repositories {
            // uncomment to publish to the local maven
            // mavenLocal()
        }
    }

    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }
}

java {
    // Loom will automatically attach sourcesJar to a RemapSourcesJar task and to the "build" task
    // if it is present.
    // If you remove this line, sources will not be generated.
    withSourcesJar()
}
