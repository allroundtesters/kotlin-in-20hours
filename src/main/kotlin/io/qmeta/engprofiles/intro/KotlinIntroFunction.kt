package io.qmeta.engprofiles.intro

/**
 * ## 0.Hello World and Main
 */
fun main(args:Array<String>){
    println("Hello World!")
    Greeter("Kotlin").greet()
    printMessage("this is print Msg function")
    printMessageWithPrefix("msg")
    printMessageWithPrefix("msg","prefix")
    println(add(5,4))
    infix fun Int.times(str:String)=str.repeat(this)
    println(2 times "bye")
    val pair = "key" to "value"
    println(pair)
    infix fun String.onto(other:String) = kotlin.Pair(this,other)
    val newPair = "key" onto "value"
    println(newPair)
    val alice = Person("alice")
    val bob = Person(name="bob")
    alice likes bob
    for (likedPerson in alice.likedPeople) {
        println(likedPerson)
    }
    printAll("Hello", "Hallo", "Salut", "Hola", "你好")                 // 2
    printAllWithPrefix("hello","world",prefix="prefix")
}
/**
 * ## 1. Function in Kotlin
 * - Function Parameter with default value
 * - input/output type
 * - infix function (magic),member function with single parameter
 * - operator function
 */
fun printMessage(msg: String):Unit {
    println(msg)
}

fun printMessageWithPrefix(msg:String,prefix:String="default"){
    println("[$prefix] $msg")
}

fun add(x:Int,y:Int):Int = x+y

class Person(val name:String){
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other:Person){
        likedPeople.add(other)
    }
}

operator fun Int.times(str:String) = str.repeat(this)

/**
 * vararg: turns a parameter into a vararg
 */
fun printAll(vararg messages: String){
    for (message in messages) {
        println(message)
    }
}
fun printAllWithPrefix(vararg messages:String,prefix:String){
    for (message in messages) {
        println(prefix+message)
    }
}

/**
 * ## Simple Class
 */
class Greeter(private val name: String){
    fun greet(){
        println("Hello $name")
    }
}


