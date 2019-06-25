import kotlin.properties.Delegates
import kotlin.reflect.typeOf

@UseExperimental(ExperimentalStdlibApi::class)
fun main() {
    val t = typeOf<MutableList<Int?>?>()
    println(t.arguments)
    println(t.isMarkedNullable)
}
