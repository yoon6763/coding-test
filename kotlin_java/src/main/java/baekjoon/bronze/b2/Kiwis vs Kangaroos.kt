package baekjoon.bronze.b2

fun main() {
    val kangarooKey = "KANGAROO"
    val kiwiKey = "KIWIBIRD"

    val input = readln().lowercase()

    val kangarooScore = input.sumOf { ch ->
        kangarooKey.count { it.equals(ch, ignoreCase = true) }
    }

    val kiwiScore = input.sumOf { ch ->
        kiwiKey.count { it.equals(ch, ignoreCase = true) }
    }

    println(
        when {
            kangarooScore > kiwiScore -> "Kangaroos"
            kiwiScore > kangarooScore -> "Kiwis"
            else -> "Feud continues"
        }
    )
}