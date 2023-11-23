package groomthonchallenge.lv2.p6_문자열나누기

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val str = readLine()

    val set = hashSetOf<String>()
    val list = mutableListOf<Triple<String, String, String>>()

    for (j in 1 until n - 1) {
        for (k in j + 1 until n) {
            val part1 = str.substring(0, j)
            val part2 = str.substring(j, k)
            val part3 = str.substring(k, n)

            list.add(Triple(part1, part2, part3))
            set.add(part1)
            set.add(part2)
            set.add(part3)
        }
    }

    val p = set.sorted()
    var ans = 0
    list.forEach {
        val (part1, part2, part3) = it
        val i1 = p.indexOf(part1)
        val i2 = p.indexOf(part2)
        val i3 = p.indexOf(part3)
        ans = maxOf(ans, i1 + i2 + i3)
    }

    println(ans + 3)
}