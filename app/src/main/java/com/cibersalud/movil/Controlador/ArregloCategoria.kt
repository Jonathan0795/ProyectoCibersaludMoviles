package com.cibersalud.movil.Controlador

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.cibersalud.movil.Entidad.Categoria
import com.cibersalud.movil.Entidad.Cliente
import com.cibersalud.movil.utils.appConfig


class ArregloCategoria {
    fun listadoCategoria():ArrayList<Categoria>{
        var data= ArrayList<Categoria>();
        var base:SQLiteDatabase=appConfig.BD.readableDatabase
        var sql="select *from tb_categorias"
        var rs: Cursor =base.rawQuery(sql,null)
        while (rs.moveToNext()){
            var bean= Categoria(rs.getInt(0),
                rs.getInt(1),rs.getString(2),
                rs.getInt(3))
            data.add(bean)
        }
        return data;
    }
    /*
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
    */

}