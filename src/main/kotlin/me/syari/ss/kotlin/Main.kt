package me.syari.ss.kotlin

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    private val kotlinDescription = """
            §6--------[ §a§lSS-Kotlin §6]--------
            §6 * §dkotlin-jvm §7- §dversion 1.3.72
            §6 * §dkotlin-stdlib-jdk8
            §6-----------------------------
        """.trimIndent().lines().toTypedArray()

    override fun onEnable() {
        server.consoleSender.sendMessage(kotlinDescription)
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        return if (sender.isOp) {
            sender.sendMessage(kotlinDescription)
            true
        } else {
            false
        }
    }
}