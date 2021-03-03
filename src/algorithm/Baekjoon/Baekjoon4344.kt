package algorithm.Baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val c = br.readLine().toInt()
    var st: StringTokenizer
    repeat (c) {
        st = StringTokenizer(br.readLine())
        val n = st.nextToken().toInt()
        var arr = IntArray(n)
        var avg = 0.000f
        for (i in 0 until n) {
            arr[i] = st.nextToken().toInt()
            avg += arr[i]
        }
        avg /= n
        var count = 0.000f
        for (i in 0 until n) {
            if (arr[i] > avg)
                count++
        }
        val result = count/n*100
        bw.write(String.format("%.3f%%\n",result))
    }
    bw.flush()
}
