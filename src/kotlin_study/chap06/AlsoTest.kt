package kotlin_study.chap06

fun main() {
    data class Person(var name: String, var skills: String)
    var person = Person("Kildong", "Kotlin")

    val a = person.let {
        it.skills = "Android"
        "success"
    }

    println(person)
    println("a: $a")

    val b = person.also {
        it.skills = "Java"
        "success" //마지막 문장은 사용되지 않음
    }
    println(person)
    println("b: $b") // Person의 객체 b
}