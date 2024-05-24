import kotlin.math.pow

fun main() {
    val cube = Cube(10.0)
    println("Объём куба: ${cube.volume()}")
    println("Площадь основания куба: ${cube.baseArea()}")

    val sphere = Sphere(10.0)
    println("Объём сферы: ${sphere.volume()}")
    println("Площадь основания сферы: ${sphere.baseArea()}")

    val pyramid = Pyramid(10.0, 10.0)
    println("Объём пирамиды: ${pyramid.volume()}")
    println("Площадь основания пирамиды: ${pyramid.baseArea()}")
}

// Интерфейс для трехмерных фигур
interface Solid {
    fun volume(): Double
    fun baseArea(): Double
}

// Абстрактный класс для фигур с общей реализацией
abstract class ThreeDimensionalShape : Solid

// Класс для Куба
class Cube(private val sideLength: Double) : ThreeDimensionalShape() {
    override fun volume(): Double {
        return sideLength * sideLength * sideLength
    }

    override fun baseArea(): Double {
        return sideLength * sideLength
    }
}

// Класс для Сферы
class Sphere(private val radius: Double) : ThreeDimensionalShape() {
    override fun volume(): Double {
        return (4 / 3.0) * Math.PI * radius.pow(3.0)
    }

    override fun baseArea(): Double {
        return Math.PI * radius.pow(2.0)
    }
}

// Класс для Пирамиды
class Pyramid(private val baseSideLength: Double, private val height: Double) : ThreeDimensionalShape() {
    override fun volume(): Double {
        return (1 / 3.0) * baseArea() * height
    }

    override fun baseArea(): Double {
        return baseSideLength * baseSideLength
    }
}
