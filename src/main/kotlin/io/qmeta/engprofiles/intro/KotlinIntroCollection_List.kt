package io.qmeta.engprofiles.intro

/**
 * list: ordered collection, mutableList,read-only list
 */
val systemUsers: MutableList<Int> = mutableListOf(1, 2, 3)        // 1
val sudoers: List<Int> = systemUsers    //readonly

fun addSysUser(newUser:Int){
    systemUsers.add(newUser)
}
fun getSudoUser():List<Int>{
    return sudoers
}

/**
 * set is unordered collection that does not support duplicated value
 */
val openIssues = mutableSetOf<String>("jira1","jira2")
fun addIssue(desc:String):Boolean {
    return openIssues.add(desc)
}
fun getStatusLog(isAdded: Boolean): String {
    return if (isAdded) "registered correctly." else "marked as duplicate and rejected."          // 3
}

fun main() {
    addSysUser(10)
//    getSudoUser().add(10) // error list is immutable
    val aNewIssue: String = "uniqueDescr4"
    val anIssueAlreadyIn: String = "uniqueDescr2"

    println("Issue $aNewIssue ${getStatusLog(addIssue(aNewIssue))}")                              // 4
    println("Issue $anIssueAlreadyIn ${getStatusLog(addIssue(anIssueAlreadyIn))}")                // 5
}
