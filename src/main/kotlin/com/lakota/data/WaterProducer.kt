package com.lakota.data

data class WaterProducer(val lowerPriceThreshold: Int, val upperPriceThreshold: Int) :
    BuildingMaterialsProducer(lowerPriceThreshold, upperPriceThreshold)
