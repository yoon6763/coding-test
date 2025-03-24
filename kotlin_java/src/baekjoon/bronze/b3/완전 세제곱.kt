package baekjoon.bronze.b3

fun main() {
    val sb = StringBuilder()

    for (a in 2..100) {
        for (b in 2 ..100) {
            for (c in b ..100) {
                for (d in c ..100) {
                    if (a * a * a == b * b * b + c * c * c + d * d * d) {
                        sb.append("Cube = $a, Triple = ($b,$c,$d)").append("\n")
                    }
                }
            }
        }
    }

    print(sb)
}