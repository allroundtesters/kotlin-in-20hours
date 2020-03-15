package io.qmeta.engprofiles.intro

var a:String = "variable"
var b: Int = 3

/**
 * Null Safety
 */
var neverNull:String = "This can't be null"
var nullable:String? = "this can be null"

fun main() {
    println(a)
    println(b)
//    neverNull=null //error
    nullable=null
//    print(strLength(nullable)) //error
    print(neverNull)
    workingWithNull(nullable)
}

fun strLength(notNull:String):Int {
    return notNull.length
}

fun workingWithNull(nullableStr:String?): String {
    if (nullableStr!=null&& nullableStr.isNotEmpty()){
        return "string is empty";
    }else {
        return "Empty or Null String"
    }
}