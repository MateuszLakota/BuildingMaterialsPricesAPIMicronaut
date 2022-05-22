package com.lakota.data

data class CementProducer(val lowerPriceThreshold: Int, val upperPriceThreshold: Int) :
    BuildingMaterialsProducer(lowerPriceThreshold, upperPriceThreshold)
