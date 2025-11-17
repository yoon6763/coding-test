package goormlevel.lv2.`어려운 문제`

fun main() {
    val n = readLine()!!.toInt()

    if (n == 0) {
        println(1)
        return
    }

    val arr = LongArray(n + 1)
    arr[0] = 1L
    arr[1] = 1L

    for (i in 2..n) {
        arr[i] = arr[i - 1] * i.toLong()

        while (arr[i] >= 10) {
            var temp = 0L
            while (arr[i] > 0) {
                temp += arr[i] % 10L
                arr[i] /= 10L
            }
            arr[i] = temp
        }
    }

    println(arr[n])
}