package com.lakota.service

import com.lakota.data.BuildingMaterialsProducer
import com.lakota.data.Product
import jakarta.inject.Singleton
import java.math.BigDecimal
import java.time.LocalDate

@Singleton
class BuildingMaterialsPricingService {
    private val producers = listOf(
        BuildingMaterialsProducer.createProducer(0.0, 1000.0, Product.CEMENT),
        BuildingMaterialsProducer.createProducer(100.0, 1200.0, Product.CHIPPINGS),
        BuildingMaterialsProducer.createProducer(200.0, 1300.0, Product.WATER),
        BuildingMaterialsProducer.createProducer(300.0, 1400.0, Product.SAND)
    ).associateBy { it.product }

    fun getCementPrice(): BigDecimal = getProductPrice(Product.CEMENT)

    fun getChippingsPrice(): BigDecimal = getProductPrice(Product.CHIPPINGS)

    fun getSandPrice(): BigDecimal = getProductPrice(Product.SAND)

    fun getWaterPrice(): BigDecimal = getProductPrice(Product.WATER)

    private fun getProductPrice(product: Product): BigDecimal = producers[product]?.getPrice(getWeekday())
        ?: throw IllegalStateException("Unable to get price for $product")

    private fun getWeekday() = LocalDate.now().dayOfWeek
}
