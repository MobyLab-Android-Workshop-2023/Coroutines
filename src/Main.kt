import kotlinx.coroutines.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

val formatter = DateTimeFormatter.ISO_LOCAL_TIME
val time = { formatter.format(LocalDateTime.now()) }

suspend fun getValue(): Double {
    println("Enter funct at ${time()}")
    delay(3000)
    println("Exit funct at ${time()}")
    println("${Thread.currentThread()}")
    return Math.random()
}

fun main() {
    /*repeat(3) {
        val thread = Thread {
            println("${Thread.currentThread()} running")
        }
        thread.start()
    }*/

    /*val jobs = ArrayList<Job>(20)

    repeat(20) {
        jobs.add(GlobalScope.launch {
            println("${Thread.currentThread()} running")
        })
    }

    jobs.forEach{
        it.join()
    }*/

    runBlocking {
        val nr1 = async { getValue() }
        val nr2 = async { getValue() }
        println("${Thread.currentThread()}. Sum is ${nr1.await() + nr2.await()}")
    }
}