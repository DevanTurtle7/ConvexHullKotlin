package model

import java.util.ArrayDeque

class ConvexHull<E>(vararg points: Point<E>) {
    private val points = mutableListOf<Point<E>>(*points)

    private fun getStartingPoint(): Point<E> {
        var start: Point<E> = points[0]

        for (point in this.points) {
            if (point.y < start.y) {
                start = point
            } else if (point.y == start.y && start.x > point.x) {
                start = point
            }
        }

        return start
    }

    fun shortestPath(): List<Point<E>> {
        val path = mutableListOf<Point<E>>()
        val stack = ArrayDeque<Point<E>>()
        val startingPoint = getStartingPoint()

        this.points.remove(startingPoint)
        this.points.sortBy{startingPoint angle it}
        stack.push(startingPoint)
        stack.push(this.points[0])
        this.points.removeAt(0)

        for (point in this.points) {
            var middle = stack.pop()
            var from = stack.pop()

            while (point.crossProduct(from, middle) <= 0 && stack.size > 1) {
                middle = from;
                from = stack.pop();
            }

            stack.add(from)
            stack.add(middle)
            stack.add(point)
        }

        while (stack.size > 0) {
            path.add(stack.pop())
        }

        return path
    }
}

fun main() {
    val a = Point<Int>(0.0, 0.0)
    val b = Point<Int>(3.0, 3.0)
    val c = Point<Int>(1.0, 4.0)
    val d = Point<Int>(-1.0, 3.0)
    val e = Point<Int>(1.0, 2.0)

    val hull = ConvexHull<Int>(a, b, c, d, e)
    println(hull.shortestPath())
}