package com.app.boldblue.superseguros.partners.Methods

class models_beneficios_superapi {
    var idCobertura : String
    var descripcionCobertura : String
    var montoFormateadoCobertura : String
    var descripcionLarga : String


    constructor(idCobertura: String,
                descripcionCobertura: String,
                montoFormateadoCobertura: String,
                descripcionLarga: String) {
        this.idCobertura = idCobertura
        this.descripcionCobertura = descripcionCobertura
        this.montoFormateadoCobertura = montoFormateadoCobertura
        this.descripcionLarga = descripcionLarga
    }
}