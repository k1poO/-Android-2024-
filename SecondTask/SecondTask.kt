fun main() {
    val array = arrayOf(1, 1, 2, 3, 4, 4, 4, 4, 4, 5, 5, 5)
    val counts = countElements(array)
    printCounts(counts)
}

// Функция для подсчета количества каждого элемента в массиве
fun countElements(array: Array<Int>): Map<Int, Int> {
    val counts = mutableMapOf<Int, Int>()
    for (element in array) {
        counts[element] = counts.getOrDefault(element, 0) + 1
    }
    return counts
}

// Функция для вывода элементов и их количества
fun printCounts(counts: Map<Int, Int>) {
    for ((element, count) in counts) {
        println("$element: $count")
    }
}
