package baekjoon.bronze.b2

fun main(args: Array<String>) {
    var input: String = readLine()!!
    var result: String = ""
    var matchCase = arrayOf('a', 'e', 'i', 'o', 'u')

    var idx: Int = 0

    while (idx < input.length) {
        if (input[idx] in matchCase) {
            result += input[idx]
            idx += 3
        } else {
            result += input[idx]
            idx++
        }
    }

    print(result)
}