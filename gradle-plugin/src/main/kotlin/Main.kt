package com.h0tk3y.kotlin.mpp.insight

import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import java.io.File
import java.io.StringWriter

fun main() {
    val htmlFile = File("out.html")

    val page = StringWriter().appendHTML().run {
        head {
            link(rel = "stylesheet", href = "styles.css")
        }
        body {
            div {
                +"Source sets report"

                for (x in listOf("a", "b", "c")) {
                    div(classes = "sourcesetblock") {
                        div(classes = "sourcesettitle") {
                            +"source set "
                            b(classes = "sourcesetname") { +(x.repeat(3) + (x[0] + 1)) }
                        }
                        div(classes = "sourcesetbody") {
                            span { +x.repeat(10) }
                        }
                    }
                }
            }
        }
    }

    htmlFile.writeText(page.toString())

    println("See the report at: ${htmlFile.toURI()}")
}