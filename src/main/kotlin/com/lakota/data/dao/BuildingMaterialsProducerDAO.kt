package com.lakota.data.dao

import com.lakota.data.*

class BuildingMaterialsProducerDAO {

    fun createProducer(
        lowerPriceThreshold: Int,
        upperPriceThreshold: Int,
        producerType: ProducersTypes
    ): BuildingMaterialsProducer {
        return when (producerType) {
            ProducersTypes.CEMENT -> CementProducer(lowerPriceThreshold, upperPriceThreshold)
            ProducersTypes.CHIPPINGS -> ChippingsProducer(lowerPriceThreshold, upperPriceThreshold)
            ProducersTypes.SAND -> SandProducer(lowerPriceThreshold, upperPriceThreshold)
            ProducersTypes.WATER -> WaterProducer(lowerPriceThreshold, upperPriceThreshold)
        }
    }
}