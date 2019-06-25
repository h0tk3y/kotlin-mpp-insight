@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")

@file:JsModule("vis")
@file:JsNonModule

package vis

import kotlin.js.*
import kotlin.js.Json
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*

//typealias MomentConstructor1 = (inp: MomentInput? /*= null*/, format: MomentFormatSpecification? /*= null*/, strict: Boolean? /*= null*/) -> Moment
//typealias MomentConstructor2 = (inp: MomentInput? /*= null*/, format: MomentFormatSpecification? /*= null*/, language: String? /*= null*/, strict: Boolean? /*= null*/) -> Moment
//typealias SubgroupType = dynamic
//typealias HeightWidthType = dynamic
// @JsModule("vis") @JsNonModule
external interface LegendPositionOptions {
    var visible: Boolean? get() = definedExternally; set(value) = definedExternally
    var position: dynamic /* 'top-right' | 'top-left' | 'bottom-right' | 'bottom-left' */ get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface LegendOptions {
    var enabled: Boolean? get() = definedExternally; set(value) = definedExternally
    var icons: Boolean? get() = definedExternally; set(value) = definedExternally
    var iconSize: Number? get() = definedExternally; set(value) = definedExternally
    var iconSpacing: Number? get() = definedExternally; set(value) = definedExternally
    var left: LegendPositionOptions? get() = definedExternally; set(value) = definedExternally
    var right: LegendPositionOptions? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface DataItem {
    var className: String? get() = definedExternally; set(value) = definedExternally
    var content: String
    var end: dynamic /* Date | Number | String */ get() = definedExternally; set(value) = definedExternally
    var group: Any? get() = definedExternally; set(value) = definedExternally
    var id: dynamic /* String | Number */ get() = definedExternally; set(value) = definedExternally
    var start: dynamic /* Date | Number | String */
    var style: String? get() = definedExternally; set(value) = definedExternally
    var subgroup: dynamic get() = definedExternally; set(value) = definedExternally
    var title: String? get() = definedExternally; set(value) = definedExternally
    var type: String? get() = definedExternally; set(value) = definedExternally
    var editable: Boolean? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface PointItem : DataItem {
    var x: String
    var y: Number
}

// @JsModule("vis") @JsNonModule
external interface DataGroup {
    var className: String? get() = definedExternally; set(value) = definedExternally
    var content: String
    var id: dynamic /* String | Number */
    var options: DataGroupOptions? get() = definedExternally; set(value) = definedExternally
    var style: String? get() = definedExternally; set(value) = definedExternally
    var subgroupOrder: dynamic /* String | () -> Unit */ get() = definedExternally; set(value) = definedExternally
    var title: String? get() = definedExternally; set(value) = definedExternally
    var nestedGroups: Array<Number>? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface DataGroupOptions {
    var drawPoints: dynamic /* Graph2dDrawPointsOption | () -> Unit */ get() = definedExternally; set(value) = definedExternally
    var excludeFromLegend: Boolean? get() = definedExternally; set(value) = definedExternally
    var interpolation: dynamic /* Boolean | InterpolationOptions */ get() = definedExternally; set(value) = definedExternally
    var shaded: Graph2dShadedOption? get() = definedExternally; set(value) = definedExternally
    var style: String? get() = definedExternally; set(value) = definedExternally
    var yAxisOrientation: dynamic /* 'right' | 'left' */ get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface InterpolationOptions {
    var parametrization: dynamic /* 'centripetal' | 'chordal' | 'uniform' | 'disabled' */
}

// @JsModule("vis") @JsNonModule
external interface TimelineEditableOption {
    var add: Boolean? get() = definedExternally; set(value) = definedExternally
    var remove: Boolean? get() = definedExternally; set(value) = definedExternally
    var updateGroup: Boolean? get() = definedExternally; set(value) = definedExternally
    var updateTime: Boolean? get() = definedExternally; set(value) = definedExternally
    var overrideItems: Boolean? get() = definedExternally; set(value) = definedExternally
}

//typealias TimelineFormatLabelsFunction = (date: Date, scale: String, step: Number) -> String

// @JsModule("vis") @JsNonModule
external interface TimelineFormatLabelsOption {
    var millisecond: String? get() = definedExternally; set(value) = definedExternally
    var second: String? get() = definedExternally; set(value) = definedExternally
    var minute: String? get() = definedExternally; set(value) = definedExternally
    var hour: String? get() = definedExternally; set(value) = definedExternally
    var weekday: String? get() = definedExternally; set(value) = definedExternally
    var day: String? get() = definedExternally; set(value) = definedExternally
    var week: String? get() = definedExternally; set(value) = definedExternally
    var month: String? get() = definedExternally; set(value) = definedExternally
    var year: String? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface TimelineFormatOption {
    var minorLabels: dynamic /* TimelineFormatLabelsOption | TimelineFormatLabelsFunction */ get() = definedExternally; set(value) = definedExternally
    var majorLabels: dynamic /* TimelineFormatLabelsOption | TimelineFormatLabelsFunction */ get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface TimelineGroupEditableOption {
    var add: Boolean? get() = definedExternally; set(value) = definedExternally
    var remove: Boolean? get() = definedExternally; set(value) = definedExternally
    var order: Boolean? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface TimelineHiddenDateOption {
    var start: dynamic /* Date | Number | String */
    var end: dynamic /* Date | Number | String */
    var repeat: dynamic /* 'daily' | 'weekly' | 'monthly' | 'yearly' */ get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface TimelineItemsAlwaysDraggableOption {
    var item: Boolean? get() = definedExternally; set(value) = definedExternally
    var range: Boolean? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface TimelineMarginItem {
    var horizontal: Number? get() = definedExternally; set(value) = definedExternally
    var vertical: Number? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface TimelineMarginOption {
    var axis: Number? get() = definedExternally; set(value) = definedExternally
    var item: dynamic /* Number | TimelineMarginItem */ get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface TimelineOrientationOption {
    var axis: String? get() = definedExternally; set(value) = definedExternally
    var item: String? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface TimelineTimeAxisOption {
    var scale: dynamic /* 'millisecond' | 'second' | 'minute' | 'hour' | 'weekday' | 'day' | 'month' | 'year' */ get() = definedExternally; set(value) = definedExternally
    var step: Number? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface TimelineRollingModeOption {
    var follow: Boolean? get() = definedExternally; set(value) = definedExternally
    var offset: Number? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface TimelineTooltipOption {
    var followMouse: Boolean
    var overflowMethod: dynamic /* 'cap' | 'flip' */
}
//typealias TimelineOptionsConfigureFunction = (option: String, path: Array<String>) -> Boolean
//typealias TimelineOptionsItemCallbackFunction = (item: TimelineItem, callback: (item: TimelineItem?) -> Unit) -> Unit
//typealias TimelineOptionsGroupCallbackFunction = (group: TimelineGroup, callback: (group: TimelineGroup?) -> Unit) -> Unit
//typealias TimelineOptionsGroupOrderSwapFunction = (fromGroup: Any, toGroup: Any, groups: DataSet<DataGroup>) -> Unit
//typealias TimelineOptionsSnapFunction = (date: Date, scale: String, step: Number) -> dynamic
//typealias TimelineOptionsTemplateFunction = (item: Any? /*= null*/, element: Any? /*= null*/, data: Any? /*= null*/) -> String
//typealias TimelineOptionsComparisonFunction = (a: Any, b: Any) -> Number
// @JsModule("vis") @JsNonModule
external interface `T$0` {
    fun template(item: Any): Any
}

// @JsModule("vis") @JsNonModule
external interface TimelineOptions {
    var align: dynamic /* 'auto' | 'center' | 'left' | 'right' */ get() = definedExternally; set(value) = definedExternally
    var autoResize: Boolean? get() = definedExternally; set(value) = definedExternally
    var clickToUse: Boolean? get() = definedExternally; set(value) = definedExternally
    var configure: dynamic /* Boolean | TimelineOptionsConfigureFunction */ get() = definedExternally; set(value) = definedExternally
    var dataAttributes: dynamic /* Boolean | String | Array<String> */ get() = definedExternally; set(value) = definedExternally
    var editable: dynamic /* Boolean | TimelineEditableOption */ get() = definedExternally; set(value) = definedExternally
    var end: dynamic /* Date | Number | String */ get() = definedExternally; set(value) = definedExternally
    var format: TimelineFormatOption? get() = definedExternally; set(value) = definedExternally
    var groupEditable: dynamic /* Boolean | TimelineGroupEditableOption */ get() = definedExternally; set(value) = definedExternally
    var groupOrder: dynamic /* String | TimelineOptionsComparisonFunction */ get() = definedExternally; set(value) = definedExternally
//    var groupOrderSwap: TimelineOptionsGroupOrderSwapFunction? get() = definedExternally; set(value) = definedExternally
//    var groupTemplate: TimelineOptionsTemplateFunction? get() = definedExternally; set(value) = definedExternally
    var height: dynamic get() = definedExternally; set(value) = definedExternally
    var hiddenDates: dynamic /* TimelineHiddenDateOption | Array<TimelineHiddenDateOption> */ get() = definedExternally; set(value) = definedExternally
    var horizontalScroll: Boolean? get() = definedExternally; set(value) = definedExternally
    var itemsAlwaysDraggable: dynamic /* Boolean | TimelineItemsAlwaysDraggableOption */ get() = definedExternally; set(value) = definedExternally
    var locale: String? get() = definedExternally; set(value) = definedExternally
    var locales: Any? get() = definedExternally; set(value) = definedExternally
    var moment: dynamic /* MomentConstructor1 | MomentConstructor2 */ get() = definedExternally; set(value) = definedExternally
    var margin: dynamic /* Number | TimelineMarginOption */ get() = definedExternally; set(value) = definedExternally
    var max: dynamic /* Date | Number | String */ get() = definedExternally; set(value) = definedExternally
    var maxHeight: dynamic get() = definedExternally; set(value) = definedExternally
    var maxMinorChars: Number? get() = definedExternally; set(value) = definedExternally
    var min: dynamic /* Date | Number | String */ get() = definedExternally; set(value) = definedExternally
    var minHeight: dynamic get() = definedExternally; set(value) = definedExternally
    var moveable: Boolean? get() = definedExternally; set(value) = definedExternally
    var multiselect: Boolean? get() = definedExternally; set(value) = definedExternally
    var multiselectPerGroup: Boolean? get() = definedExternally; set(value) = definedExternally
//    var onAdd: TimelineOptionsItemCallbackFunction? get() = definedExternally; set(value) = definedExternally
//    var onAddGroup: TimelineOptionsGroupCallbackFunction? get() = definedExternally; set(value) = definedExternally
//    var onUpdate: TimelineOptionsItemCallbackFunction? get() = definedExternally; set(value) = definedExternally
//    var onMove: TimelineOptionsItemCallbackFunction? get() = definedExternally; set(value) = definedExternally
//    var onMoveGroup: TimelineOptionsGroupCallbackFunction? get() = definedExternally; set(value) = definedExternally
//    var onMoving: TimelineOptionsItemCallbackFunction? get() = definedExternally; set(value) = definedExternally
//    var onRemove: TimelineOptionsItemCallbackFunction? get() = definedExternally; set(value) = definedExternally
//    var onRemoveGroup: TimelineOptionsGroupCallbackFunction? get() = definedExternally; set(value) = definedExternally
//    var order: TimelineOptionsComparisonFunction? get() = definedExternally; set(value) = definedExternally
    var orientation: dynamic /* String | TimelineOrientationOption */ get() = definedExternally; set(value) = definedExternally
    var rollingMode: TimelineRollingModeOption? get() = definedExternally; set(value) = definedExternally
    var rtl: Boolean? get() = definedExternally; set(value) = definedExternally
    var selectable: Boolean? get() = definedExternally; set(value) = definedExternally
    var showCurrentTime: Boolean? get() = definedExternally; set(value) = definedExternally
    var showMajorLabels: Boolean? get() = definedExternally; set(value) = definedExternally
    var showMinorLabels: Boolean? get() = definedExternally; set(value) = definedExternally
    var showTooltips: Boolean? get() = definedExternally; set(value) = definedExternally
    var stack: Boolean? get() = definedExternally; set(value) = definedExternally
    var stackSubgroups: Boolean? get() = definedExternally; set(value) = definedExternally
//    var snap: TimelineOptionsSnapFunction? get() = definedExternally; set(value) = definedExternally
    var start: dynamic /* Date | Number | String */ get() = definedExternally; set(value) = definedExternally
//    var template: TimelineOptionsTemplateFunction? get() = definedExternally; set(value) = definedExternally
//    var visibleFrameTemplate: TimelineOptionsTemplateFunction? get() = definedExternally; set(value) = definedExternally
    var throttleRedraw: Number? get() = definedExternally; set(value) = definedExternally
    var timeAxis: TimelineTimeAxisOption? get() = definedExternally; set(value) = definedExternally
    var type: String? get() = definedExternally; set(value) = definedExternally
    var tooltip: TimelineTooltipOption? get() = definedExternally; set(value) = definedExternally
    var tooltipOnItemUpdateTime: dynamic /* Boolean | `T$0` */ get() = definedExternally; set(value) = definedExternally
    var verticalScroll: Boolean? get() = definedExternally; set(value) = definedExternally
    var width: dynamic get() = definedExternally; set(value) = definedExternally
    var zoomable: Boolean? get() = definedExternally; set(value) = definedExternally
    var zoomKey: String? get() = definedExternally; set(value) = definedExternally
    var zoomMax: Number? get() = definedExternally; set(value) = definedExternally
    var zoomMin: Number? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface TimelineAnimationOptions {
    var animation: dynamic /* Boolean | AnimationOptions */ get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface TimelineEventPropertiesResult {
    var group: Number? get() = definedExternally; set(value) = definedExternally
    var item: Number? get() = definedExternally; set(value) = definedExternally
    var pageX: Number
    var pageY: Number
    var x: Number
    var y: Number
    var time: Date
    var snappedTime: Date
    var what: dynamic /* 'item' | 'background' | 'axis' | 'group-label' | 'custom-time' | 'current-time' */ get() = definedExternally; set(value) = definedExternally
    var event: Event
}

// @JsModule("vis") @JsNonModule
external interface DataSetOptions : DataSetQueueOptions {
    var fieldId: String? get() = definedExternally; set(value) = definedExternally
    var type: Any? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface DataSetQueueOptions {
    var queue: dynamic /* Any | Boolean */ get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external open class DataSet<T : Any>(options: DataSetOptions) {
    constructor(data: Array<T>?, options: DataSetOptions?)
    open var length: Number
    open fun add(data: T, senderId: String = definedExternally /* null */): Array<dynamic /* String | Number */>
    open fun add(data: T, senderId: Number = definedExternally /* null */): Array<dynamic /* String | Number */>
    open fun add(data: Array<T>, senderId: String = definedExternally /* null */): Array<dynamic /* String | Number */>
    open fun add(data: Array<T>, senderId: Number = definedExternally /* null */): Array<dynamic /* String | Number */>
    open fun clear(senderId: String = definedExternally /* null */): Array<dynamic /* String | Number */>
    open fun clear(senderId: Number = definedExternally /* null */): Array<dynamic /* String | Number */>
    open fun distinct(field: String): Array<Any>
    open fun flush(): Unit
    open fun forEach(callback: (item: T, id: dynamic /* String | Number */) -> Unit, options: DataSelectionOptions<T>? = definedExternally /* null */): Unit
    open fun get(options: DataSelectionOptions<T>? = definedExternally /* null */): Array<T>
    open fun get(id: String, options: DataSelectionOptions<T>? = definedExternally /* null */): T
    open fun get(id: Number, options: DataSelectionOptions<T>? = definedExternally /* null */): T
    open fun get(ids: Array<dynamic /* String | Number */>, options: DataSelectionOptions<T>? = definedExternally /* null */): Array<T>
    open fun getDataSet(): DataSet<T>
    open fun getIds(options: DataSelectionOptions<T>? = definedExternally /* null */): Array<dynamic /* String | Number */>
    open fun map(callback: (item: T, id: dynamic /* String | Number */) -> Any, options: DataSelectionOptions<T>? = definedExternally /* null */): Array<Any>
    open fun max(field: String): T
    open fun min(field: String): T
    open fun on(event: String, callback: (event: String, properties: Any, senderId: dynamic /* String | Number */) -> Unit): Unit
    open fun off(event: String, callback: (event: String, properties: Any, senderId: dynamic /* String | Number */) -> Unit): Unit
    open fun remove(id: String, senderId: String = definedExternally /* null */): Array<dynamic /* String | Number */>
    open fun remove(id: String, senderId: Number = definedExternally /* null */): Array<dynamic /* String | Number */>
    open fun remove(id: Number, senderId: String = definedExternally /* null */): Array<dynamic /* String | Number */>
    open fun remove(id: Number, senderId: Number = definedExternally /* null */): Array<dynamic /* String | Number */>
    open fun remove(id: Array<dynamic /* String | Number */>, senderId: String = definedExternally /* null */): Array<dynamic /* String | Number */>
    open fun remove(id: Array<dynamic /* String | Number */>, senderId: Number = definedExternally /* null */): Array<dynamic /* String | Number */>
    open fun setOptions(options: DataSetQueueOptions? = definedExternally /* null */): Unit
    open fun update(data: T, senderId: String = definedExternally /* null */): Array<dynamic /* String | Number */>
    open fun update(data: T, senderId: Number = definedExternally /* null */): Array<dynamic /* String | Number */>
    open fun update(data: Array<T>, senderId: String = definedExternally /* null */): Array<dynamic /* String | Number */>
    open fun update(data: Array<T>, senderId: Number = definedExternally /* null */): Array<dynamic /* String | Number */>
    open fun add(data: T): Array<dynamic /* String | Number */>
    open fun add(data: Array<T>): Array<dynamic /* String | Number */>
    open fun clear(): Array<dynamic /* String | Number */>
    open fun remove(id: String): Array<dynamic /* String | Number */>
    open fun remove(id: Number): Array<dynamic /* String | Number */>
    open fun remove(id: Array<dynamic /* String | Number */>): Array<dynamic /* String | Number */>
    open fun update(data: T): Array<dynamic /* String | Number */>
    open fun update(data: Array<T>): Array<dynamic /* String | Number */>
}

// @JsModule("vis") @JsNonModule
external interface DataSelectionOptions<T> {
    var fields: dynamic /* Array<String> | Any */ get() = definedExternally; set(value) = definedExternally
    var type: Any? get() = definedExternally; set(value) = definedExternally
    val filter: ((item: T) -> Boolean)? get() = definedExternally
    var order: dynamic /* String | Any */ get() = definedExternally; set(value) = definedExternally
    var returnType: String? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external open class DataView<T : Any>(items: Array<T>) {
    open var length: Number
}

// @JsModule("vis") @JsNonModule
external interface TitleOption {
    var text: String? get() = definedExternally; set(value) = definedExternally
    var style: String? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface RangeType {
    var min: dynamic /* String | Number */
    var max: dynamic /* String | Number */
}

// @JsModule("vis") @JsNonModule
external interface DataAxisSideOption {
    var range: RangeType? get() = definedExternally; set(value) = definedExternally
    val format: (() -> String)? get() = definedExternally
    var title: TitleOption? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface Graph2dBarChartOption {
    var width: Number? get() = definedExternally; set(value) = definedExternally
    var minWidth: Number? get() = definedExternally; set(value) = definedExternally
    var sideBySide: Boolean? get() = definedExternally; set(value) = definedExternally
    var align: dynamic /* 'left' | 'center' | 'right' */ get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface Graph2dDataAxisOption {
    var orientation: dynamic /* String | TimelineOrientationOption */ get() = definedExternally; set(value) = definedExternally
    var showMinorLabels: Boolean? get() = definedExternally; set(value) = definedExternally
    var showMajorLabels: Boolean? get() = definedExternally; set(value) = definedExternally
    var majorLinesOffset: Number? get() = definedExternally; set(value) = definedExternally
    var minorLinesOffset: Number? get() = definedExternally; set(value) = definedExternally
    var labelOffsetX: Number? get() = definedExternally; set(value) = definedExternally
    var labelOffsetY: Number? get() = definedExternally; set(value) = definedExternally
    var iconWidth: Number? get() = definedExternally; set(value) = definedExternally
    var width: String? get() = definedExternally; set(value) = definedExternally
    var icons: Boolean? get() = definedExternally; set(value) = definedExternally
    var visible: Boolean? get() = definedExternally; set(value) = definedExternally
    var alignZeros: Boolean? get() = definedExternally; set(value) = definedExternally
    var left: DataAxisSideOption? get() = definedExternally; set(value) = definedExternally
    var right: DataAxisSideOption? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface Graph2dDrawPointsOption {
    var enabled: Boolean? get() = definedExternally; set(value) = definedExternally
    val onRender: (() -> Boolean)? get() = definedExternally
    var size: Number? get() = definedExternally; set(value) = definedExternally
    var style: dynamic /* 'square' | 'circle' */
}

// @JsModule("vis") @JsNonModule
external interface Graph2dShadedOption {
    var orientation: dynamic /* 'top' | 'bottom' */ get() = definedExternally; set(value) = definedExternally
    var groupid: dynamic /* String | Number */ get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface Graph2dOptions {
    var autoResize: Boolean? get() = definedExternally; set(value) = definedExternally
    var barChart: dynamic /* Number | Graph2dBarChartOption */ get() = definedExternally; set(value) = definedExternally
    var clickToUse: Boolean? get() = definedExternally; set(value) = definedExternally
    var configure: dynamic /* Boolean | TimelineOptionsConfigureFunction */ get() = definedExternally; set(value) = definedExternally
    var dataAxis: dynamic /* Boolean | Graph2dDataAxisOption */ get() = definedExternally; set(value) = definedExternally
    var defaultGroup: String? get() = definedExternally; set(value) = definedExternally
    var drawPoints: dynamic /* Boolean | Graph2dDrawPointsOption */ get() = definedExternally; set(value) = definedExternally
    var end: dynamic /* Date | Number | String */ get() = definedExternally; set(value) = definedExternally
    var format: Any? get() = definedExternally; set(value) = definedExternally
    var graphHeight: dynamic get() = definedExternally; set(value) = definedExternally
    var height: dynamic get() = definedExternally; set(value) = definedExternally
    var hiddenDates: Any? get() = definedExternally; set(value) = definedExternally
    var legend: dynamic /* Boolean | LegendOptions */ get() = definedExternally; set(value) = definedExternally
    var locale: String? get() = definedExternally; set(value) = definedExternally
    var locales: Any? get() = definedExternally; set(value) = definedExternally
    var moment: dynamic /* MomentConstructor1 | MomentConstructor2 */ get() = definedExternally; set(value) = definedExternally
    var max: dynamic /* Date | Number | String */ get() = definedExternally; set(value) = definedExternally
    var maxHeight: dynamic get() = definedExternally; set(value) = definedExternally
    var maxMinorChars: Number? get() = definedExternally; set(value) = definedExternally
    var min: dynamic /* Date | Number | String */ get() = definedExternally; set(value) = definedExternally
    var minHeight: dynamic get() = definedExternally; set(value) = definedExternally
    var moveable: Boolean? get() = definedExternally; set(value) = definedExternally
    var multiselect: Boolean? get() = definedExternally; set(value) = definedExternally
    var orientation: String? get() = definedExternally; set(value) = definedExternally
    var sampling: Boolean? get() = definedExternally; set(value) = definedExternally
    var showCurrentTime: Boolean? get() = definedExternally; set(value) = definedExternally
    var showMajorLabels: Boolean? get() = definedExternally; set(value) = definedExternally
    var showMinorLabels: Boolean? get() = definedExternally; set(value) = definedExternally
    var sort: Boolean? get() = definedExternally; set(value) = definedExternally
    var stack: Boolean? get() = definedExternally; set(value) = definedExternally
    var start: dynamic /* Date | Number | String */ get() = definedExternally; set(value) = definedExternally
    var style: dynamic /* 'line' | 'bar' | 'points' */ get() = definedExternally; set(value) = definedExternally
    var throttleRedraw: Number? get() = definedExternally; set(value) = definedExternally
    var timeAxis: TimelineTimeAxisOption? get() = definedExternally; set(value) = definedExternally
    var width: dynamic get() = definedExternally; set(value) = definedExternally
    var yAxisOrientation: dynamic /* 'right' | 'left' */ get() = definedExternally; set(value) = definedExternally
    var zoomable: Boolean? get() = definedExternally; set(value) = definedExternally
    var zoomKey: String? get() = definedExternally; set(value) = definedExternally
    var zoomMax: Number? get() = definedExternally; set(value) = definedExternally
    var zoomMin: Number? get() = definedExternally; set(value) = definedExternally
    var zIndex: Number? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface `T$1` {
    var start: Date
    var end: Date
}

// @JsModule("vis") @JsNonModule
external interface `T$2` {
    var groups: dynamic /* Array<DataGroup> | DataSet<DataGroup> | DataView<DataGroup> */ get() = definedExternally; set(value) = definedExternally
    var items: dynamic /* Array<DataItem> | DataSet<DataItem> | DataView<DataItem> */ get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external open class Graph2d {
    constructor(container: HTMLElement, items: Array<DataItem>, groups: Array<DataGroup>, options: Graph2dOptions?)
    constructor(container: HTMLElement, items: Array<DataItem>, groups: DataSet<DataGroup>, options: Graph2dOptions?)
    constructor(container: HTMLElement, items: Array<DataItem>, groups: DataView<DataGroup>, options: Graph2dOptions?)
    constructor(container: HTMLElement, items: DataSet<DataItem>, groups: Array<DataGroup>, options: Graph2dOptions?)
    constructor(container: HTMLElement, items: DataSet<DataItem>, groups: DataSet<DataGroup>, options: Graph2dOptions?)
    constructor(container: HTMLElement, items: DataSet<DataItem>, groups: DataView<DataGroup>, options: Graph2dOptions?)
    constructor(container: HTMLElement, items: DataView<DataItem>, groups: Array<DataGroup>, options: Graph2dOptions?)
    constructor(container: HTMLElement, items: DataView<DataItem>, groups: DataSet<DataGroup>, options: Graph2dOptions?)
    constructor(container: HTMLElement, items: DataView<DataItem>, groups: DataView<DataGroup>, options: Graph2dOptions?)
    constructor(container: HTMLElement, items: Array<DataItem>, options: Graph2dOptions?)
    constructor(container: HTMLElement, items: DataSet<DataItem>, options: Graph2dOptions?)
    constructor(container: HTMLElement, items: DataView<DataItem>, options: Graph2dOptions?)
    open fun addCustomTime(time: Date, id: String = definedExternally /* null */): dynamic /* String | Number */
    open fun addCustomTime(time: Date, id: Number = definedExternally /* null */): dynamic /* String | Number */
    open fun addCustomTime(time: Number, id: String = definedExternally /* null */): dynamic /* String | Number */
    open fun addCustomTime(time: Number, id: Number = definedExternally /* null */): dynamic /* String | Number */
    open fun addCustomTime(time: String, id: String = definedExternally /* null */): dynamic /* String | Number */
    open fun addCustomTime(time: String, id: Number = definedExternally /* null */): dynamic /* String | Number */
    open fun destroy(): Unit
    open fun fit(options: TimelineAnimationOptions? = definedExternally /* null */): Unit
    open fun focus(ids: String, options: TimelineAnimationOptions? = definedExternally /* null */): Unit
    open fun focus(ids: Number, options: TimelineAnimationOptions? = definedExternally /* null */): Unit
    open fun focus(ids: Array<dynamic /* String | Number */>, options: TimelineAnimationOptions? = definedExternally /* null */): Unit
    open fun getCurrentTime(): Date
    open fun getCustomTime(id: String = definedExternally /* null */): Date
    open fun getCustomTime(id: Number = definedExternally /* null */): Date
    open fun getEventProperties(event: Event): TimelineEventPropertiesResult
    open fun getItemRange(): Any
    open fun getSelection(): Array<dynamic /* String | Number */>
    open fun getVisibleItems(): Array<dynamic /* String | Number */>
    open fun getWindow(): `T$1`
    open fun moveTo(time: Date, options: TimelineAnimationOptions? = definedExternally /* null */): Unit
    open fun moveTo(time: Number, options: TimelineAnimationOptions? = definedExternally /* null */): Unit
    open fun moveTo(time: String, options: TimelineAnimationOptions? = definedExternally /* null */): Unit
    open fun on(event: dynamic /* 'currentTimeTick' | 'click' | 'contextmenu' | 'doubleClick' | 'drop' | 'mouseOver' | 'mouseDown' | 'mouseUp' | 'mouseMove' | 'groupDragged' | 'changed' | 'rangechange' | 'rangechanged' | 'select' | 'itemover' | 'itemout' | 'timechange' | 'timechanged' */, callback: () -> Unit): Unit
    open fun off(event: dynamic /* 'currentTimeTick' | 'click' | 'contextmenu' | 'doubleClick' | 'drop' | 'mouseOver' | 'mouseDown' | 'mouseUp' | 'mouseMove' | 'groupDragged' | 'changed' | 'rangechange' | 'rangechanged' | 'select' | 'itemover' | 'itemout' | 'timechange' | 'timechanged' */, callback: () -> Unit): Unit
    open fun redraw(): Unit
    open fun removeCustomTime(id: String): Unit
    open fun removeCustomTime(id: Number): Unit
    open fun setCurrentTime(time: Date): Unit
    open fun setCurrentTime(time: Number): Unit
    open fun setCurrentTime(time: String): Unit
    open fun setCustomTime(time: Date, id: String = definedExternally /* null */): Unit
    open fun setCustomTime(time: Date, id: Number = definedExternally /* null */): Unit
    open fun setCustomTime(time: Number, id: String = definedExternally /* null */): Unit
    open fun setCustomTime(time: Number, id: Number = definedExternally /* null */): Unit
    open fun setCustomTime(time: String, id: String = definedExternally /* null */): Unit
    open fun setCustomTime(time: String, id: Number = definedExternally /* null */): Unit
    open fun setCustomTimeTitle(title: String, id: String = definedExternally /* null */): Unit
    open fun setCustomTimeTitle(title: String, id: Number = definedExternally /* null */): Unit
    open fun setData(data: `T$2`): Unit
    open fun setGroups(groups: Array<DataGroup> = definedExternally /* null */): Unit
    open fun setGroups(groups: DataSet<DataGroup> = definedExternally /* null */): Unit
    open fun setGroups(groups: DataView<DataGroup> = definedExternally /* null */): Unit
    open fun setItems(items: Array<DataItem>): Unit
    open fun setItems(items: DataSet<DataItem>): Unit
    open fun setItems(items: DataView<DataItem>): Unit
    open fun setOptions(options: TimelineOptions): Unit
    open fun setSelection(ids: String): Unit
    open fun setSelection(ids: Number): Unit
    open fun setSelection(ids: Array<dynamic /* String | Number */>): Unit
    open fun setWindow(start: Date, end: Date, options: TimelineAnimationOptions? = definedExternally /* null */): Unit
    open fun setWindow(start: Date, end: Number, options: TimelineAnimationOptions? = definedExternally /* null */): Unit
    open fun setWindow(start: Date, end: String, options: TimelineAnimationOptions? = definedExternally /* null */): Unit
    open fun setWindow(start: Number, end: Date, options: TimelineAnimationOptions? = definedExternally /* null */): Unit
    open fun setWindow(start: Number, end: Number, options: TimelineAnimationOptions? = definedExternally /* null */): Unit
    open fun setWindow(start: Number, end: String, options: TimelineAnimationOptions? = definedExternally /* null */): Unit
    open fun setWindow(start: String, end: Date, options: TimelineAnimationOptions? = definedExternally /* null */): Unit
    open fun setWindow(start: String, end: Number, options: TimelineAnimationOptions? = definedExternally /* null */): Unit
    open fun setWindow(start: String, end: String, options: TimelineAnimationOptions? = definedExternally /* null */): Unit
    open fun addCustomTime(time: Date): dynamic /* String | Number */
    open fun addCustomTime(time: Number): dynamic /* String | Number */
    open fun addCustomTime(time: String): dynamic /* String | Number */
    open fun getCustomTime(): Date
    open fun setCustomTime(time: Date): Unit
    open fun setCustomTime(time: Number): Unit
    open fun setCustomTime(time: String): Unit
    open fun setCustomTimeTitle(title: String): Unit
    open fun setGroups(): Unit
    fun setGroups(groups: Array<TimelineGroup>? = definedExternally /* null */)
    fun setItems(items: Array<TimelineItem>? = definedExternally /* null */)
    fun getLegend(): TimelineWindow
    fun getWindow(): TimelineWindow
    fun setWindow(start: Any, date: Any)
    fun focus(selection: Any)
    fun on(event: String? = definedExternally /* null */, callback: ((properties: Any) -> Unit)? = definedExternally /* null */)
}

// @JsModule("vis") @JsNonModule
external interface `T$3` {
    var min: Date
    var max: Date
}

// @JsModule("vis") @JsNonModule
external interface `T$4` {
    var focus: Boolean
    var animation: TimelineAnimationOptions
}

// @JsModule("vis") @JsNonModule
external open class Timeline {
    constructor(container: HTMLElement, items: Array<DataItem>, groups: Array<DataGroup>, options: TimelineOptions?)
    constructor(container: HTMLElement, items: Array<DataItem>, groups: DataSet<DataGroup>, options: TimelineOptions?)
    constructor(container: HTMLElement, items: Array<DataItem>, groups: DataView<DataGroup>, options: TimelineOptions?)
    constructor(container: HTMLElement, items: DataSet<DataItem>, groups: Array<DataGroup>, options: TimelineOptions?)
    constructor(container: HTMLElement, items: DataSet<DataItem>, groups: DataSet<DataGroup>, options: TimelineOptions?)
    constructor(container: HTMLElement, items: DataSet<DataItem>, groups: DataView<DataGroup>, options: TimelineOptions?)
    constructor(container: HTMLElement, items: DataView<DataItem>, groups: Array<DataGroup>, options: TimelineOptions?)
    constructor(container: HTMLElement, items: DataView<DataItem>, groups: DataSet<DataGroup>, options: TimelineOptions?)
    constructor(container: HTMLElement, items: DataView<DataItem>, groups: DataView<DataGroup>, options: TimelineOptions?)
    constructor(container: HTMLElement, items: Array<DataItem>, options: TimelineOptions?)
    constructor(container: HTMLElement, items: DataSet<DataItem>, options: TimelineOptions?)
    constructor(container: HTMLElement, items: DataView<DataItem>, options: TimelineOptions?)
    open fun addCustomTime(time: Date, id: String = definedExternally /* null */): dynamic /* String | Number */
    open fun addCustomTime(time: Date, id: Number = definedExternally /* null */): dynamic /* String | Number */
    open fun addCustomTime(time: Number, id: String = definedExternally /* null */): dynamic /* String | Number */
    open fun addCustomTime(time: Number, id: Number = definedExternally /* null */): dynamic /* String | Number */
    open fun addCustomTime(time: String, id: String = definedExternally /* null */): dynamic /* String | Number */
    open fun addCustomTime(time: String, id: Number = definedExternally /* null */): dynamic /* String | Number */
    open fun destroy(): Unit
    open fun fit(options: TimelineAnimationOptions? = definedExternally /* null */): Unit
    open fun focus(ids: String, options: TimelineAnimationOptions? = definedExternally /* null */): Unit
    open fun focus(ids: Number, options: TimelineAnimationOptions? = definedExternally /* null */): Unit
    open fun focus(ids: Array<dynamic /* String | Number */>, options: TimelineAnimationOptions? = definedExternally /* null */): Unit
    open fun getCurrentTime(): Date
    open fun getCustomTime(id: String = definedExternally /* null */): Date
    open fun getCustomTime(id: Number = definedExternally /* null */): Date
    open fun getEventProperties(event: Event): TimelineEventPropertiesResult
    open fun getItemRange(): `T$3`
    open fun getSelection(): Array<dynamic /* String | Number */>
    open fun getVisibleItems(): Array<dynamic /* String | Number */>
    open fun getWindow(): TimelineWindow
    open fun moveTo(time: Date, options: TimelineAnimationOptions? = definedExternally /* null */, callback: ((properties: Any? /*= null*/) -> Unit)? = definedExternally /* null */): Unit
    open fun moveTo(time: Number, options: TimelineAnimationOptions? = definedExternally /* null */, callback: ((properties: Any? /*= null*/) -> Unit)? = definedExternally /* null */): Unit
    open fun moveTo(time: String, options: TimelineAnimationOptions? = definedExternally /* null */, callback: ((properties: Any? /*= null*/) -> Unit)? = definedExternally /* null */): Unit
    open fun on(event: dynamic /* 'currentTimeTick' | 'click' | 'contextmenu' | 'doubleClick' | 'drop' | 'mouseOver' | 'mouseDown' | 'mouseUp' | 'mouseMove' | 'groupDragged' | 'changed' | 'rangechange' | 'rangechanged' | 'select' | 'itemover' | 'itemout' | 'timechange' | 'timechanged' */, callback: ((properties: Any? /*= null*/) -> Unit)? = definedExternally /* null */): Unit
    open fun off(event: dynamic /* 'currentTimeTick' | 'click' | 'contextmenu' | 'doubleClick' | 'drop' | 'mouseOver' | 'mouseDown' | 'mouseUp' | 'mouseMove' | 'groupDragged' | 'changed' | 'rangechange' | 'rangechanged' | 'select' | 'itemover' | 'itemout' | 'timechange' | 'timechanged' */, callback: ((properties: Any? /*= null*/) -> Unit)? = definedExternally /* null */): Unit
    open fun redraw(): Unit
    open fun removeCustomTime(id: String): Unit
    open fun removeCustomTime(id: Number): Unit
    open fun setCurrentTime(time: Date): Unit
    open fun setCurrentTime(time: Number): Unit
    open fun setCurrentTime(time: String): Unit
    open fun setCustomTime(time: Date, id: String = definedExternally /* null */): Unit
    open fun setCustomTime(time: Date, id: Number = definedExternally /* null */): Unit
    open fun setCustomTime(time: Number, id: String = definedExternally /* null */): Unit
    open fun setCustomTime(time: Number, id: Number = definedExternally /* null */): Unit
    open fun setCustomTime(time: String, id: String = definedExternally /* null */): Unit
    open fun setCustomTime(time: String, id: Number = definedExternally /* null */): Unit
    open fun setCustomTimeTitle(title: String, id: String = definedExternally /* null */): Unit
    open fun setCustomTimeTitle(title: String, id: Number = definedExternally /* null */): Unit
    open fun setData(data: `T$2`): Unit
    open fun setGroups(groups: Array<DataGroup> = definedExternally /* null */): Unit
    open fun setGroups(groups: DataSet<DataGroup> = definedExternally /* null */): Unit
    open fun setGroups(groups: DataView<DataGroup> = definedExternally /* null */): Unit
    open fun setItems(items: Array<DataItem>): Unit
    open fun setItems(items: DataSet<DataItem>): Unit
    open fun setItems(items: DataView<DataItem>): Unit
    open fun setOptions(options: TimelineOptions): Unit
    open fun setSelection(ids: String, options: `T$4`? = definedExternally /* null */): Unit
    open fun setSelection(ids: Number, options: `T$4`? = definedExternally /* null */): Unit
    open fun setSelection(ids: Array<dynamic /* String | Number */>, options: `T$4`? = definedExternally /* null */): Unit
    open fun setWindow(start: Date, end: Date, options: TimelineAnimationOptions? = definedExternally /* null */, callback: (() -> Unit)? = definedExternally /* null */): Unit
    open fun setWindow(start: Date, end: Number, options: TimelineAnimationOptions? = definedExternally /* null */, callback: (() -> Unit)? = definedExternally /* null */): Unit
    open fun setWindow(start: Date, end: String, options: TimelineAnimationOptions? = definedExternally /* null */, callback: (() -> Unit)? = definedExternally /* null */): Unit
    open fun setWindow(start: Number, end: Date, options: TimelineAnimationOptions? = definedExternally /* null */, callback: (() -> Unit)? = definedExternally /* null */): Unit
    open fun setWindow(start: Number, end: Number, options: TimelineAnimationOptions? = definedExternally /* null */, callback: (() -> Unit)? = definedExternally /* null */): Unit
    open fun setWindow(start: Number, end: String, options: TimelineAnimationOptions? = definedExternally /* null */, callback: (() -> Unit)? = definedExternally /* null */): Unit
    open fun setWindow(start: String, end: Date, options: TimelineAnimationOptions? = definedExternally /* null */, callback: (() -> Unit)? = definedExternally /* null */): Unit
    open fun setWindow(start: String, end: Number, options: TimelineAnimationOptions? = definedExternally /* null */, callback: (() -> Unit)? = definedExternally /* null */): Unit
    open fun setWindow(start: String, end: String, options: TimelineAnimationOptions? = definedExternally /* null */, callback: (() -> Unit)? = definedExternally /* null */): Unit
    open fun toggleRollingMode(): Unit
    open fun zoomIn(percentage: Number, options: TimelineAnimationOptions? = definedExternally /* null */, callback: (() -> Unit)? = definedExternally /* null */): Unit
    open fun zoomOut(percentage: Number, options: TimelineAnimationOptions? = definedExternally /* null */, callback: (() -> Unit)? = definedExternally /* null */): Unit
    open fun addCustomTime(time: Date): dynamic /* String | Number */
    open fun addCustomTime(time: Number): dynamic /* String | Number */
    open fun addCustomTime(time: String): dynamic /* String | Number */
    open fun getCustomTime(): Date
    open fun setCustomTime(time: Date): Unit
    open fun setCustomTime(time: Number): Unit
    open fun setCustomTime(time: String): Unit
    open fun setCustomTimeTitle(title: String): Unit
    open fun setGroups(): Unit
    fun setGroups(groups: Array<TimelineGroup>? = definedExternally /* null */)
    fun setItems(items: Array<TimelineItem>? = definedExternally /* null */)
    fun getWindow(): TimelineWindow
    fun setWindow(start: Any, date: Any)
    fun focus(selection: Any)
    fun on(event: String? = definedExternally /* null */, callback: ((properties: Any) -> Unit)? = definedExternally /* null */)
    fun off(event: String, callback: ((properties: Any? /*= null*/) -> Unit)? = definedExternally /* null */)
}

// @JsModule("vis") @JsNonModule
external interface TimelineStatic
external interface TimelineWindow {
    var start: Date
    var end: Date
}

// @JsModule("vis") @JsNonModule
external interface TimelineItemEditableOption {
    var remove: Boolean? get() = definedExternally; set(value) = definedExternally
    var updateGroup: Boolean? get() = definedExternally; set(value) = definedExternally
    var updateTime: Boolean? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface TimelineItem {
    var className: String? get() = definedExternally; set(value) = definedExternally
    var align: dynamic /* 'auto' | 'center' | 'left' | 'right' */ get() = definedExternally; set(value) = definedExternally
    var content: String
    var end: dynamic /* Date | Number | String */ get() = definedExternally; set(value) = definedExternally
    var group: dynamic /* String | Number */ get() = definedExternally; set(value) = definedExternally
    var id: dynamic /* String | Number */
    var start: dynamic /* Date | Number | String */
    var style: String? get() = definedExternally; set(value) = definedExternally
    var subgroup: dynamic /* String | Number */ get() = definedExternally; set(value) = definedExternally
    var title: String? get() = definedExternally; set(value) = definedExternally
    var type: dynamic /* 'box' | 'point' | 'range' | 'background' */ get() = definedExternally; set(value) = definedExternally
    var editable: dynamic /* Boolean | TimelineItemEditableOption */ get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface TimelineGroup {
    var className: String? get() = definedExternally; set(value) = definedExternally
    var content: dynamic /* String | HTMLElement */
    var id: dynamic /* String | Number */
    var style: String? get() = definedExternally; set(value) = definedExternally
    var subgroupOrder: dynamic /* String | TimelineOptionsComparisonFunction */ get() = definedExternally; set(value) = definedExternally
    var title: String? get() = definedExternally; set(value) = definedExternally
    var visible: Boolean? get() = definedExternally; set(value) = definedExternally
    var nestedGroups: Array<dynamic /* String | Number */>? get() = definedExternally; set(value) = definedExternally
    var showNested: Boolean? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface VisSelectProperties {
    var items: Array<Number>
}

// @JsModule("vis") @JsNonModule
external interface `T$5` {
    @nativeGetter
    operator fun get(nodeId: String): Position?
    @nativeSetter
    operator fun set(nodeId: String, value: Position)
}

// @JsModule("vis") @JsNonModule
external interface `T$6` {
    var fromId: dynamic /* String | Number */
    var toId: dynamic /* String | Number */
}

// @JsModule("vis") @JsNonModule
external interface `T$7` {
    var nodes: Array<dynamic /* String | Number */>
    var edges: Array<dynamic /* String | Number */>
}

// @JsModule("vis") @JsNonModule
external open class Network(container: HTMLElement, data: Data, options: Options? = definedExternally /* null */) {
    open fun destroy(): Unit
    open fun setData(data: Data): Unit
    open fun setOptions(options: Options): Unit
    open fun on(eventName: dynamic /* 'click' | 'doubleClick' | 'oncontext' | 'hold' | 'release' | 'select' | 'selectNode' | 'selectEdge' | 'deselectNode' | 'deselectEdge' | 'dragStart' | 'dragging' | 'dragEnd' | 'hoverNode' | 'blurNode' | 'hoverEdge' | 'blurEdge' | 'zoom' | 'showPopup' | 'hidePopup' | 'startStabilizing' | 'stabilizationProgress' | 'stabilizationIterationsDone' | 'stabilized' | 'resize' | 'initRedraw' | 'beforeDrawing' | 'afterDrawing' | 'animationFinished' | 'configChange' */, callback: (params: Any? /*= null*/) -> Unit): Unit
    open fun off(eventName: dynamic /* 'click' | 'doubleClick' | 'oncontext' | 'hold' | 'release' | 'select' | 'selectNode' | 'selectEdge' | 'deselectNode' | 'deselectEdge' | 'dragStart' | 'dragging' | 'dragEnd' | 'hoverNode' | 'blurNode' | 'hoverEdge' | 'blurEdge' | 'zoom' | 'showPopup' | 'hidePopup' | 'startStabilizing' | 'stabilizationProgress' | 'stabilizationIterationsDone' | 'stabilized' | 'resize' | 'initRedraw' | 'beforeDrawing' | 'afterDrawing' | 'animationFinished' | 'configChange' */, callback: ((params: Any? /*= null*/) -> Unit)? = definedExternally /* null */): Unit
    open fun once(eventName: dynamic /* 'click' | 'doubleClick' | 'oncontext' | 'hold' | 'release' | 'select' | 'selectNode' | 'selectEdge' | 'deselectNode' | 'deselectEdge' | 'dragStart' | 'dragging' | 'dragEnd' | 'hoverNode' | 'blurNode' | 'hoverEdge' | 'blurEdge' | 'zoom' | 'showPopup' | 'hidePopup' | 'startStabilizing' | 'stabilizationProgress' | 'stabilizationIterationsDone' | 'stabilized' | 'resize' | 'initRedraw' | 'beforeDrawing' | 'afterDrawing' | 'animationFinished' | 'configChange' */, callback: (params: Any? /*= null*/) -> Unit): Unit
    open fun canvasToDOM(position: Position): Position
    open fun DOMtoCanvas(position: Position): Position
    open fun redraw(): Unit
    open fun setSize(width: String, height: String): Unit
    open fun cluster(options: ClusterOptions? = definedExternally /* null */): Unit
    open fun clusterByConnection(nodeId: String, options: ClusterOptions? = definedExternally /* null */): Unit
    open fun clusterByHubsize(hubsize: Number? = definedExternally /* null */, options: ClusterOptions? = definedExternally /* null */): Unit
    open fun clusterOutliers(options: ClusterOptions? = definedExternally /* null */): Unit
    open fun findNode(nodeId: String): Array<dynamic /* String | Number */>
    open fun findNode(nodeId: Number): Array<dynamic /* String | Number */>
    open fun getClusteredEdges(baseEdgeId: String): Array<dynamic /* String | Number */>
    open fun getClusteredEdges(baseEdgeId: Number): Array<dynamic /* String | Number */>
    open fun getBaseEdge(clusteredEdgeId: String): dynamic /* String | Number */
    open fun getBaseEdge(clusteredEdgeId: Number): dynamic /* String | Number */
    open fun updateEdge(startEdgeId: String, options: EdgeOptions? = definedExternally /* null */): Unit
    open fun updateEdge(startEdgeId: Number, options: EdgeOptions? = definedExternally /* null */): Unit
    open fun updateClusteredNode(clusteredNodeId: String, options: NodeOptions? = definedExternally /* null */): Unit
    open fun updateClusteredNode(clusteredNodeId: Number, options: NodeOptions? = definedExternally /* null */): Unit
    open fun isCluster(nodeId: String): Boolean
    open fun isCluster(nodeId: Number): Boolean
    open fun getNodesInCluster(clusterNodeId: String): Array<dynamic /* String | Number */>
    open fun getNodesInCluster(clusterNodeId: Number): Array<dynamic /* String | Number */>
    open fun openCluster(nodeId: String, options: OpenClusterOptions? = definedExternally /* null */): Unit
    open fun openCluster(nodeId: Number, options: OpenClusterOptions? = definedExternally /* null */): Unit
    open fun getSeed(): Number
    open fun enableEditMode(): Unit
    open fun disableEditMode(): Unit
    open fun addNodeMode(): Unit
    open fun editNode(): Unit
    open fun addEdgeMode(): Unit
    open fun editEdgeMode(): Unit
    open fun deleteSelected(): Unit
    open fun getPositions(nodeIds: Array<dynamic /* String | Number */>? = definedExternally /* null */): `T$5`
    open fun getPositions(nodeId: String): Position
    open fun getPositions(nodeId: Number): Position
    open fun storePositions(): Unit
    open fun moveNode(nodeId: String, x: Number, y: Number): Unit
    open fun moveNode(nodeId: Number, x: Number, y: Number): Unit
    open fun getBoundingBox(nodeId: String): BoundingBox
    open fun getBoundingBox(nodeId: Number): BoundingBox
    open fun getConnectedNodes(nodeOrEdgeId: String): dynamic /* Array<dynamic /* String | Number */> | Array<`T$6`> */
    open fun getConnectedNodes(nodeOrEdgeId: Number): dynamic /* Array<dynamic /* String | Number */> | Array<`T$6`> */
    open fun getConnectedEdges(nodeId: String): Array<dynamic /* String | Number */>
    open fun getConnectedEdges(nodeId: Number): Array<dynamic /* String | Number */>
    open fun startSimulation(): Unit
    open fun stopSimulation(): Unit
    open fun stabilize(iterations: Number? = definedExternally /* null */): Unit
    open fun getSelection(): `T$7`
    open fun getSelectedNodes(): Array<dynamic /* String | Number */>
    open fun getSelectedEdges(): Array<dynamic /* String | Number */>
    open fun getNodeAt(position: Position): dynamic /* String | Number */
    open fun getEdgeAt(position: Position): dynamic /* String | Number */
    open fun selectNodes(nodeIds: Array<dynamic /* String | Number */>, highlightEdges: Boolean? = definedExternally /* null */): Unit
    open fun selectEdges(edgeIds: Array<dynamic /* String | Number */>): Unit
    open fun setSelection(selection: `T$7`, options: SelectionOptions? = definedExternally /* null */): Unit
    open fun unselectAll(): Unit
    open fun getScale(): Number
    open fun getViewPosition(): Position
    open fun fit(options: FitOptions? = definedExternally /* null */): Unit
    open fun focus(nodeId: String, options: FocusOptions? = definedExternally /* null */): Unit
    open fun focus(nodeId: Number, options: FocusOptions? = definedExternally /* null */): Unit
    open fun moveTo(options: MoveToOptions): Unit
    open fun releaseNode(): Unit
    open fun getOptionsFromConfigurator(): Any
}

// @JsModule("vis") @JsNonModule
external interface FocusOptions : ViewPortOptions {
    var locked: Boolean? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface ViewPortOptions {
    var scale: Number? get() = definedExternally; set(value) = definedExternally
    var offset: Position? get() = definedExternally; set(value) = definedExternally
    var animation: dynamic /* AnimationOptions | Boolean */ get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface MoveToOptions : ViewPortOptions {
    var position: Position? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface AnimationOptions {
    var duration: Number
    var easingFunction: dynamic /* 'linear' | 'easeInQuad' | 'easeOutQuad' | 'easeInOutQuad' | 'easeInCubic' | 'easeOutCubic' | 'easeInOutCubic' | 'easeInQuart' | 'easeOutQuart' | 'easeInOutQuart' | 'easeInQuint' | 'easeOutQuint' | 'easeInOutQuint' */
}

// @JsModule("vis") @JsNonModule
external interface FitOptions {
    var nodes: Array<String>? get() = definedExternally; set(value) = definedExternally
    var animation: dynamic /* Boolean | AnimationOptions */
}

// @JsModule("vis") @JsNonModule
external interface SelectionOptions {
    var unselectAll: Boolean? get() = definedExternally; set(value) = definedExternally
    var highlightEdges: Boolean? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface BoundingBox {
    var top: Number
    var left: Number
    var right: Number
    var bottom: Number
}

// @JsModule("vis") @JsNonModule
external interface ClusterOptions {
    val joinCondition: ((nodeOptions: Any) -> Boolean)? get() = definedExternally
    val processProperties: ((clusterOptions: Any, childNodesOptions: Array<Any>, childEdgesOptions: Array<Any>) -> Any)? get() = definedExternally
    var clusterNodeProperties: NodeOptions? get() = definedExternally; set(value) = definedExternally
    var clusterEdgeProperties: EdgeOptions? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface OpenClusterOptions {
    fun releaseFunction(clusterPosition: Position, containedNodesPositions: `T$5`): `T$5`
}

// @JsModule("vis") @JsNonModule
external interface Position {
    var x: Number
    var y: Number
}

// @JsModule("vis") @JsNonModule
external interface `T$8` {
    var DOM: Position
    var canvas: Position
}

// @JsModule("vis") @JsNonModule
external interface `T$9` {
    var nodes: Array<String>
    var edges: Array<String>
}

// @JsModule("vis") @JsNonModule
external interface Properties {
    var nodes: Array<String>
    var edges: Array<String>
    var event: Array<String>
    var pointer: `T$8`
    var previousSelection: `T$9`? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface Callback {
    val callback: ((params: Any? /*= null*/) -> Unit)? get() = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface Data {
    var nodes: dynamic /* Array<Node> | DataSet<Node> */ get() = definedExternally; set(value) = definedExternally
    var edges: dynamic /* Array<Edge> | DataSet<Edge> */ get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface Node {
    var group: String? get() = definedExternally; set(value) = definedExternally
    var id: dynamic /* String | Number */ get() = definedExternally; set(value) = definedExternally
    var label: String? get() = definedExternally; set(value) = definedExternally
    var x: Number? get() = definedExternally; set(value) = definedExternally
    var y: Number? get() = definedExternally; set(value) = definedExternally
    var fixed: Boolean? get() = definedExternally; set(value) = definedExternally
    var image: String? get() = definedExternally; set(value) = definedExternally
    var shape: String? get() = definedExternally; set(value) = definedExternally
    var color: dynamic /* String | Color */ get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface Edge {
    var from: dynamic /* String | Number */ get() = definedExternally; set(value) = definedExternally
    var to: dynamic /* String | Number */ get() = definedExternally; set(value) = definedExternally
    var id: dynamic /* String | Number */ get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface Locales {
    @nativeGetter
    operator fun get(language: String): LocaleMessages?
    @nativeSetter
    operator fun set(language: String, value: LocaleMessages?)
    var en: LocaleMessages? get() = definedExternally; set(value) = definedExternally
    var cn: LocaleMessages? get() = definedExternally; set(value) = definedExternally
    var de: LocaleMessages? get() = definedExternally; set(value) = definedExternally
    var es: LocaleMessages? get() = definedExternally; set(value) = definedExternally
    var it: LocaleMessages? get() = definedExternally; set(value) = definedExternally
    var nl: LocaleMessages? get() = definedExternally; set(value) = definedExternally
//    var `pt-br`: LocaleMessages? get() = definedExternally; set(value) = definedExternally
    var ru: LocaleMessages? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface LocaleMessages {
    var edit: String
    var del: String
    var back: String
    var addNode: String
    var addEdge: String
    var editNode: String
    var editEdge: String
    var addDescription: String
    var edgeDescription: String
    var editEdgeDescription: String
    var createEdgeError: String
    var deleteClusterError: String
    var editClusterError: String
}

// @JsModule("vis") @JsNonModule
external interface Options {
    var autoResize: Boolean? get() = definedExternally; set(value) = definedExternally
    var width: String? get() = definedExternally; set(value) = definedExternally
    var height: String? get() = definedExternally; set(value) = definedExternally
    var locale: String? get() = definedExternally; set(value) = definedExternally
    var locales: Locales? get() = definedExternally; set(value) = definedExternally
    var clickToUse: Boolean? get() = definedExternally; set(value) = definedExternally
    var configure: Any? get() = definedExternally; set(value) = definedExternally
    var edges: EdgeOptions? get() = definedExternally; set(value) = definedExternally
    var nodes: NodeOptions? get() = definedExternally; set(value) = definedExternally
    var groups: Any? get() = definedExternally; set(value) = definedExternally
    var layout: Any? get() = definedExternally; set(value) = definedExternally
    var interaction: Any? get() = definedExternally; set(value) = definedExternally
    var manipulation: Any? get() = definedExternally; set(value) = definedExternally
    var physics: Any? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface `T$10` {
    var border: String? get() = definedExternally; set(value) = definedExternally
    var background: String? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface Color {
    var border: String? get() = definedExternally; set(value) = definedExternally
    var background: String? get() = definedExternally; set(value) = definedExternally
    var highlight: dynamic /* String | `T$10` */ get() = definedExternally; set(value) = definedExternally
    var hover: dynamic /* String | `T$10` */ get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface `T$11` {
    var x: Boolean? get() = definedExternally; set(value) = definedExternally
    var y: Boolean? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface `T$12` {
    var color: String? get() = definedExternally; set(value) = definedExternally
    var size: Number? get() = definedExternally; set(value) = definedExternally
    var face: String? get() = definedExternally; set(value) = definedExternally
    var background: String? get() = definedExternally; set(value) = definedExternally
    var strokeWidth: Number? get() = definedExternally; set(value) = definedExternally
    var strokeColor: String? get() = definedExternally; set(value) = definedExternally
    var align: String? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface `T$13` {
    var face: String? get() = definedExternally; set(value) = definedExternally
    var code: String? get() = definedExternally; set(value) = definedExternally
    var size: Number? get() = definedExternally; set(value) = definedExternally
    var color: String? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface `T$14` {
    var borderDashes: dynamic /* Boolean | Array<Number> */
    var borderRadius: Number
    var interpolation: Boolean
    var useImageSize: Boolean
    var useBorderWithImage: Boolean
}

// @JsModule("vis") @JsNonModule
external interface NodeOptions {
    var borderWidth: Number? get() = definedExternally; set(value) = definedExternally
    var borderWidthSelected: Number? get() = definedExternally; set(value) = definedExternally
    var brokenImage: String? get() = definedExternally; set(value) = definedExternally
    var color: Color? get() = definedExternally; set(value) = definedExternally
    var fixed: dynamic /* Boolean | `T$11` */ get() = definedExternally; set(value) = definedExternally
    var font: dynamic /* String | `T$12` */ get() = definedExternally; set(value) = definedExternally
    var group: String? get() = definedExternally; set(value) = definedExternally
    var hidden: Boolean? get() = definedExternally; set(value) = definedExternally
    var icon: `T$13`? get() = definedExternally; set(value) = definedExternally
    var id: String? get() = definedExternally; set(value) = definedExternally
    var image: String? get() = definedExternally; set(value) = definedExternally
    var label: String? get() = definedExternally; set(value) = definedExternally
    var labelHighlightBold: Boolean? get() = definedExternally; set(value) = definedExternally
    var level: Number? get() = definedExternally; set(value) = definedExternally
    var mass: Number? get() = definedExternally; set(value) = definedExternally
    var physics: Boolean? get() = definedExternally; set(value) = definedExternally
    var scaling: OptionsScaling? get() = definedExternally; set(value) = definedExternally
    var shadow: dynamic /* Boolean | OptionsShadow */ get() = definedExternally; set(value) = definedExternally
    var shape: String? get() = definedExternally; set(value) = definedExternally
    var shapeProperties: `T$14`? get() = definedExternally; set(value) = definedExternally
    var size: Number? get() = definedExternally; set(value) = definedExternally
    var title: String? get() = definedExternally; set(value) = definedExternally
    var value: Number? get() = definedExternally; set(value) = definedExternally
    var x: Number? get() = definedExternally; set(value) = definedExternally
    var y: Number? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface `T$15` {
    var enabled: Boolean? get() = definedExternally; set(value) = definedExternally
    var scaleFactor: Number? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface `T$16` {
    var to: dynamic /* Boolean | `T$15` */ get() = definedExternally; set(value) = definedExternally
    var middle: dynamic /* Boolean | `T$15` */ get() = definedExternally; set(value) = definedExternally
    var from: dynamic /* Boolean | `T$15` */
}

// @JsModule("vis") @JsNonModule
external interface `T$17` {
    var color: String? get() = definedExternally; set(value) = definedExternally
    var highlight: String? get() = definedExternally; set(value) = definedExternally
    var hover: String? get() = definedExternally; set(value) = definedExternally
    var inherit: dynamic /* Boolean | String */ get() = definedExternally; set(value) = definedExternally
    var opacity: Number? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface `T$18` {
    var enabled: Boolean
    var type: String
    var forceDirection: dynamic /* String | Boolean */ get() = definedExternally; set(value) = definedExternally
    var roundness: Number
}

// @JsModule("vis") @JsNonModule
external interface EdgeOptions {
    var arrows: dynamic /* String | `T$16` */ get() = definedExternally; set(value) = definedExternally
    var arrowStrikethrough: Boolean? get() = definedExternally; set(value) = definedExternally
    var color: dynamic /* String | `T$17` */ get() = definedExternally; set(value) = definedExternally
    var dashes: dynamic /* Boolean | Array<Number> */ get() = definedExternally; set(value) = definedExternally
    var font: dynamic /* String | `T$12` */ get() = definedExternally; set(value) = definedExternally
    var from: dynamic /* Number | String */ get() = definedExternally; set(value) = definedExternally
    var hidden: Boolean? get() = definedExternally; set(value) = definedExternally
    var hoverWidth: Number? get() = definedExternally; set(value) = definedExternally
    var id: String? get() = definedExternally; set(value) = definedExternally
    var label: String? get() = definedExternally; set(value) = definedExternally
    var labelHighlightBold: Boolean? get() = definedExternally; set(value) = definedExternally
    var length: Number? get() = definedExternally; set(value) = definedExternally
    var physics: Boolean? get() = definedExternally; set(value) = definedExternally
    var scaling: OptionsScaling? get() = definedExternally; set(value) = definedExternally
    var selectionWidth: Number? get() = definedExternally; set(value) = definedExternally
    var selfReferenceSize: Number? get() = definedExternally; set(value) = definedExternally
    var shadow: dynamic /* Boolean | OptionsShadow */ get() = definedExternally; set(value) = definedExternally
    var smooth: dynamic /* Boolean | `T$18` */ get() = definedExternally; set(value) = definedExternally
    var title: String? get() = definedExternally; set(value) = definedExternally
    var to: dynamic /* Number | String */ get() = definedExternally; set(value) = definedExternally
    var value: Number? get() = definedExternally; set(value) = definedExternally
    var width: Number? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface `T$19` {
    var enabled: Boolean? get() = definedExternally; set(value) = definedExternally
    var min: Number? get() = definedExternally; set(value) = definedExternally
    var max: Number? get() = definedExternally; set(value) = definedExternally
    var maxVisible: Number? get() = definedExternally; set(value) = definedExternally
    var drawThreshold: Number? get() = definedExternally; set(value) = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface OptionsScaling {
    var min: Number? get() = definedExternally; set(value) = definedExternally
    var max: Number? get() = definedExternally; set(value) = definedExternally
    var label: dynamic /* Boolean | `T$19` */ get() = definedExternally; set(value) = definedExternally
    val customScalingFunction: ((min: Number? /*= null*/, max: Number? /*= null*/, total: Number? /*= null*/, value: Number? /*= null*/) -> Number)? get() = definedExternally
}

// @JsModule("vis") @JsNonModule
external interface OptionsShadow {
    var enabled: Boolean
    var color: String
    var size: Number
    var x: Number
    var y: Number
}