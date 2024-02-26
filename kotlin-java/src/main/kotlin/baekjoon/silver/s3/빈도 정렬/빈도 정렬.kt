package baekjoon.silver.s3.`빈도 정렬`

data class Node(val idx: Int, var cnt: Int)

fun main() {
    val (n, c) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }.toIntArray()

    val hashMap = HashMap<Int, Node>()
    for (i in arr.indices) {
        if (hashMap.containsKey(arr[i])) hashMap[arr[i]]!!.cnt++
        else hashMap[arr[i]] = Node(i, 1)
    }

    val list = hashMap.toList().sortedWith(compareBy({ -it.second.cnt }, { it.second.idx })).toMap()

    val sb = StringBuilder()
    for (i in list.keys) {
        for (j in 0 until list[i]!!.cnt) {
            sb.append("$i ")
        }
    }
    println(sb)
}