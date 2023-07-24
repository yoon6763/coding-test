package baekjoon.silver.s4

fun main() = with(System.`in`.bufferedReader()) {
    var cnt = 0
    var hashSet = HashSet<String>()

    repeat(readLine().toInt()) {
        val str = readLine()
        if (str == "ENTER") hashSet = HashSet()
        else {
            if (!hashSet.contains(str)) {
                cnt++
                hashSet.add(str)
            }
        }
    }
    println(cnt)
}