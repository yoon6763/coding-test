package baekjoon.bronze.b2

    fun main() {
        repeat(readln().toInt()) {
            val str = readln()
            println(
                if (str.length == 7 && str.toCharArray().toSet().size == 2 &&
                    str[0] == str[1] && str[1] == str[4] && str[2] == str[3] && str[5] == str[6] && str[0] == str[4]
                ) "1" else "0"
            )
        }
    }