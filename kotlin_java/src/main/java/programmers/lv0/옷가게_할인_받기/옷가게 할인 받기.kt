package programmers.lv0.옷가게_할인_받기

fun solution(price: Int): Int {
    if(price >= 500000) {
        return price * 80 / 100
    } else if(price >= 300000) {
        return price * 90 / 100
    } else if(price >= 100000) {
        return price * 95 / 100
    } else {
        return price
    }
}