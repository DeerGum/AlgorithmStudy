package kotlin_study.chap206

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val job = GlobalScope.launch {
            delay(1000L)
            println("World")
            doSomething()
        }
        println("Hello")
        println("job: ${job.isActive}, ${job.isCompleted}")
//        Thread.sleep(2000L)
        job.join()  //코루틴 실행하는 동안 기다려줌
        println("job: ${job.isActive}, ${job.isCompleted}")
    }
}

suspend fun doSomething() {
    println("Do Something")
}