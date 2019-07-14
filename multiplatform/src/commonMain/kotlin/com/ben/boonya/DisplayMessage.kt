package com.ben.boonya

expect fun platformName(): String

fun createApplicationScreenMessage(): String {
    return "Multiplatform: Hello from ${platformName()}"
}