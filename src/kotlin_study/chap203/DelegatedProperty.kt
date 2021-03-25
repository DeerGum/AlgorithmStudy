package kotlin_study.chap203

import kotlin.properties.Delegates

class User2 {
    // observable은 값의 변화를 감시하는 일종의 콜백 루틴
    var name: String by Delegates.observable("NONAME") {
        prop, old, new ->
        println("old: $old, new: $new")
    }
}

fun main() {
    val user = User2()

    user.name = "Kildong"
    user.name = "Dooly"
}