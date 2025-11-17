package baekjoon.silver.s4
fun main(): Unit = with(System.`in`.bufferedReader()) {
    val hashMap = HashMap<String, Int>()

    repeat(readLine().toInt()) {
        val bookTitle = readLine()
        hashMap[bookTitle] = hashMap.getOrDefault(bookTitle, 0) + 1
    }

    // hashMap의 value 기준 정렬, 동일하면 key 기준 정렬
    val sortedList = hashMap.toList().sortedWith(compareBy({ -it.second }, { it.first }))
    println(sortedList[0].first)
}