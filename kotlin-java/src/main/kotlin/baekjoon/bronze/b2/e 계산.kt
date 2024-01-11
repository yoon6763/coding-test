package baekjoon.bronze.b2

fun main() {
    println("n e")
    println("- -----------")
    println("0 1")
    println("1 2")
    println("2 2.5")

    var ft = 2.0
    var tmp = 2.0
    var ans = 2.5

    while (ft < 9) {
        ft++
        tmp *= ft
        ans += 1 / tmp
        System.out.printf("%.0f %.9f\n", ft, ans)
    }
}
