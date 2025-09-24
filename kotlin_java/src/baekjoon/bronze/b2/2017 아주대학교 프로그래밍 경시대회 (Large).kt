package baekjoon.bronze.b2

fun main() {
    val list = List(readln().toInt()) { readln().split(" ").map { it.toInt() } }

    println(
        list.indexOf(
            list.sortedWith(compareByDescending<List<Int>> { it[0] }.thenBy { it[1] }
                .thenBy { it[2] })[0]
        ) + 1
    )
}
