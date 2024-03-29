package kotlin_study.chap206

import kotlinx.coroutines.*

fun main() = runBlocking {
    println("runBlocking: $coroutineContext")
    val request = launch {
        println("request: $coroutineContext")
        GlobalScope.launch { //프로그램 전역으로 독립적인 수행
            println("job1: before suspend function $coroutineContext")
            delay(1000)
            println("job1: after suspend function $coroutineContext")
        }
//        launch { // 부모의 문맥을 상속
//        launch(Dispatchers.Default) { //부모의 문맥을 상속 (상위 launch의 자식)
        CoroutineScope(Dispatchers.Default).launch { //새로운 스코프가 구성되 request와 무관
            delay(100)
            println("job2: before suspend function $coroutineContext")
            delay(1000)
            println("job2: after suspend function $coroutineContext") //request(부모)가 취소되면 수행되지 않음
        }
    }
    delay(500)
    request.cancel()
    delay(1000)
}