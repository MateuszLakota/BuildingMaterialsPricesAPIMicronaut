package com.lakota.api

import com.lakota.data.dto.BuildingMaterialsProducerDTO
import com.lakota.service.BuildingMaterialsPricesService
import io.micronaut.http.HttpResponseFactory
import io.micronaut.http.HttpStatus
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller
class BuildingMaterialsPricesController {

    @Get("/cement")
    fun getCement(): MutableHttpResponse<BuildingMaterialsProducerDTO>{
        val price = BuildingMaterialsPricesService().getCementPrice().toString()
        return responseWith<BuildingMaterialsProducerDTO>(HttpStatus.OK).body(BuildingMaterialsProducerDTO(price))
    }

    @Get("/chippings")
    fun getChippings(): MutableHttpResponse<BuildingMaterialsProducerDTO> {
        val price = BuildingMaterialsPricesService().getChippingsPrice().toString()
        return responseWith<BuildingMaterialsProducerDTO>(HttpStatus.OK).body(BuildingMaterialsProducerDTO(price))
    }

    @Get("/sand")
    fun getSand(): MutableHttpResponse<BuildingMaterialsProducerDTO> {
        val price = BuildingMaterialsPricesService().getSandPrice().toString()
        return responseWith<BuildingMaterialsProducerDTO>(HttpStatus.OK).body(BuildingMaterialsProducerDTO(price))
    }

    @Get("/water")
    fun getWater(): MutableHttpResponse<BuildingMaterialsProducerDTO> {
        val price = BuildingMaterialsPricesService().getWaterPrice().toString()
        return responseWith<BuildingMaterialsProducerDTO>(HttpStatus.OK).body(BuildingMaterialsProducerDTO(price))
    }

    private fun <R> responseWith(status: HttpStatus): MutableHttpResponse<R> {
        return HttpResponseFactory.INSTANCE.status(status)
    }
}