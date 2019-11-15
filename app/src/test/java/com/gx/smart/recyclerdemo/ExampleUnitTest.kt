package com.gx.smart.recyclerdemo

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test1(){
        Item2().test {
            println("start")
        }
    }


}

class Item2{
    fun test(t1: () -> Unit) {
        t1.invoke()
        test1()
        test2().test3()
    }

    private fun test1() {
        println("test1")
    }
    private fun test2() = "test2"

    private fun String.test3() {
        println(this.toUpperCase())
    }


}
