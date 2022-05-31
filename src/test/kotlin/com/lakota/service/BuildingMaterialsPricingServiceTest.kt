package com.lakota.service

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class BuildingMaterialsPricingServiceTest {

    private val service: BuildingMaterialsPricingService = BuildingMaterialsPricingService()

    @Test
    fun testGetCementPrice() {
        // Given and when
        val firstCallResult = service.getCementPrice()
        val secondCallResult = service.getCementPrice()
        // Then
        performAssertions(firstCallResult, secondCallResult)
    }

    @Test
    fun testGetChippingsPrice() {
        // Given and when
        val firstCallResult = service.getChippingsPrice()
        val secondCallResult = service.getChippingsPrice()
        // Then
        performAssertions(firstCallResult, secondCallResult)
    }

    @Test
    fun testGetSandPrice() {
        // Given and when
        val firstCallResult = service.getSandPrice()
        val secondCallResult = service.getSandPrice()
        // Then
        performAssertions(firstCallResult, secondCallResult)
    }

    @Test
    fun testGetWaterPrice() {
        // Given and when
        val firstCallResult = service.getWaterPrice()
        val secondCallResult = service.getWaterPrice()
        // Then
        performAssertions(firstCallResult, secondCallResult)
    }

    private fun performAssertions(firstCallResult: BigDecimal, secondCallResult: BigDecimal) {
        Assertions.assertNotNull(firstCallResult)
        Assertions.assertEquals(firstCallResult, secondCallResult)
    }
}