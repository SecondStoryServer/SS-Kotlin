package me.syari.ss.kotlin

import org.bukkit.plugin.java.JavaPlugin

class Main: JavaPlugin() {
    override fun onEnable() {
        logger.info("""
            -----[ SS-Kotlin ]-----
            * kotlin-stdlib-jdk8
            * kotlin-reflect
            -----------------------
        """.trimIndent())
    }
}