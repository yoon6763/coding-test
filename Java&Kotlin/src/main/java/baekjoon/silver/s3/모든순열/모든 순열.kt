package baekjoon.silver.s3.모든순열

lateinit var nums: Array<Boolean>
val sb = StringBuilder()
var n = 0

fun main() {
    n = readln().toInt()
    nums = Array(n) { false }

    backTracking("", 0)
    print(sb)
}

fun backTracking(str: String, depth: Int) {
    if (depth == n) {
        sb.append("$str\n")
        return
    }

    for (i in 0 until n) {
        if (!nums[i]) {
            nums[i] = true
            backTracking("$str ${i + 1}".trim(), depth + 1)
            nums[i] = false
        }
    }
}