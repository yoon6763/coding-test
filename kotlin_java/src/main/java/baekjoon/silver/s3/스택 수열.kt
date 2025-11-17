package baekjoon.silver.s3

fun main() {
    val n = readLine()!!.toInt()

    val stack = ArrayList<Int>()
    var cnt = 1
    var sb = StringBuilder()
    var success = true

    for(i in 0 until n) {
        val input = readLine()!!.toInt()

        while (input >= cnt) {
            stack.add(cnt++)
            sb.append("+").append("\n")
        }

        if(stack.last() == input) {
            sb.append("-").append("\n")
            stack.removeLast()
        } else {
            print("NO")
            success = false
            break
        }
    }

    if(success) print(sb)
}