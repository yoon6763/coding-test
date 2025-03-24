package baekjoon.bronze.b1

fun main() {
    val arr = arrayOf(
        "baby",
        "sukhwan",
        "tururu",
        "turu",
        "very",
        "cute",
        "tururu",
        "turu",
        "in",
        "bed",
        "tururu",
        "turu",
        "baby",
        "sukhwan"
    )

    val n = readln().toInt() - 1
    val k = n / 14
    if (arr[n % 14] == "tururu") {
        if (k < 3) {
            print("tu" + "ru".repeat(k + 2))
        } else {
            print("tu+ru*${k + 2}")
        }
    } else if (arr[n % 14] == "turu") {
        if (k < 4) {
            print("tu" + "ru".repeat(k + 1))
        } else {
            print("tu+ru*${k + 1}")
        }
    } else {
        print(arr[n % 14])
    }
}
