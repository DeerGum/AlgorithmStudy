package kotlin_study.chap201

class Bird(var name: String, val wing: Int, var beak: String) {
    init {
        println("----------init start----------")
        name = name.capitalize()
        println("name: $name, wing: $wing, beak: $beak")
        println("----------init end------------")
    }

    //메서드
    fun fly() {
        println("Fly")
    }
}

fun main() {
    val coco = Bird("coco",2,"long")
    coco.fly()
}