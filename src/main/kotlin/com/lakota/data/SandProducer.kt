package com.lakota.data

data class SandProducer(val lowerPriceThreshold: Int, val upperPriceThreshold: Int) :
    BuildingMaterialsProducer(lowerPriceThreshold, upperPriceThreshold)
