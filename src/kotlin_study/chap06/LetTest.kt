package kotlin_study.chap06

fun main() {
    val score: Int? = 32
    //var socre = null

    // 일반적인 null 검사
    fun checkScore() {
        if (score != null) {
            println("Score: $score")
        }
    }

    // let을 사용해 null 검사를 제거
    fun checkScoreLet() {
        score?.let { println("Score: $it") }  // 1st
        val str = score.let { it.toString() } // 2st
        println(str)
    }

    fun chaining(): Int {
        var a = 1
        val b = 2

        a = a.let { it + 2 }.let {
            println("a = $a")   // "a = 1"
            val i = it + b  // i = 3 + 2
            i
        }

        return a    // 5
    }

    var x = "Kotlin!"
    x.let { outer ->
        outer.let { inner ->
            print("Inner is $inner and outer is $outer")
            "Inner String"  //이 문자열은 반환되지 않음
        }
        "outer String"  //이 문자열이 반환되어 x에 할당
    }

}