package programmers.lv1

fun main() {
    val s = "ybcde"
    val skip = "az"
    val index = 1

    val pass = skip.toCharArray()
    val sb = StringBuilder()

    for (c in s) {
        var initial = c
        repeat(index) {
            initial++

            if (initial > 'z') initial -= 26

            while (initial in pass) {
                initial++
                if (initial > 'z') initial -= 26
            }
        }
        sb.append(initial)
    }

    println(sb)
}