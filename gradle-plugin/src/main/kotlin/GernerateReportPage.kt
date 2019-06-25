package com.h0tk3y.kotlin.mpp.insight

import com.h0tk3y.kotlin.mpp.insight.model.MppModel
import kotlinx.html.stream.appendHTML
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.StringWriter

@UnstableDefault
open class GernerateReportPage : DefaultTask() {
    @get:Internal
    internal val model by lazy { ModelBuilder().buildMppModel(project) }

    @get:Input
    internal val serializedModel
        get() = Json.stringify(MppModel.serializer(), model)

    @OutputDirectory
    val reportOutputDir = project.buildDir.resolve("mppInsight/sourceSets")

    @TaskAction
    fun generate() {
        val htmlFile = reportOutputDir.resolve("index.html")
        val cssFile = reportOutputDir.resolve("styles.css")
        val jsFile = reportOutputDir.resolve("representation.js")

        val page = StringWriter().appendHTML().run {
            with(ModelHtmlRenderer) {
                generateReportPage(project.projectDir, cssFile.relativeTo(htmlFile.parentFile), jsFile.relativeTo(htmlFile.parentFile), model)
            }
            this.finalize()
        }

        val jsResourceName = "kotlin-mpp-insight-representation.js"
        jsFile.writeBytes(javaClass.getResourceAsStream("/$jsResourceName").readBytes())

        cssFile.writeText(SourceSetStyles.generateCss().toString())
        htmlFile.writeText(page.toString())

        println("See the report at: ${htmlFile.toURI()}")
    }
}