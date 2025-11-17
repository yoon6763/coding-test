package baekjoon.bronze.b2

fun main() {
    while (true) {
        val line = readln()
        if (line == "0") break
        var (right, remove) = line.split(" ").map { it.toInt() }
        val pages = mutableListOf<List<Int>>()
        var left = 1
        repeat(right / 4) { pages.add(listOf(left++, right--, left++, right--).sorted()) }

        for (page in pages) {
            if (remove in page) {
                println(page.filter { it != remove }.joinToString(" "))
                break
            }
        }
    }
}