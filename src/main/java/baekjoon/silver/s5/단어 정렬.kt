package baekjoon.silver.s5

fun main() {
    val case = readLine()!!.toInt()
    var arr = ArrayList<String>()

    for (i in 0 until case)
        arr.add(readLine()!!)

    arr.sortBy { it.length } //길이순 정렬

    var i = 0
    while (i < arr.size) {
        var cnt = 1
        for (j in i until arr.size - 1) {
            if (arr[j].length == arr[j + 1].length)
                cnt++
            else
                break

        }

        var temp = Array(cnt) { "" }

        for ((idx, j) in (i until i + cnt).withIndex())
            temp[idx] = arr[j]
        temp.sort()
        temp = temp.distinct().toTypedArray()

        for (j in temp.indices) {
            println(temp[j])
        }
        i += cnt
    }
}