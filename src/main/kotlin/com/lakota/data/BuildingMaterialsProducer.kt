package com.lakota.data

import java.time.DayOfWeek
import kotlin.random.Random

abstract class BuildingMaterialsProducer(lowerPriceThreshold: Int, upperPriceThreshold: Int) {

    val weekdayToPriceTariff = hashMapOf<DayOfWeek, Int>()
    private val priceGenerator = Random(System.currentTimeMillis())

    init {
        DayOfWeek.values().forEach { dayOfWeek ->
            weekdayToPriceTariff[dayOfWeek] = generatePrice(lowerPriceThreshold, upperPriceThreshold)
        }
    }

    private fun generatePrice(lowerBound: Int, upperBound: Int): Int {
        return priceGenerator.nextInt(lowerBound, upperBound)
    }
}
