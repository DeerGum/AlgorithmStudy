package kotlin_study.chap06

fun main() {
    data class User(val name: String, var skills: String, var email: String? = null)

    val user = User("Kildong","default")

    val result = with(user) {
        skills = "Kotlin"
        email = "kildong@example.com"
        //기본적으로 Unit 반환, 필요하면 마지막 표현식 반환가능 ex) String
    }
    var test = 32
    test = test.let { it + 3 }
    println(test)
    println(user)
    println("result: $result")

}