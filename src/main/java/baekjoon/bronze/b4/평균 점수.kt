package baekjoon.bronze.b4

fun main(args: Array<String>) {
    var arr = Array<Int>(5) { _ -> 0 }
    arr[0] = readLine()!!.toInt()
    arr[1] = readLine()!!.toInt()
    arr[2] = readLine()!!.toInt()
    arr[3] = readLine()!!.toInt()
    arr[4] = readLine()!!.toInt()
    var result = 0
    for (i in arr) {
        result += if (i < 40)
            40
        else
            i
    }
    print(result / 5)
}
