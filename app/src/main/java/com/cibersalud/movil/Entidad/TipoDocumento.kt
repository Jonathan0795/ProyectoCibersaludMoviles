package com.cibersalud.movil.Entidad

class TipoDocumento {
    private var codigo:Int=0
    private var descrip:String=""

    constructor(codigo: Int, descrip: String) {
        this.codigo = codigo
        this.descrip = descrip
    }

    fun getCodigo():Int{
        return codigo
    }
    fun setCodigo(codigo:Int){
        this.codigo=codigo
    }
    fun getDescripcion():String {
        return descrip
    }
}