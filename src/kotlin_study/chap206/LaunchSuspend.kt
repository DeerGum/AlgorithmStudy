package kotlin_study.chap206

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

suspend fun doWork1(): String {
    delay(1000)
    return "Work1"
}

suspend fun doWork2(): String {
    delay(3000)
    return "Work2"
}

private fun workInseial(): Job {
    // 순차적 실행 (4초)
    val job = GlobalScope.launch {
        val one = doWork1() //1초
        val two = doWork2() //3초
        println("Kotlin One : $one")
        println("Kotlin Two : $two")
    }
    return job
}

private fun workInParallel(): Job {
    //병렬 실행 (3초)
    val one = GlobalScope.async {
        doWork1()
    }
    val two = GlobalScope.async {
        doWork2()
    }

    val job = GlobalScope.launch {
        val combined = one.await() + "_" + two.await()
        println("Kotlin Combined: $combined")
    }
    return job
}

fun main() = runBlocking {
    val time = measureTimeMillis {
//        val job = workInseial()
//        job.join()
        val job = workInParallel()
        job.join()
    }
    println("time: $time")
}