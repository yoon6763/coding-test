package baekjoon
/*
4 1 5 2 3
1 3 7 9 5

 */
fun main() {
    val arr1len = readLine()!!
    val arr1 = readLine()!!.split(" ").map { it.toInt() }.toIntArray().sortedArray()
    val arr2len = readLine()!!
    val arr2 = readLine()!!.split(" ").map { it.toInt() }

    arr2.forEach { target ->
        find(arr1, target)
    }
}

fun find(arr: IntArray, target: Int) {
    var left = 0
    var right = arr.size - 1
    var center = 0

    while (left <= right) {
        center = (left + right) / 2

        if(target == arr[center]) {
            println(1)
            return
        } else if(target > arr[center]) {
            left = center + 1
        } else {
            right = center - 1
        }
    }
    println(0)
}