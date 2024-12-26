package baekjoon.bronze.b2

fun main() {
    while (true) {
        val line = readln().apply { if (this == "#") return }
        val (w1, w2, w3) = line.split(" ")

        val list = w1.zip(w2).map { (c1, c2) ->
            val c1index = c1.code
            val c2index = c2.code
            if (c1index <= c2index) c2index - c1index else 'z'.code - c1index + c2index - 'a'.code + 1
        }

        val parsed = w3.mapIndexed { idx, c ->
            (c.code + list[idx]).let { if (it > 'z'.code) (it % 'z'.code) + 'a'.code - 1 else it }.toChar()
        }.joinToString("")

        println("$w1 $w2 $w3 $parsed")
    }
}
