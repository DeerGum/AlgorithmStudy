package kotlin_study.chap04

inline fun shortFunc(a: Int, out: (Int) -> Unit) {
    println("Hello")
    out(a)
}

fun main() {
    shortFunc(3,{a-> println("a: $a")})
}