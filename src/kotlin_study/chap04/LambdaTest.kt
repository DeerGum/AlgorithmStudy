package kotlin_study.chap04

fun main() {
    val result: Int

    //일반 변수에 람다식 할당
    val multi: (a: Int, b: Int) -> Int = {a, b -> a * b}

    val nestedLambda: ()->()->Unit = { { println("nested") } }

    result = multi(10,20)
    println(result)

    nestedLambda()()
}