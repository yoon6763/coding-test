package baekjoon.gold.g2.보석도둑

import java.util.Collections
import java.util.PriorityQueue

data class Jewelry(val weight: Int, val price: Int) : Comparable<Jewelry> {
    override fun compareTo(other: Jewelry): Int {
        return if (this.weight != other.weight) this.weight - other.weight // 무게로 내림차순 정렬
        else other.price - this.price // 무게가 같으면 가격으로 오름차순 정렬
    }
}

fun main() {
    val br = System.`in`.bufferedReader()
    // n - 보석의 수, k - 가방의 수
    val (n, k) = br.readLine().split(" ").map { it.toInt() }

    val pqJewelries = PriorityQueue<Jewelry>()
    val bag = Array(k) { 0 }

    repeat(n) {
        val (w, p) = br.readLine().split(" ").map { it.toInt() }
        pqJewelries.add(Jewelry(w,p))
    }
    repeat(k) {
        bag[it] = br.readLine().toInt()
    }

    // 무게 기준으로 오름차순 정렬
    bag.sort()

    // 가격을 넣을 우선순위 큐. 가격이 높은 순으로 정렬
    val pqPrice = PriorityQueue<Int>(Collections.reverseOrder())
    var total = 0L

    bag.forEach { bagWeight ->
        while (pqJewelries.isNotEmpty()) {
            if(pqJewelries.peek().weight <= bagWeight) {
                pqPrice.add(pqJewelries.poll().price)
            } else {
                break
            }
        }

        // 가장 비싼 값 하나를 꺼냄 (배낭 하나당 한개의 보석만 들어갈 수 있기 때문에 하나만)
        if (pqPrice.isNotEmpty()) total += pqPrice.poll()
    }

    println(total)
}