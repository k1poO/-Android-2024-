fun main() {
    val array = createArrayWithDuplicate()
    println("Массив: ${array.joinToString(", ")}")
    val duplicate = findDuplicate(array)
    println("Дублированный элемент: $duplicate")
}

private fun findDuplicate(array: IntArray): Int {
    val n = array.size - 1
    val expectedSum = n * (n + 1) / 2
    val actualSum = array.sum()
    return actualSum - expectedSum
}

private fun createArrayWithDuplicate(): IntArray {
    val n = 100
    val arr = IntArray(n + 1) { it + 1 }
    val duplicateIndex = (1..n).random()
    arr[n] = duplicateIndex
    return arr
}
