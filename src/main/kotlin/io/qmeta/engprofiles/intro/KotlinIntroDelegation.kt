package io.qmeta.engprofiles.intro

import org.hibernate.id.SequenceIdentityGenerator
import kotlin.reflect.KProperty

interface SoundBehavior{
    fun makeSound()
}

class ScreamBehavior(val n:String):SoundBehavior {
    override fun makeSound() {
        println("this is scream...... $n")
    }
}

/**
 * delegate to implementation class
 */
class RockAndRollBehavior(val n: String):SoundBehavior {
    override fun makeSound() {
        println("this is rock and roll $n")
    }
}

class Tom(n:String):SoundBehavior by ScreamBehavior(n)
class Elvis(n:String): SoundBehavior by RockAndRollBehavior(n)              // 3

class Example{
    var p:String by Delegate()
    override fun toString() = "Example Class"

}

class Delegate() {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {        // 2
        return "$thisRef, thank you for delegating '${prop.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) { // 2
        println("$value has been assigned to ${prop.name} in $thisRef")
    }
}

fun main() {
    val tom = Tom("tom")
    val elvis = Elvis("elvis")
    tom.makeSound()
    elvis.makeSound()
    val e = Example()
    println(e.p)
    e.p ="NEW"
    println(e.p)
    val sample = LazySample()         // 1
    println("lazyStr = ${sample.lazyStr}")  // 2
    println(" = ${sample.lazyStr}")  // 3
}

class LazySample {
    init {
        println("created!")            // 1
    }

    val lazyStr: String by lazy {
        println("computed!")          // 2
        "my lazy"
    }
}

