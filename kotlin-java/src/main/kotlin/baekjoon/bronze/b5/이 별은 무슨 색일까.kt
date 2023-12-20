package baekjoon.bronze.b5

fun main() = print(
    when (readln().toInt()) {
        in 620..780 -> "Red"
        in 590..619 -> "Orange"
        in 570..589 -> "Yellow"
        in 495..569 -> "Green"
        in 450..494 -> "Blue"
        in 425..449 -> "Indigo"
        else -> "Violet"
    }
)