package baekjoon.bronze.b2

fun main() {
    outer@ while (true) {
        val sb = StringBuilder()

        for (c in readln().apply { if (this == "#") return }) {
            if (c !in "bdpqiovwx") {
                println("INVALID")
                continue@outer
            } else {
                sb.append(mapOf('b' to 'd', 'd' to 'b', 'p' to 'q', 'q' to 'p')[c] ?: c)
            }
        }

        println(sb.reversed())
    }
}
