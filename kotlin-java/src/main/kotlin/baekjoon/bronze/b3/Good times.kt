package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()

    val getTime: (Int) -> Int = { time ->
        var ctime = time

        if (ctime % 100 > 59) {
            ctime += 100
            ctime -= 60
        }

        if (ctime % 100 < -59) {
            ctime -= 100
            ctime += 60
        }

        if (time < 0) ctime = 2400 + time
        if (ctime > 2399) ctime %= 2400
        ctime
    }

    println("$n in Ottawa")
    println("${getTime(n - 300)} in Victoria")
    println("${getTime(n - 200)} in Edmonton")
    println("${getTime(n - 100)} in Winnipeg")
    println("$n in Toronto")
    println("${getTime(n + 100)} in Halifax")
    println("${getTime(n + 130)} in St. John's")
}