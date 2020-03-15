package io.qmeta.engprofiles.intro

data class User(val name:String, val age:Int){
    override fun toString(): String {
        return "$name,$age"
    }
}

enum class State {
    RUNNING,IDLE,FINISHED;

}

/**
 * only be subclassed from inside file
 */
sealed class Mammal(val name:String)

class Cat(private val catName:String):Mammal(catName)
class Human(private val humanName:String, val job:String):Mammal(humanName)
class Tiger(private val tigerName:String):Mammal(tigerName)

fun greetMammal(mammal: Mammal):String{
    return when(mammal){
        is Human -> "Hell ${mammal.job}"
        is Cat -> "Hell ${mammal.name}"
        else -> "Hell ${mammal.name}"
    }
}

/**
 * object class is just like a singleton pattern
 * static method in kotlin,companion objects
 */
object CheckIt {
    fun checkGreaterThan(threshold: Int):Boolean {
        return threshold>10
    }
}

class CompanionObjects{
    companion object CO {
        fun checkIt(str:String){
            println("it is checked!")
        }
    }
    /**
     * Only one companion object in one class
     */
//    companion object COA {
//        fun checkItAgain(str:String){
//            println("check it again")
//        }
//    }
}
infix fun String.isKnownState(state:State) = this ==state.toString()

fun main() {
    val alice = User("alice",12)
    println(alice)
    val anotherAlice = User("alice",12)
    val bo = User("bob",12)
    println(anotherAlice)
    println(alice==anotherAlice)
    println(alice === anotherAlice)
    println("alice is hashcode ,${alice.hashCode()}, " +
            "anotherAlice's ${anotherAlice.hashCode()}")
    println(alice.copy())
    println(alice.copy(name = "alice1"))
    println(alice.component1())  //this is auto generated
    println(alice.component2())

    val state = State.RUNNING
    val message = when(state) {
        State.IDLE -> "It is idle"
        State.RUNNING -> "It is idle"
        State.FINISHED -> "It is idle"
    }
    println(message)
    print("state" isKnownState State.RUNNING)
    print("RUNNING" isKnownState State.RUNNING)
    greetMammal(Tiger("tiger"))
    println(CheckIt.checkGreaterThan(10))
    CompanionObjects.checkIt("this is in companion object")
}