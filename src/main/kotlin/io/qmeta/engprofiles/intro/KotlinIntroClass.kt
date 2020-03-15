package io.qmeta.engprofiles.intro

class Customer

class Contract(val id:Int,var email:String)

/**
 * Generic
 */
class MyMutableStack<E>(vararg items:E) {
    private val elements = items.toMutableList()
    fun push(element:E)=elements.add(element)
    fun peek()=elements.last()
    fun pop()=elements.removeAt(elements.size-1)
    fun isEmpty()=elements.isEmpty()
    fun size() = elements.size
    override fun toString(): String {
        return  "MyMutableStack(${elements.joinToString()})"
    }
}
fun <E> myMutableStackOf(vararg elements:E) = MyMutableStack(*elements)

/**
 * inheritance class
 */
open class Dog(val name:String) {
    open fun sayHello(){
        println("wow,wow")
    }
}

/**
 * parameter constructor
 */
class LittleDog:Dog("little"){
    override fun sayHello() {
        println("wif,wif,$name")
    }
}



fun main() {
    var customer = Customer()
    val contract = Contract(1,"1@1.com")
    println(contract.id)
    println(contract.email)
    contract.email="modified@email.com"
    //could be different type in a container or collection
    val stack = myMutableStackOf(0.1,2,3,4,"test")
    println(stack)
    val dog:Dog = LittleDog()
    dog.sayHello()
}