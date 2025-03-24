package baekjoon.bronze.b1

fun main() {
    val arr = readln().split(" ").map { it.toInt() }.toIntArray()

    while (!(arr[0] == 1 && arr[1] == 2 && arr[2] == 3 && arr[3] == 4 && arr[4] == 5)) {
        for (i in 0..<4) {
            if (arr[i] > arr[i + 1]) {
                val tmp = arr[i + 1]
                arr[i + 1] = arr[i]
                arr[i] = tmp
                println(arr.joinToString(" "))
            }
        }
    }
}
