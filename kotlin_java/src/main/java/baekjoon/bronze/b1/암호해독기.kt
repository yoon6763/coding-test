package baekjoon.bronze.b1

/*
방금 도착한 암호문을 해독했는데, 해독에 오류가 없는지 확인해보려 한다. 해독한 문장이 암호문을 해석한 결과로 나올 수 없다면, 그 해독은 잘못된 것이다.

암호문은 0 이상 52 이하의 정수로 이루어져 있다. 0은 띄어쓰기, 1 - 26 범위 안의 수는 A ~ Z, 27 - 52 범위 안의 수는 a ~ z로 해석된다. 암호문은 띄어쓰기를 포함한 모든 철자를 이와 같이 정수로 치환한 후 순서를 무작위로 뒤섞어서 만들어졌다.
 */

fun main() {
    readln()
    println(if (readln().split(" ").map { it.toInt() }
            .map { if (it in 1..26) 'A' + it - 1 else if (it in 27..52) 'a' + it - 27 else ' ' }
            .sorted() == readln().toCharArray().sorted()) 'y' else 'n')
}
