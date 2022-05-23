package com.lakota.api

import com.lakota.data.dto.BuildingMaterialsProducerDTO
import io.micronaut.http.HttpResponse
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@MicronautTest
class BuildingMaterialsPricesControllerTest {

    @Inject
    lateinit var application: EmbeddedApplication<*>

    @Inject
    lateinit var controller: BuildingMaterialsPricesController

    private val expectedCode: Int = 200
    private val expectedReason: String = "OK"

    @Test
    fun testApplicationWorks() {
        // Given and when
        val applicationStatus = application.isRunning
        // Then
        Assertions.assertTrue(applicationStatus)
    }

    @Test
    fun testGetCement() {
        // Given and when
        val response = controller.getCement()
        // Then
        performAssertions(response)
    }

    @Test
    fun testGetChippings() {
        // Given and when
        val response = controller.getChippings()
        // Then
        performAssertions(response)
    }

    @Test
    fun testGetSand() {
        // Given and when
        val response = controller.getSand()
        // Then
        performAssertions(response)
    }

    @Test
    fun testGetWater() {
        // Given and when
        val response = controller.getWater()
        // Then
        performAssertions(response)
    }

    private fun performAssertions(response: HttpResponse<BuildingMaterialsProducerDTO>) {
        // Given and when
        val code = response.code()
        val reason = response.reason()
        // Then
        Assertions.assertNotNull(response)
        Assertions.assertEquals(expectedCode, code)
        Assertions.assertEquals(expectedReason, reason)
    }
}