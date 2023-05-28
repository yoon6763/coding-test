package baekjoon.gold.g5.감소하는수

var n = 0
val arr = ArrayList<Int>()
val result = ArrayList<Long>()

fun main() {
    n = readln().toInt()

    backTracking(0)
    result.sort()
    if (n > 1023) {
        println(-1)
    } else {
        println(result[n])
    }
}

fun backTracking(depth: Int) {

    for (i in 0..9) {
        if (arr.isEmpty() || (i !in arr && arr.last() < i)) {
            arr.add(i)
            val sb = StringBuilder()
            for (j in arr.size - 1 downTo 0) {
                sb.append(arr[j])
            }

            result.add(sb.toString().toLong())
            backTracking(depth + 1)
            arr.removeLast()
        }
    }
}