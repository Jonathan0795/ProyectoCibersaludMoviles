package com.cibersalud.movil.Entidad

import java.io.Serializable


class Cliente ( var codigoCli:Int,
                var paterno:String,
                var materno:String,
                var nombre:String,
                var tipoDoc:Int,
                var documento:String,
                var nacimiento:String,
                var sexo:String,
                var usuario:String,
                var password:String
                ): Serializable {

}