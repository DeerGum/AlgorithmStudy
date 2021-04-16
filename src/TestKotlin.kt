import java.util.*

fun main() {
    val mixArr = arrayOf(4,5,7,3,"Chike", false) // 정수, 문자열, Boolean 혼합

    var test = Array<Int>(5,{0})
    var test2 = IntArray(5)
    // Integer[] == Array<Int>
    // int[] == IntArray
    //코틀린에서는 모든 자료형이 객체형
    println()
    test = test.plus(5)
    println(test.contentDeepToString())
}

