package baekjoon.bronze.b1

fun main() {
    val s1 = readln()
    val s2 = readln()
    var str = ""
    for (i in s1.indices) {
        str += s1[i]
        str += s2[i]
    }

    while (str.length > 2) {
        var newstr = ""
        for (i in 0..<str.length - 1) {
            val n = str[i].digitToInt() + str[i + 1].digitToInt()
            newstr += (n % 10).toString()
        }
        str = newstr
    }
    print(str)
}
