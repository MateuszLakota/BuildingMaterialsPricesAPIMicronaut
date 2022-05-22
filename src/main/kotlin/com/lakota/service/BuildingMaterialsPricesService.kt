package com.lakota.service

import com.lakota.data.dao.BuildingMaterialsProducerDAO
import com.lakota.data.*
import java.time.DayOfWeek
import java.util.*

class BuildingMaterialsPricesService {

    private val producers = listOf(
        BuildingMaterialsProducerDAO().createProducer(0, 1000, ProducersTypes.CEMENT),
        BuildingMaterialsProducerDAO().createProducer(100, 1200, ProducersTypes.CHIPPINGS),
        BuildingMaterialsProducerDAO().createProducer(200, 1300, ProducersTypes.WATER),
        BuildingMaterialsProducerDAO().createProducer(300, 1400, ProducersTypes.SAND)
    )

    fun getCementPrice(): Int? {
        val dayOfWeek = getWeekday()
        return producers.filterIsInstance<CementProducer>().single().weekdayToPriceTariff[dayOfWeek]
    }

    fun getChippingsPrice(): Int? {
        val dayOfWeek = getWeekday()
        return producers.filterIsInstance<ChippingsProducer>().single().weekdayToPriceTariff[dayOfWeek]
    }

    fun getSandPrice(): Int? {
        val dayOfWeek = getWeekday()
        return producers.filterIsInstance<SandProducer>().single().weekdayToPriceTariff[dayOfWeek]
    }

    fun getWaterPrice(): Int? {
        val dayOfWeek = getWeekday()
        return producers.filterIsInstance<WaterProducer>().single().weekdayToPriceTariff[dayOfWeek]
    }

    private fun getWeekday(): DayOfWeek {
        val numeralDayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
        return DayOfWeek.of(numeralDayOfWeek)
    }
}
