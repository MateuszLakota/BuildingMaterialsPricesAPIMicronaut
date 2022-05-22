package com.lakota.data.dao

import com.lakota.data.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BuildingMaterialsProducerDAOTest {

    private val dao = BuildingMaterialsProducerDAO()

    @Test
    fun testCreateProducer_WaterProducer() {
        // Given and when
        val producer = dao.createProducer(100, 200, ProducersTypes.WATER)
        // Then
        Assertions.assertTrue(producer is WaterProducer)
    }

    @Test
    fun testCreateProducer_SandProducer() {
        // Given and when
        val producer = dao.createProducer(100, 200, ProducersTypes.SAND)
        // Then
        Assertions.assertTrue(producer is SandProducer)
    }

    @Test
    fun testCreateProducer_CementProducer() {
        // Given and when
        val producer = dao.createProducer(100, 200, ProducersTypes.CEMENT)
        // Then
        Assertions.assertTrue(producer is CementProducer)
    }

    @Test
    fun testCreateProducer_ChippingsProducer() {
        // Given and when
        val producer = dao.createProducer(100, 200, ProducersTypes.CHIPPINGS)
        // Then
        Assertions.assertTrue(producer is ChippingsProducer)
    }
}