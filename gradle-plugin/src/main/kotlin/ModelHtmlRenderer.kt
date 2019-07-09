package com.h0tk3y.kotlin.mpp.insight

import com.h0tk3y.kotlin.mpp.insight.model.MppModel
import com.h0tk3y.kotlin.mpp.insight.model.SourceSetModel
import com.sun.xml.internal.ws.api.policy.SourceModel
import kotlinx.css.*
import kotlinx.css.properties.border
import kotlinx.html.*
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import java.io.File

@UnstableDefault
object ModelHtmlRenderer {
    fun TagConsumer<*>.generateReportPage(
        projectRoot: File,
        stylesRelativeFile: File,
        jsRelativeFile: File,
        model: MppModel
    ) {
        head {
            link(rel = "stylesheet", href = stylesRelativeFile.path)
        }
        body {
            script(type = "text/javascript", src = jsRelativeFile.path) {  }

            div {
                div {
                    id = "data-project-model"
                    attributes["data-project-model"] =
                        Json(JsonConfiguration.Default).stringify(MppModel.serializer(), model)
                }
            }
        }
    }

    fun TagConsumer<*>.renderSourceSet(projectRoot: File, sourceSet: SourceSetModel) {
        div(classes = SourceSetStyles.blockClass) {
            div(classes = SourceSetStyles.blockTitleClass) {
                +"source set "
                val name = sourceSet.name
                b(classes = SourceSetStyles.blockTitleNameClass) { +name }
            }
            div(classes = SourceSetStyles.blockBodyClass) {
                p { +"Kotlin sources:" }
                ul {
                    sourceSet.kotlinSrcDirs.forEach {
                        li { pathText(it, projectRoot) }
                    }
                }
                p { +"Resources:" }
                ul {
                    sourceSet.resourcesSrcDirs.forEach {
                        li { pathText(it, projectRoot) }
                    }
                }
            }
        }
    }

    private fun FlowOrPhrasingContent.pathText(path: String, relativeTo: File? = null) =
        span(SourceSetStyles.filePathClass) {
            +File(path).let { if (relativeTo != null) it.relativeTo(relativeTo) else it }.path
        }
}

object SourceSetStyles {
    const val blockClass = "source-set-block"
    const val blockTitleClass = "${blockClass}__title"
    const val blockTitleNameClass = "${blockTitleClass}__name"
    const val blockBodyClass = "${blockClass}__body"
    const val filePathClass = "file-path"

    val blockBorderColor = rgb(200, 200, 200)

    fun generateCss() = CSSBuilder().apply {
        forClass(blockClass) {
            width = 40.pct
            padding(bottom = 10.px)
            margin(10.px)
            border(1.px, BorderStyle.solid, blockBorderColor)
        }

        forClass(blockTitleClass) {
            padding(10.px)
            minHeight = 15.px
            backgroundColor = blockBorderColor
        }

        forClass(blockTitleNameClass) {
            fontFamily = "monospace"
        }

        forClass(blockBodyClass) {
            padding(5.px, 10.px, 0.px, 10.px)
        }

        forClass(filePathClass) {
            fontFamily = "monospace"
            backgroundColor = rgb(230, 230, 230)
        }
    }
}

private fun CSSBuilder.forClass(name: String, ruleSet: RuleSet) = ".$name".invoke(ruleSet)