package generics

fun genericsExample() {
    val aquarium = Aquarium(TapWater())
    addItemTo(aquarium)
}

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")

open class WaterSupply(var needsProcessing: Boolean)

class TapWater : WaterSupply(true) {
    fun addChemicalCleaners() {
        needsProcessing = false
    }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessing = false
    }
}

class Aquarium<out T: WaterSupply>(val waterSupply: T) {
    fun addWater() {
        check(!waterSupply.needsProcessing) { "water supply needs processing first" }
        println("adding water from $waterSupply")
    }
}

fun main() {
    genericsExample()
}