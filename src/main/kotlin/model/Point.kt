package model

class Point<E>(val x: Int, val y: Int, val value: E? = null) {
    infix fun dot(other: Point<E>): Int {
        return (this.x * other.x) + (this.y * other.y)
    }
}

fun main() {
    val a = Point<Int>(1, 2)
    val b = Point<Int>(2, 3)

    println(a dot b)
}