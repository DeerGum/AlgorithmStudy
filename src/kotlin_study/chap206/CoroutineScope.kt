package kotlin_study.chap206

import kotlinx.coroutines.*

fun main() = runBlocking(Dispatchers.Default) {
   launch(Dispatchers.IO) {
       delay(1200L)
       println("Task from runBlocking")
   }

    coroutineScope { //새로운 스코프
        launch {
            delay(1500L)
            println("Task from nested launch")
        }
        delay(200L)
        println("Task from coroutineScope")
    }

    println("end of runBlocking")
}