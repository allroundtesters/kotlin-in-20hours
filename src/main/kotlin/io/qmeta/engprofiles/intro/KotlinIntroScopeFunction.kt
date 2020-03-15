package io.qmeta.engprofiles.intro

/**
 * 1.let: execute a code block return its result
 * 2.run: run access by this
 * 3.with
 * 4.apply
 * 5.also
 */
fun customPrint(s:String?){
    println(s)
    println(s?.toUpperCase())
}
fun getNullableLength(ns:String?){
    println("for \"$ns\"")
    ns?.run{
        println(this.isEmpty())
        println(this.length)
        length
    }
}

class Conf(val host:String,val port:Int)

fun main() {
    val empty = "test".let {
        customPrint(it)
        it.isEmpty()
    }
    println("is empty: $empty")
    getNullableLength("test")
    getNullableLength(null)

    val conf = Conf("localhost",8080)
    with(conf){
        println("$host:$port")
    }
    println("${conf.host}:${conf.port}")
    val jake = PersonData()                                     // 1
    val stringDescription = jake.apply {                    // 2
        name = "Jake"                                       // 3
        age = 30
        about = "Android developer"
    }.also { writeCreationLog((it)) }.toString()                                            // 4
    println(stringDescription)
}

data class PersonData(var name: String, var age: Int, var about: String) {
    constructor() : this("", 0, "")
}

fun writeCreationLog(p:PersonData) {
    println("in also block")
}