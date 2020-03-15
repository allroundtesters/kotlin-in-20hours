package io.qmeta.engprofiles.intro

fun main() {
    case("Hello")
    case(1)
    case("1")
    case(0L)
    case(null)
    case(MyClass())
    val zoo = Zoo(listOf(Animal("zebra"),Animal("lion")))
    for (animal in zoo) {
        println("this is ${animal.name}")
    }
    for(i in 0..100 step 3){
        println(i)
    }
    for(i in 100 downTo 3){
        println(i)
    }
    // equality check

    val authors = setOf("Shakespeare", "Hemingway", "Twain")
    val writers = setOf("Twain", "Shakespeare", "Hemingway")

    println(authors == writers)   // 1 check value
    println(authors === writers)  // 2 check reference
    print(max(12,232))
}
class MyClass

/**
 * When
 */
fun case(obj:Any?):Any?{
    val result = when(obj){
        1 -> println("One")
        "Hello"-> println("Greeting")
        is Long -> println("Long")
        !is String -> println("Not a String")
        else -> println("Unknown")
    }
    return result
}

/**
 * control flow:
 * 1. while/do-while
 * 2. iterators:
 * 3. range
 * 4. when
 * 5. if else/conditional expression
 */
class Animal(val name:String)
class Zoo(val animals:List<Animal>) {
    /**
     * define operator for iterator, for loop
     */
    operator fun iterator():Iterator<Animal> {
        return animals.iterator()
    }
}

fun max(a:Int,b:Int) = if(a>b) a else b

