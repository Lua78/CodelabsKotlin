fun main() {
    val list = listOf(1, 5, 3, 4)
    println(list.sum())
    val list2 = listOf("a", "bbb", "cc")
    println(list2.sumOf { it.length })

    for (s in list2.listIterator()) {
        println("$s ")
    }


    //Hash map
    val cures = hashMapOf("white spots" to "Ich", "red sores" to "hole disease")
    println(cures)
    println(cures["red sores"])
    println(cures.getOrDefault("bloating", "sorry, I don't know"))

    val inventory = mutableMapOf("fish net" to 1)
    inventory.put("tank scrubber", 3)
    println(inventory.toString())
    inventory.remove("fish net")
    println(inventory.toString())
}