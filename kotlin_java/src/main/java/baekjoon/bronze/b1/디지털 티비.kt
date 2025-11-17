package baekjoon.bronze.b1

fun main() {
    val n = readln().toInt()
    val arr = Array(n) { readln() }
    val sb = StringBuilder()

    var temp = arr[0]
    var ptr = 0

    while (true) {
        if (temp == "KBS1") {
            for (i in ptr downTo 1) {
                arr[i] = arr[i - 1].also { arr[i - 1] = temp }
                sb.append("4")
            }
            break
        }
        if (ptr + 1 < arr.size) {
            sb.append("1")
            temp = arr[++ptr]
        } else {
            break
        }
    }

    temp = arr[0]
    ptr = 0

    while (true) {
        if (temp == "KBS2") {
            for (i in ptr downTo 2) {
                arr[i] = arr[i - 1].also { arr[i - 1] = temp }
                sb.append("4")
            }
            break
        }
        if (ptr + 1 < arr.size) {
            sb.append("1")
            temp = arr[++ptr]
        } else {
            break
        }
    }

    println(sb)
}
