package baekjoon.bronze.b1

fun main() = repeat(readln().toInt()) {
    val s = readln()
    val end1 = s.substring(s.length - 1)
    val end2 = if (s.length > 1) s.substring(s.length - 2) else ""

    when {
        end1 == "a" -> println("${s}s")
        end1 == "i" || end1 == "y" -> println("${s.substring(0, s.length - 1)}ios")
        end1 == "l" -> println("${s}es")
        end1 == "n" -> println("${s.substring(0, s.length - 1)}anes")
        end2 == "ne" -> println("${s.substring(0, s.length - 2)}anes")
        end1 == "o" -> println("${s}s")
        end1 == "r" -> println("${s}es")
        end1 == "t" -> println("${s}as")
        end1 == "u" -> println("${s}s")
        end1 == "v" -> println("${s}es")
        end1 == "w" -> println("${s}as")
        else -> println("${s}us")
    }
}