package com.cibersalud.movil.Entidad

class Categoria {

    private var codCate: Int=0
    private var codCatePadre: Int=0
    private var descripcionCate: String=""
    private var estado: Int=0

    constructor(codCate: Int,codCatePadre:Int, descripcionCate: String,estado:Int) {
        this.codCate = codCate
        this.codCatePadre = codCatePadre
        this.descripcionCate = descripcionCate
        this.estado=estado
    }

    fun getcodCate():Int{
        return codCate
    }
    fun setcodCate(codCate:Int){
        this.codCate=codCate
    }
    fun getcodCatePadre():Int{
        return codCatePadre
    }
    fun setcodCatePadre(codCatePadre:Int){
        this.codCatePadre=codCatePadre
    }
    fun getdescripcionCate():String{
        return descripcionCate
    }

}