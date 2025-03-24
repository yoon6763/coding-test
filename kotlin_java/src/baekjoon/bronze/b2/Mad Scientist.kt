package baekjoon.bronze.b2

fun main() {
    while (true) {
        val input = readln().split(" ").map { it.toInt() }.apply { if (this[0] == 0) return }

        val k = input[0]
        val pSequence = input.subList(1, input.size)

        val result = mutableListOf<Int>()
        var pre = 0

        repeat(k) { i ->
            val count = pSequence[i] - pre
            result.addAll(List(count) { i + 1 })
            pre = pSequence[i]
        }

        println(result.joinToString(" "))
    }
}
