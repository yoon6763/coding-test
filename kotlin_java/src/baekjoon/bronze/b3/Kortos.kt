package baekjoon.bronze.b3

fun main() {
    val map = mutableMapOf<Char, BooleanArray>().let { map -> "SBVK".forEach { map[it] = BooleanArray(13) }; map }

    repeat(51) {
        val (a, b) = readln().split(" ")
        map[a[0]]!![b.toInt() - 1] = true
    }

    map.forEach { (k, v) -> v.forEachIndexed { i, b -> if (!b) print("$k ${i + 1}") } }
}
