package com.lakota.data

data class ChippingsProducer(val lowerPriceThreshold: Int, val upperPriceThreshold: Int) :
    BuildingMaterialsProducer(lowerPriceThreshold, upperPriceThreshold)
