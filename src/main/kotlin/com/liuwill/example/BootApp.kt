package com.liuwill.example

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun Application.module() {
  install(DefaultHeaders)
  install(CallLogging)
  install(Routing) {
    get("/") {
      call.respondText("Hello World!", ContentType.Text.Html)
    }
    get("/snippets") {
      call.respondText("OK")
    }
  }
}

fun main() {
  embeddedServer(Netty, 8080, watchPaths = listOf("BootAppKt"), module = Application::module).start()
}
