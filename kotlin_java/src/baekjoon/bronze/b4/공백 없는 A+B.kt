package baekjoon.bronze.b4

fun main() {
    val n = readln()
    when (n.length) {
        2 -> {
            println(n[0].digitToInt() + n[1].digitToInt())
        }

        3 -> {
            if(n[1] == '0') {
                println(10 + n[2].digitToInt())
            } else {
                println(n[0].digitToInt() + 10)
            }
        }

        else -> {
            println(n.substring(0, 2).toInt() + n.substring(2, 4).toInt())
        }
    }
}