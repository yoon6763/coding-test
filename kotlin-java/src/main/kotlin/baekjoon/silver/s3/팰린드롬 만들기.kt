package baekjoon.silver.s3

fun main() {
    val str = readln().toCharArray().sorted()
    val alphabet = IntArray(26) { 0 }

    str.forEach { alphabet[it - 'A']++ }

    if (alphabet.count { it % 2 == 1 } > 1) {
        println("I'm Sorry Hansoo")
        return
    }

    var odd = -1

    for (i in 0..<26) {
        if (alphabet[i] % 2 == 1) {
            odd = i
            alphabet[i]--
            break
        }
    }

    val sb = StringBuilder()

    for (i in 0..<26) {
        repeat(alphabet[i] / 2) {
            sb.append('A' + i)
        }
    }

    print("$sb${if (odd != -1) 'A' + odd else ""}${sb.reversed()}")
}