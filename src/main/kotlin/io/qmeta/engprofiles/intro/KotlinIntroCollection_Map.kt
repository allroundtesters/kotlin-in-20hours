package io.qmeta.engprofiles.intro

const val POINTS_X_PASS: Int = 15
val EZPassAccounts: MutableMap<Int, Int> = mutableMapOf(1 to 100, 2 to 100, 3 to 100)   // 1
val EZPassReport: Map<Int, Int> = EZPassAccounts                                        // 2

fun updatePointsCredit(accountId: Int) {
    if (EZPassAccounts.containsKey(accountId)) {                                        // 3
        println("Updating $accountId...")
        EZPassAccounts[accountId] = EZPassAccounts.getValue(accountId) + POINTS_X_PASS  // 4
    } else {
        println("Error: Trying to update a non-existing account (id: $accountId)")
    }
}

fun accountsReport() {
    println("EZ-Pass report:")
    EZPassReport.forEach {                                                              // 5
        k, v ->
        println("ID $k: credit $v")
    }
}

val numbers = listOf(1, -2, 3, -4, 5, -6)      // 1
val positives = numbers.filter { x -> x > 0 }  // 2
val negatives = numbers.filter { it < 0 }      // 3

fun main() {
    accountsReport()                                                                    // 6
    updatePointsCredit(1)                                                               // 7
    updatePointsCredit(1)
    updatePointsCredit(5)                                                               // 8
    accountsReport()
    //filter
    println(positives)
    println(negatives)// 9
    //map
    val numbers = listOf(1, -2, 3, -4, 5, -6)     // 1
    val doubled = numbers.map { x -> x * 2 }      // 2
    val tripled = numbers.map { it * 3 }
    val tripledMap = numbers.flatMap { listOf(it, it, it) } // 2// 3
    //any
    val anyNegative = numbers.any { it < 0 }
    println(anyNegative)// 2
    val anyGT6 = numbers.any { it > 6 }
    println(anyGT6)
    val allEven = numbers.all { it % 2 == 0 }            // 2
    val allLess6 = numbers.all { it < 6 }
    println(allEven)
    println(allLess6)
    val firstEven = numbers.first { it % 2 == 0 }        // 4
    val lastOdd = numbers.last { it % 2 != 0 }
    val totalCount = numbers.count()                     // 2
    val evenCount = numbers.count { it % 2 == 0 }

    val words = listOf("Lets", "find", "something", "in", "collection", "somehow")  // 1
    val first = words.find { it.startsWith("some") }                                // 2
    val last = words.findLast { it.startsWith("some") }                             // 3
    val nothing = words.find { it.contains("nothing") }
    val firstF = words.firstOrNull { it.startsWith('f') }  // 5
    val firstZ = words.firstOrNull { it.startsWith('z') }  // 6
    val lastF = words.lastOrNull { it.endsWith('f') }      // 7
    val lastZ = words.lastOrNull { it.endsWith('z') }      // 8

    println(phoneBook)
    println(cityBook)
    println(peopleCities)

    //partion
    val evenOdd = numbers.partition { it % 2 == 0 }           // 2
    val (positivesa, negativesa) = numbers.partition { it > 0 } // 3
    println(evenOdd)
    println(positivesa+negativesa)
    val A = listOf("a", "b", "c")                  // 1
    val B = listOf(1, 2, 3, 4)                     // 1

    val resultPairs = A zip B                      // 2
    val resultReduce = A.zip(B) { a, b -> "$a$b" } // 3
    println(resultReduce)
    print(resultPairs)
}


data class DataPerson(val name: String, val city: String, val phone: String) // 1

val people = listOf(                                                     // 2
        DataPerson("John", "Boston", "+1-888-123456"),
        DataPerson("Sarah", "Munich", "+49-777-789123"),
        DataPerson("Svyatoslav", "Saint-Petersburg", "+7-999-456789"),
        DataPerson("Vasilisa", "Saint-Petersburg", "+7-999-123456"))

/**
 * return map
 */
val phoneBook = people.associateBy { it.phone }                          // 3
val cityBook = people.associateBy(DataPerson::phone, DataPerson::city)           // 4
val peopleCities = people.groupBy(DataPerson::city, DataPerson::name)