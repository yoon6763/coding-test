package programmers.lv1.부족한_금액_계산하기

fun solution(price: Int, money: Int, count: Int): Long {
    var sum:Long = 0

    for(i in 0..count) {
        sum = sum + price * i
    }
    if (sum - money <= 0) return 0
    else return (sum - money)
}