package com.h0tk3y.kotlin.mpp.insight

import com.h0tk3y.gradle.mppInsight.*
import com.h0tk3y.kotlin.mpp.insight.model.MppModel
import kotlinx.html.*
import kotlinx.html.dom.append
import kotlinx.html.js.div
import kotlinx.html.js.onClickFunction
import kotlinx.html.js.style
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLInputElement
import kotlin.browser.document
import kotlin.browser.window

@UnstableDefault
fun main() {
    window.onload = {
        val leftPaneContentDivId = "container-div"
        val detailsDivId = "details-div"
        val onlyPublishedInputId = "only-published-input"

        val model: MppModel = extractMppModelFromDocument()

        document.body!!.append {
            style {
                unsafe { raw(generateStyleSheet().toString() + "\n" + gridLayoutCss) }
            }

            div {
                classes = setOf(gridContainerClass)

                div {
                    id = headerId
                    classes = setOf(gridHeadPaneClass)
                    h3 { +"Kotlin MPP Insight" }
                }

                div {
                    classes = setOf(gridLeftPaneClass)

                    label {
                        classes = setOf(gridLeftPaneHeaderClass)
                        attributes["style"] = "display: inline-block"
                        input(InputType.checkBox) {
                            id = onlyPublishedInputId
                            classes = setOf(valignCenter)
                        }
                        span { +"Only published"; classes = setOf(valignCenter) }
                    }

                    div {
                        classes = setOf(gridLeftPaneContentClass)
                        id = leftPaneContentDivId
                    }
                }
                div {
                    classes = setOf(gridRightPaneClass)
                    id = detailsDivId
                }
            }
        }

        val container = document.querySelector("#$leftPaneContentDivId") as HTMLElement
        val publishedOnlyCheckBox = document.querySelector("#$onlyPublishedInputId") as HTMLInputElement
        publishedOnlyCheckBox.oninput = { event ->
            createSourceSetsNetwork(
                container,
                model,
                publishedOnlyCheckBox.checked,
                DetailLevel.SOURCE_SETS_WITH_COMPILATIONS_AND_VARIANTS
            )
        }

        println(Json(JsonConfiguration(prettyPrint = true)).stringify(MppModel.serializer(), model))
        createSourceSetsNetwork(
            container,
            model,
            publishedOnlyCheckBox.checked,
            DetailLevel.SOURCE_SETS_WITH_COMPILATIONS_AND_VARIANTS
        )

        Unit
    }
}