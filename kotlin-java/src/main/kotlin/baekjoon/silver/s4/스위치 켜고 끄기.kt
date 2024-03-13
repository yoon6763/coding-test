package baekjoon.silver.s4

fun main() {
    val n = readln().toInt()
    val switch = readln().split(" ").map { it == "1" }.toTypedArray()

    repeat(readln().toInt()) {
        val (gender, number) = readln().split(" ").map { it.toInt() }

        if (gender == 1) {
            for (i in 0..<n) {
                if ((i + 1) % number == 0) {
                    switch[i] = !switch[i]
                }
            }
        } else {
            var left = number - 1
            var right = number - 1
            while (left - 1 >= 0 && right + 1 < n) {
                if (switch[left - 1] == switch[right + 1]) {
                    left--
                    right++
                } else {
                    break
                }
            }
            for (i in left..right) {
                switch[i] = !switch[i]
            }
        }
    }

    val sb = StringBuilder()
    for (i in 0..<n) {
        sb.append(if (switch[i]) "1 " else "0 ")
        if ((i + 1) % 20 == 0) {
            sb.append("\n")
        }
    }
    println(sb)
}