package com.h0tk3y.gradle.mppInsight

import kotlinx.css.*
import kotlinx.css.properties.border

private fun CSSBuilder.forClass(name: String, ruleSet: RuleSet) = ".$name".invoke(ruleSet)
private fun CSSBuilder.forId(id: String, ruleSet: RuleSet) = "#$id".invoke(ruleSet)

const val headerId = "header-div"

const val leftPaneClass = "left-pane"
const val rightPaneClass = "right-pane"

const val valignCenter = "valign-center"

const val blockClass = "source-set-block"
const val blockTitleClass = "${blockClass}__title"
const val blockTitleNameClass = "${blockTitleClass}__name"
const val blockBodyClass = "${blockClass}__body"
const val filePathClass = "file-path"

val blockBorderColor = rgb(200, 200, 200)

const val gridContainerClass = "grid-container"
const val gridLeftPaneClass = "grid-left-pane"
const val gridLeftPaneHeaderClass = "grid-left-pane-header"
const val gridLeftPaneContentClass = "grid-left-pane-content"
const val gridHeadPaneClass = "grid-head-pane"
const val gridRightPaneClass = "grid-right-pane"

val gridLayoutCss = run {
    val galp = gridLeftPaneClass
    val garp = gridRightPaneClass
    val gahp = gridHeadPaneClass
    val galh = gridLeftPaneHeaderClass
    val galc = gridLeftPaneContentClass
    """
    .$gridContainerClass {
      display: grid;
      height: 100%;
      grid-template-columns: 2fr 1fr;
      grid-template-rows: 1fr 14fr;
      grid-template-areas: "$gahp $gahp" 
                           "$galp $garp";
    }
    
    .$gridLeftPaneClass {
      display: grid;
      grid-template-columns: 1fr;
      grid-template-rows: 20px auto;
      grid-template-areas: "$galh" "$galc";
      grid-area: $galp;
    }
    
    .$gridLeftPaneHeaderClass { grid-area: $galh; }
    .$gridLeftPaneContentClass { grid-area: $galc; }
    
    .$gridHeadPaneClass { grid-area: $gahp; }
    """.trimIndent()
}

fun generateStyleSheet() = CSSBuilder().apply {

    body {
        fontFamily = "Verdana,sans-serif"
    }

    forClass(valignCenter) {
        verticalAlign = VerticalAlign.middle
    }

    forId(headerId) {
        backgroundColor = Color("#95F6D6")
        display = Display.block
        paddingTop = 5.px
        paddingLeft = 20.px
        paddingBottom = 10.px
    }

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