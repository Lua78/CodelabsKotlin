fun main() {
    var dirtyLevel = 20
    val waterFilter = { dirty : Int -> dirty / 2}
    println(waterFilter(dirtyLevel))
    println(updateDirty(30, waterFilter))
    println(updateDirty(30, ::increaseDirty))
    dirtyLevel = updateDirty(dirtyLevel) { dirtyLev -> dirtyLev + 23}
    println(dirtyLevel)
}
fun increaseDirty( start: Int ) = start + 1

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
 }