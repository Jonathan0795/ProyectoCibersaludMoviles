package com.cibersalud.movil.Entidad

class Laboratorio {
    private var codLabo: Int=0
    private var descripcionLabo: String=""
    private var estado: Int=0

    constructor(codLabo: Int, descripcionLabo: String,estado:Int) {
        this.codLabo = codLabo
        this.descripcionLabo = descripcionLabo
        this.estado=estado
    }
    fun getCodLabo():Int{
        return codLabo
    }
    fun setCodLabo(codLabo:Int){
        this.codLabo=codLabo
    }
    fun getdescripcionLabo():String{
        return descripcionLabo
    }

}