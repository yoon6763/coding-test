package baekjoon.silver.s3

fun main() {
    val input = readLine()!!.split(" ")
    var start = input[0].toInt()
    val end = input[1].toInt()

    var arr = Array(1000001) { false }

    for (i in 2..end) {
        var j = 2
        while (j * i <= end) {
            arr[i * j] = true
            j++
        }
    }

    if(start == 1) start++

    for(i in start..end)
        if(!arr[i])
            println(i)
}