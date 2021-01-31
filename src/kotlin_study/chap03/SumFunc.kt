package kotlin_study.chap03

fun sum(a: Int, b: Int) = a + b

fun max(a: Int, b: Int): Int {
    return if(a > b) a else b
}

fun outFunc(name: String): Unit {
    println("Name: $name")
    return Unit
}

fun avgFunc(initial: Float = 0f,vararg numbers: Float): Double {
    var result = 0f
    for(num in numbers) {
        result += num
    }
    println("result: $result, numbers.size: ${numbers.size}")
    val avg = result / numbers.size + initial
    return avg.toDouble()
}

fun highFunc(a: Int, b: Int, sum: (Int, Int) -> Int): Int {
    return sum(a, b)
}

fun main() {
    val result = highFunc(1,3) {x, y -> x + y}  //람다식 뒤로 뺼 수 있음

}

