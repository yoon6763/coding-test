package baekjoon.bronze.b1


fun main() {
    var n = readLine()!!.toInt()
    val sb = StringBuilder()

    var cnt = 2
    while (n > 1) {
        if (n % cnt == 0) {
            sb.append(cnt).append("\n")
            n /= cnt
        } else {
            cnt++
        }
    }

    print(sb)
}