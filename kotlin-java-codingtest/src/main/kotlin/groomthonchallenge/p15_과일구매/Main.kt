package groomthonchallenge.p15_과일구매

data class Fruit(val price: Double, val satisfaction: Double)

fun main() = with(System.`in`.bufferedReader()) {
    var (n, k) = readLine().split(" ").map(String::toInt)

    // 과일 가격, 포만감
    val fruits = Array(n) {
        val (price, satisfaction) = readLine().split(" ").map(String::toDouble)
        Fruit(price, satisfaction)
    }

    fruits.sortByDescending { it.satisfaction / it.price }

    var answer = 0.0

    for (fruit in fruits) {
        if (k >= fruit.price) {
            answer += fruit.satisfaction
            k -= fruit.price.toInt()
        } else {
            answer += k * (fruit.satisfaction / fruit.price)
            break
        }
    }

    println(answer.toLong())
}