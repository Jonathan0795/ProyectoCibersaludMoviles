package com.cibersalud.movil.Entidad

import java.io.Serializable

class Producto( var codigo:Int,
                var codLabor:Int,
                var codCategoria:Int,
                var nombreProducto:String,
                var detalleProducto:String,
                var tipoPresentacion:String,
                var precio:Double,
                var urlProducto:String
              ):Serializable{

}