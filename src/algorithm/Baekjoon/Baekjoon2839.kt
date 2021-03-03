package algorithm.Baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var n = br.readLine().toInt()
    var result = 0

    if (n == 4 || n == 7) {
        result = -1;
    }
    else if (n % 5 == 0) {
        result = (n / 5);
    }
    else if (n % 5 == 1 || n % 5 == 3) {
        result = (n / 5) + 1;
    }
    else if (n % 5 == 2 || n % 5 == 4) {
        result = (n / 5) + 2;
    }

    bw.write(result.toString())
    bw.flush()
}

/*
5로 나눔
3으로 나눔

3으로 나눔
 */