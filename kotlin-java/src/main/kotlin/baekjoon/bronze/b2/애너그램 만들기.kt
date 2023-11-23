package baekjoon.bronze.b2

fun main() {
    val s1 = readln().toCharArray().sorted()
    val s2 = readln().toCharArray().sorted()

    var count = 0

    var ptr1 = 0
    var ptr2 = 0

    while (ptr1 < s1.size && ptr2 < s2.size) {
        when {
            s1[ptr1] == s2[ptr2] -> {
                ptr1++
                ptr2++
            }
            s1[ptr1] < s2[ptr2] -> {
                ptr1++
                count++
            }
            else -> {
                ptr2++
                count++
            }
        }
    }

    count += s1.size - ptr1
    count += s2.size - ptr2

    println(count)
}