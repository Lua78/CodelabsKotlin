package example.myapp.decor

data class Decoration(val rocks: String) {
}
enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF);
}
data class Decoration2(val rocks: String, val wood: String, val diver: String){
}