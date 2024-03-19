package baekjoon.bronze.b1

fun main() {
    repeat(readln().toInt()) {
        var cnt = 0
        var s = readln()
        while (true) {
            if (s == "6174") {
                println(cnt)
                break
            }
            val a = s.toCharArray().sortedDescending().joinToString("").toInt()
            val b = s.toCharArray().sorted().joinToString("").toInt()
            s = (a - b).toString().padStart(4, '0')
            cnt++
        }
    }
}