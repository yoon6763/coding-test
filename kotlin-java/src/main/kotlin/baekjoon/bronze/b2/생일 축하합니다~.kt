package baekjoon.bronze.b2

fun main() = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()
    val n = readLine().toInt()
    val names = Array(n) { readLine() }

    for (i in 0 until n) {
        bw.write("? ${names[i]}\n")
        bw.flush()
        val answer1 = readLine().toInt()

        if (answer1 == 1) {
            bw.write("! ${names[i]}\n")
            bw.flush()
            break
        }

        bw.write("? ${names[i]}\n")
        bw.flush()
        val answer2 = readLine().toInt()

        if (answer2 == 1) {
            bw.write("! ${names[i]}\n")
            bw.flush()
            break
        }
    }
}