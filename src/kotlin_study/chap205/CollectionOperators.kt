package kotlin_study.chap205

fun main() {
    val list1 = listOf("one", "two", "three")
    val list2 = listOf(1,2,3)
    val map1 = mapOf("hi" to 1, "hello" to 2, "Goodbye" to 3)

    println(list1 + "four")
    println(list2 + "hello")
    println(list2 - 1)
    println(list1 - "one")
    println(list1 + listOf("abc","def"))

    println(map1 + Pair("Bye", 4))

    val list = listOf(1,2,3,4,5,6)
    val listPair = listOf(Pair("A",300), Pair("B",200), Pair("C",100))

    println(listPair)
    list.forEach { print("$it ") }
    list.forEachIndexed { index, value -> println("index[$index]: $value")  }

    //fold: 초기값과 정해진 식에 따라 처음요소부터 끝 요소에 적용하며 값 생성
    //foldRight: fold와 같고 마지막 요소에서 처음요소로 반대로 적용
    println(list.fold(4){ total, next -> total + next}) // 4 + 1 + 2 + ... + 6 = 25
    println(list.foldRight(1){ total, next -> total * next}) // 1 * 6 * 5 * ... * 1 = 720


    //reduce: fold와 동일하지만 초기값 사용안함
    //reduceRight: reduce와 같고 마지막 요소에서 처음요소로 반대로 적용
    println(list.reduce{total, next -> total + next})
    println(list.reduceRight{total, next -> total + next})
    
}