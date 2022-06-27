package com.cibersalud.movil.Controlador

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.cibersalud.movil.Entidad.Categoria
import com.example.aplicacioncolegio.utils.appConfig

class ArregloCategoria {
    fun crearCategoria(bean: Categoria):Int{
        var estado=-1;
        var base: SQLiteDatabase = appConfig.BD.writableDatabase
        val valores= ContentValues();
        valores.put("idcategorias",bean.codCate)
        valores.put("idcategoriapadre",bean.codCatePadre)
        valores.put("desccategoria",bean.descripcionCate)
        valores.put("idestado",bean.estado)
        estado=base.insert("tb_categorias","idcategorias",valores).toInt()
        return estado;
    }
    fun editarCategoria(bean: Categoria):Int{
        var estado=-1;
        var base: SQLiteDatabase = appConfig.BD.writableDatabase
        val valores= ContentValues();
        valores.put("idcategorias",bean.codCate)
        valores.put("idcategoriapadre",bean.codCatePadre)
        valores.put("desccategoria",bean.descripcionCate)
        valores.put("idestado",bean.estado)
        estado=base.update("tb_categorias",valores,"idcategorias=?", arrayOf(bean.codCate.toString()))
        return estado;
    }
}