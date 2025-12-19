package baekjoon.bronze.b5

fun main() {
    val map = mapOf(
        "animal" to "Panthera tigris",
        "tree" to "Pinus densiflora",
        "flower" to "Forsythia koreana"
    )

    while (true) {
        val input = readln()
        if (input == "end") break
        println(map[input])
    }
}
