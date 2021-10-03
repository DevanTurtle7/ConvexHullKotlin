package model

class ConvexHull<E>(vararg points: Point<E>) {
    private val points = mutableListOf<Point<E>>(*points)

    private fun getStartingPoint(): Point<E> {
        var start: Point<E> = points[0]

        for (point in this.points) {
            if (point.y < start.y) {
                start = point
            }
        }

        return start
    }

    fun shortestPath(): List<Point<E>> {
        val path = mutableListOf<Point<E>>()
        val startingPoint = getStartingPoint()
        this.points.sortBy{startingPoint angle it}

        for (point in this.points) {
            println(startingPoint angle point)
        }

        return path
    }
}

fun main() {
    val a = Point<Int>(1.0, 2.0)
    val b = Point<Int>(2.0, 3.0)
    val c = Point<Int>(1.0, 4.0)
    val d = Point<Int>(0.0, 4.0)
    val e = Point<Int>(20.0, 2.0)

    val hull = ConvexHull<Int>(a, b, c, d, e)
    hull.shortestPath()
}