package kotlin_study.chap203

class Person3 {
    lateinit var name: String

    fun test() {
        if (!::name.isInitialized) {
            println("not initialized")
        } else {
            println("initialized")
        }
    }
}

fun main() {
    val kildong = Person3()
    kildong.test()
    kildong.name = "Kildong"
    kildong.test()
}