package baekjoon.bronze.b2

fun main() {
    while (true) {
        val word = readlnOrNull() ?: break
        if (word == "#") break

        var start = 0
        var flag = false
        var worc = word

        while (true) {
            if (start > word.length + 1) {
                flag = true
                break
            }
            if (worc[start] in listOf('a', 'e', 'i', 'o', 'u')) break
            else {
                worc += worc[start]
                start++
            }
        }

        if (flag) {
            for (i in word.indices) {
                print(worc[i])
            }
        } else {
            for (i in start..<worc.length) {
                print(worc[i])
            }
        }

        print("ay\n")
    }
}
