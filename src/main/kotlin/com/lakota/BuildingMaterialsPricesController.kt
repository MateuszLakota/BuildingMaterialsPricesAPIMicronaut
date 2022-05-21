package com.lakota

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/buildingMaterialsPrices")
class BuildingMaterialsPricesController {

    @Get(uri = "/", produces = ["text/plain"])
    fun index(): String {
        return "Example Response"
    }
}