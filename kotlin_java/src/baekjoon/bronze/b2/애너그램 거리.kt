package baekjoon.bronze.b2

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val count1 = IntArray(26)
        val count2 = IntArray(26)

        readLine().forEach {
            count1[it - 'a']++
        }
        readLine().forEach {
            count2[it - 'a']++
        }

        var count = 0
        for (i in 0..<26) {
            count += Math.abs(count1[i] - count2[i])
        }
        sb.appendLine("Case #${it + 1}: $count")
    }
    print(sb)
}