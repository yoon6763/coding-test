package baekjoon.bronze.b3

/*
문제
The pandemic is getting better and you can finally do the thing you’ve been dreaming of for the past few years: eat at your favorite restaurant! The restaurant happens to be in Kathmandu, but that’s fine, you can always take a plane.

The problem is that planes almost always leave you restless. You consider yourself properly rested if you can sleep for T uninterrupted minutes, which means you are never awake from a certain moment t to t + T. Also, you’re a very easy sleeper: you can fall asleep at the start of any minute and wake up at the end of any minute.

Of course, if you sleep too much you will miss all the airplane meals! That is unacceptable, as no opportunity for free food should go to waste.

Luckily, the airplane company sent you the whole flight schedule: the duration of the flight, D minutes, the number of meals that are going to be served, M, and the exact time they will serve the meals, yi. You need to be awake at the time the meal is being served to be able to eat it, otherwise, the steward will not serve you. Since you’re always hungry, you will devour the meal instantly.

Now you are wondering, for the optimal plane traveling experience, can you get properly rested and still eat all meals during the flight?

입력
The first line of input contains three integers, T, D, M (1 ≤ T, D ≤ 105, 0 ≤ M ≤ 1000), representing, respectively, the number of minutes you need to sleep without interruption to be properly rested, the duration of the flight and the number of meals that are going to be served during the flight.

Each of the next M lines contains an integer yi (0 ≤ yi ≤ D). These integers represent the times at which each meal is going to be served, and are given in chronological order.

출력
Output a line containing one character. If you can get properly rested and still eat all meals during the flight, write the upper case letter ‘Y’; otherwise write the uppercase letter ‘N’.
 */

fun main() {
    val (t, d, m) = readln().split(" ").map { it.toInt() }

    var flag = false
    var pre = 0

    repeat(m) {
        val n = readln().toInt()
        if (n - pre >= t) flag = true
        pre = n
    }

    if (d - pre >= t) flag = true
    println(if (flag) 'Y' else 'N')
}
