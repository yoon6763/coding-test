package goormlevel.lv1.`의좋은 형제`

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var (a, b) = readLine().split(" ").map { it.toInt() }

    val day = readLine().toInt()
    repeat(day) {
        if (it % 2 == 1) {
            a += (b / 2 + if (b % 2 == 0) 0 else 1)
            b = b / 2
        } else {
            b += (a / 2 + if (a % 2 == 0) 0 else 1)
            a = a / 2
        }
    }
    println("$a $b")
}