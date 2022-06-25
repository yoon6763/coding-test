package baekjoon.silver.s5

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    var bit = 0
    val sb = StringBuilder()

    repeat(n) {
        val input = br.readLine().split(" ")
        var num = 0
        if (input[0] != "all" && input[0] != "empty")
            num = input[1].toInt()

        when (input[0]) {
            "add" -> {
                bit = bit or (1 shl num - 1)
            }
            "remove" -> {
                bit = bit and (1 shl num - 1).inv()
            }
            "check" -> {
                val temp: Int = bit and (1 shl num - 1)
                sb.append(if (temp != 0) "1" else "0").append("\n")
            }
            "toggle" -> {
                bit = bit xor (1 shl num - 1)
            }
            "all" -> bit = bit or 0.inv()
            "empty" -> bit = 0
        }
    }
    println(sb.toString())
}

/*
add 1
add 2
check 1   1
check 2   1
check 3   0
remove 2    (1)
check 1   1
check 2   0
toggle 3  (1,3)
check 1   1
check 2   0
check 3   1
check 4   0
all       (1~20)
check 10  1
check 20  1
toggle 10  (1~20, 10없음)
remove 20  (1~19, 10없음)
check 10   0
check 20   0
empty      ()
check 1    0
toggle 1   (1)
check 1    1
toggle 1   ()
check 1    0

1
1
0
1
0
1
0
1
0
1
1
0
0
0
1
 */