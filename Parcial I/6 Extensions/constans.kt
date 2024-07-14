class MyClass {
    companion object {
        const val CONSTANT3 = "constant in companion"
    }
}
fun main() {
    val foo = MyClass.CONSTANT3
    println(foo)
}
