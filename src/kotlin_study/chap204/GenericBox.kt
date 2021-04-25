package kotlin_study.chap204

class Box<T>(a: T) {
    var name = a
}

fun main() {
    val box1 = Box(1)
    val box2 = Box("Kildong")

}