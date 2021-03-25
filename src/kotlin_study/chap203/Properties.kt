package kotlin_study.chap203

class Person(_id: Int, _name: String, _age: Int) {
    //프로퍼티
    var id: Int = _id
    val name: String = _name
    val age: Int = _age
}

class Person2(var id: Int, val name: String, val age: Int)

class User(_id: Int, _name: String, _age: Int) {
    val id: Int = _id
        get() = field

    var name: String = _name
        get() = field
        set(value) {
            field = value
        }

    var age: Int = _age
        get() = field
        set(value) {
            field = value + 10
        }
}

fun main() {
    val person = Person(1,"Kildong",30)
    val user = User(1,"H",25)
    person.id = 2
    user.age = 35

    println(user.age)

}