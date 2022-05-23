package com.lakota.api

import com.lakota.data.dto.BuildingMaterialsProducerDTO
import com.lakota.service.BuildingMaterialsPricingService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import java.math.BigDecimal

@Controller
@Suppress("unused")
class BuildingMaterialsPricesController(private val pricingService: BuildingMaterialsPricingService) {

    @Get("/cement")
    fun getCement(): HttpResponse<BuildingMaterialsProducerDTO> = pricingService.getCementPrice().toHttpResponse()

    @Get("/chippings")
    fun getChippings(): MutableHttpResponse<BuildingMaterialsProducerDTO> =
        pricingService.getChippingsPrice().toHttpResponse()

    @Get("/sand")
    fun getSand(): MutableHttpResponse<BuildingMaterialsProducerDTO> = pricingService.getSandPrice().toHttpResponse()

    @Get("/water")
    fun getWater(): MutableHttpResponse<BuildingMaterialsProducerDTO> {
        return pricingService.getWaterPrice().toHttpResponse()
    }

    private fun BigDecimal.toHttpResponse() = HttpResponse.ok<BuildingMaterialsProducerDTO?>()
        .body(BuildingMaterialsProducerDTO(this))
}