package kotlin_study.chap05

fun main() {

    var total = 0
    //홀수 합
    for (num in 1..100 step 2) total += num

    println("total : $total")
}