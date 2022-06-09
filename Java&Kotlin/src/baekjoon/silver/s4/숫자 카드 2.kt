package baekjoon.silver.s4

data class NumWithCnt(val num: Int, var cnt: Int)

fun main() {
    val n = readLine()!!.toInt()
    val arr1 = readLine()!!.split(" ").map { it.toInt() }.sorted().toIntArray()
    val n2 = readLine()!!.toInt()
    val arr2 = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

    val numList = ArrayList<NumWithCnt>()
    numList.add(NumWithCnt(arr1[0], 1))

    for (i in 1 until n) {
        if (arr1[i] != arr1[i - 1]) {
            numList.add(NumWithCnt(arr1[i], 1))
        } else {
            numList.last().cnt += 1
        }
    }

    for(i in arr2) {
        try {
            print("${numList.find { it.num == i }!!.cnt} ")
        } catch (e:java.lang.Exception) {
            print("0 ")
        }
    }
}

/*
10
6 3 2 10 10 10 -10 -10 7 3
8
10 9 -5 2 3 4 5 -10
 */