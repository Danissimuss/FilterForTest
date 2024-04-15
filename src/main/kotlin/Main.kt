data class Grocery (val name: String, val category: String, val unit: String, val unitPrice: Double, val quantity: Int) {
}

fun main (args: Array<String>) {
    val groceries = listOf(Grocery("Tomatoes", "Vegetable", "Ib", 3.0, 3),
        Grocery("Mushrooms", "Vegetable", "Ib", 4.0, 1),
        Grocery("Bagels", "Bakery", "Pack", 1.5, 2),
        Grocery("Olive oil", "Pantry", "Bottle", 6.0, 1),
        Grocery("Ice cream", "Frozen", "Pack", 3.0, 2))
    groceries.groupBy { it.category } .forEach {
        println(it.key)
        it.value.forEach { println("  ${it.name}")}
    }
    val ints = listOf(1,2,3)
    val sumofint = ints.fold(0){k, item -> k+item}
    println("sum: $sumofint")
    val product = ints.fold(1) {prod, item -> prod * item}
    println("prod: $product")
    val names = groceries.fold(" ") {string, item -> string +" ${item.name}"}
println("names: $names")
    val change50 = groceries.fold(50.0) {change, item -> change - item.unitPrice*item.quantity}
    println("change: $change50")
    var maga:Double = 0.0
   val a =  groceries.filter {it.category == "Vegetable"} .forEach ({maga += it.unitPrice*it.quantity.toDouble()})
    println(maga)
    groceries.groupBy { it.category }.forEach {
        println("${it.key}: ${it.value.sumOf { it.unitPrice * it.quantity }}")
    }
    groceries.filterNot { it.unit == "Bottle"}.groupBy { it.unit }.forEach {
        println(it.key)
        it.value.forEach { println(" ${it.name}") }
    }
}