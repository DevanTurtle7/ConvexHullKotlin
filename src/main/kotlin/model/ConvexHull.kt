package model

class ConvexHull<E>(vararg points: Point<E>) {
    private val points = mutableListOf<Point<E>>(*points)
}

fun main() {
    val a = Point<Int>(1.0, 2.0)
    val b = Point<Int>(2.0, 3.0)
    val c = Point<Int>(1.0, 4.0)
    val d = Point<Int>(0.0, 4.0)
    val e = Point<Int>(20.0, 2.0)

    val hull = ConvexHull<Int>(a, b, c, d, e)
}