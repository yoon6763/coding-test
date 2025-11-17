package baekjoon.bronze.b1


fun main() {
    var n = readLine()!!.toInt()
    val sb = StringBuilder()

    var cnt = 2
    while (n > 1) {
        // 나누어 떨어질 때
        if (n % cnt == 0) {
            sb.append(cnt).append("\n")
            n /= cnt
        } else {
            // 나누어 떨어지지 않을 때
            cnt++
        }
    }

    print(sb)
}