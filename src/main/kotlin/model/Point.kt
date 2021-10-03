package model

import java.lang.Math.atan

class Point<E>(val x: Double, val y: Double, val value: E? = null) {
    infix fun <E> dot(other: Point<E>): Double {
        return (this.x * other.x) + (this.y * other.y)
    }

    infix fun <E> angle(other: Point<E>): Double {
        val xDiff = other.x - this.x
        val yDiff = other.y - this.y

        if (xDiff == 0.0) {return 90.0}
        if (yDiff == 0.0) {return 180.0}

        var angle = Math.toDegrees(atan(yDiff / xDiff))

        if (xDiff < 0) {
            angle += 180
        }

        return angle
    }

    override
    fun toString(): String {
       return (x to y).toString()
    }
}

fun main() {
    val a = Point<Int>(1.0, 2.0)
    val b = Point<String>(2.0, 3.0)
    val c = Point<Double>(1.0, 4.0)
    val d = Point<Int>(0.0, 4.0)
    val e = Point<Int>(20.0, 2.0)

    println(a dot b)
    println(a angle b)
    println(a angle c)
    println(a angle d)
    println(a angle e)
}