package io.qmeta.engprofiles.intro

/**
 * A higher-order function is a function that takes another function as parameter and/or returns a function.
 */
fun calculation(x:Int,y:Int,operation:(Int,Int)->Int):Int{
    return operation(x,y)
}

fun sum(x:Int,y:Int):Int{
    return x+y
}
fun returnFunc():(Int) ->Int {
    return {a->a*a}
}

/**
 * Lambda function and how to use it
 */
fun returnFuncLambda():(Int) ->Int  = {it * it}
val upCase:(String)->String = String::toUpperCase

/**
 * extension:
 * 1. extension functions
 * 2. extension properties
 */
data class Item(val name:String,val price:Float)
data class Order(val items:Collection<Item>)
fun Order.maxPriceItemValue():Float = this.items.maxBy{it.price}?.price?:0F
val Order.commaDelimitedItemNames:String
    get() = items.map{it.name}.joinToString()
fun <T> T?.nullSafeToString() = this?.toString()?:"NULL"
fun main() {
    val sumResult = calculation(1,5, ::sum)
    println(sumResult)
    val mulResult = calculation(1,10){a,b->a+b}
    println(mulResult)
    println(returnFunc()(10))
    upCase("Hello")
    val order = Order(listOf(Item("Bread", 25.0F), Item("Wine", 29.0F), Item("Water", 12.0F)))
    println(order.maxPriceItemValue())
    println(order.commaDelimitedItemNames)
    println(null.nullSafeToString())
    println("test".nullSafeToString())
    println(order.nullSafeToString())
}