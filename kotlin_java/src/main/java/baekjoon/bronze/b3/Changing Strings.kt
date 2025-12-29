package baekjoon.bronze.b3

fun main() {
    val s = readln()

    val leftU = s.indexOf('U')
    val rightF = s.lastIndexOf('F')

    val ans = StringBuilder()

    for (i in s.indices) {
        when {
            i < leftU -> ans.append('-')
            i > rightF -> ans.append('-')
            i == leftU -> ans.append('U')
            i == rightF -> ans.append('F')
            else -> ans.append('C')
        }
    }

    println(ans)
}
