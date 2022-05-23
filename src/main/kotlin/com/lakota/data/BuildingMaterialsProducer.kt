package com.lakota.data

import java.math.BigDecimal
import java.time.DayOfWeek
import kotlin.random.Random

sealed class BuildingMaterialsProducer(lowerPriceThreshold: Double, upperPriceThreshold: Double) {

    abstract val product: Product
    private val weekdayToPrice = DayOfWeek
        .values()
        .associateWith { generatePrice(lowerPriceThreshold, upperPriceThreshold) }

    internal fun getPrice(dayOfWeek: DayOfWeek): BigDecimal = weekdayToPrice[dayOfWeek]
        ?: throw IllegalStateException("Cannot get price tariff for $dayOfWeek")

    private fun generatePrice(lowerBound: Double, upperBound: Double): BigDecimal {
        return priceGenerator().nextDouble(lowerBound, upperBound).toBigDecimal()
    }

    private fun priceGenerator() = Random(System.currentTimeMillis())

    companion object {
        fun createProducer(
            lowerPriceThreshold: Double,
            upperPriceThreshold: Double,
            producerType: Product
        ): BuildingMaterialsProducer {
            return when (producerType) {
                Product.CEMENT -> CementProducer(lowerPriceThreshold, upperPriceThreshold)
                Product.CHIPPINGS -> ChippingsProducer(lowerPriceThreshold, upperPriceThreshold)
                Product.SAND -> SandProducer(lowerPriceThreshold, upperPriceThreshold)
                Product.WATER -> WaterProducer(lowerPriceThreshold, upperPriceThreshold)
            }
        }
    }
}

class CementProducer(lowerPriceThreshold: Double, upperPriceThreshold: Double) :
    BuildingMaterialsProducer(lowerPriceThreshold, upperPriceThreshold) {
    override val product: Product = Product.CEMENT
}

class ChippingsProducer(lowerPriceThreshold: Double, upperPriceThreshold: Double) :
    BuildingMaterialsProducer(lowerPriceThreshold, upperPriceThreshold) {
    override val product: Product = Product.CHIPPINGS
}

class SandProducer(lowerPriceThreshold: Double, upperPriceThreshold: Double) :
    BuildingMaterialsProducer(lowerPriceThreshold, upperPriceThreshold) {
    override val product: Product = Product.SAND
}

class WaterProducer(lowerPriceThreshold: Double, upperPriceThreshold: Double) :
    BuildingMaterialsProducer(lowerPriceThreshold, upperPriceThreshold) {
    override val product: Product = Product.WATER
}