package baekjoon.silver.s5

fun main() {
    val nk = readLine()!!.split(" ")
    val n = nk[0].toInt()
    var k = nk[1].toInt()

    var idx = k - 1

    val arr = ArrayList<Int>()
    for(i in 0 until n) {
        arr.add(i)
    }

    var result = "<"

    while(arr.isNotEmpty()) {
        while(idx >= arr.size) {
            idx -= arr.size
        }
        result += "${arr.removeAt(idx) + 1}, "
        idx = idx + k - 1
    }
    result = result.substring(0, result.length - 2)
    result += ">"
    print(result)
}