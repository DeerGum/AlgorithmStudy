package algorithm.Baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    var coin = IntArray(n)
    repeat(n) {
        coin[it] = br.readLine().toInt()
    }

    var value = k
    var count = 0
    for (i in n-1 downTo 0) {
        if (value == 0)
            break
        if (value < coin[i])
            continue

        val quotient = value / coin[i]
        value %= coin[i]
        count += quotient
    }
    bw.use {
        it.write("$count\n")
    }
}