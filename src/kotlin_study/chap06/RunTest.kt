package kotlin_study.chap06

fun main() {
    data class Person(var name: String, var skills: String)
    var person = Person("Kildong", "Kotlin")

    val returnObj = person.apply {
        this.name = "Sean"
        skills = "Java" //this 생략가능
        "success"   //사용되지 않음
    }   //returnObj : Person
    println(person)
    println("returnObj: $returnObj")

    var returnObj2 = person.run {
        this.name = "Dooly"
        skills = "C#"   //this 생략가능
        "success"   //반환
    }   //returnObj2 : String
    println(person)
    println("returnObj2: $returnObj2")

    val returnObj3 = with(person) {
        this.name = "Dooly"
        skills = "C#"   //this 생략가능
        "success"   //반환
    }   //returnObj3 : String
    println(person)
    println("returnObj2: $returnObj3")

    val returnObj4 = person.let {
        it.name = "Jarry" //it 생략 불가능
        it.skills = "Kotlin"
        "success"   //반환
    }   //returnObj4 : String
    println(person)
    println("returnObj2: $returnObj4")

    val returnObj5 = person.also {
        it.name = "Kildong" //it 생략 불가능
        it.skills = "Java"
        "success"   //사용되지 않음
    }   //returnObj5: Person
    println(person)
    println("returnObj2: $returnObj5")
}