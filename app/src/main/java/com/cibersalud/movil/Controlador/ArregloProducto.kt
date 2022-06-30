package com.cibersalud.movil.Controlador

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.cibersalud.movil.Entidad.Producto
import com.cibersalud.movil.utils.appConfig

class ArregloProducto {
    fun listadoProducto():ArrayList<Producto>{
        var data= ArrayList<Producto>();
        var base:SQLiteDatabase=appConfig.BD.readableDatabase
        var sql="select *from tb_producto"
        var rs: Cursor =base.rawQuery(sql,null)
        while (rs.moveToNext()){
            var bean=Producto(rs.getInt(0),
                rs.getInt(1),rs.getInt(2),
                rs.getString(3),rs.getString(4),
                rs.getString(5),
                rs.getDouble(6),"")
            data.add(bean)
        }
        return data;
    }
    fun crearProducto(bean:Producto):Int{
        var estado=-1;
        var base: SQLiteDatabase = appConfig.BD.writableDatabase
        val valores= ContentValues();
        valores.put("idproducto",bean.codigo)
        valores.put("idlaboratorio",bean.codLabor)
        valores.put("idcategorias",bean.codCategoria)
        valores.put("nombreproducto",bean.nombreProducto)
        valores.put("detalleproducto",bean.detalleProducto)
        valores.put("tipopresentacion",bean.tipoPresentacion)
        valores.put("precioproducto",bean.precio)
        valores.put("urlproducto",bean.urlProducto)
        estado=base.insert("tb_producto","cod",valores).toInt()
        return estado;
    }
    fun editarProducto(bean:Producto):Int{
        var estado=-1;
        var base: SQLiteDatabase = appConfig.BD.writableDatabase
        val valores= ContentValues();
        valores.put("idproducto",bean.codigo)
        valores.put("idlaboratorio",bean.codLabor)
        valores.put("idcategorias",bean.codCategoria)
        valores.put("nombreproducto",bean.nombreProducto)
        valores.put("detalleproducto",bean.detalleProducto)
        valores.put("tipopresentacion",bean.tipoPresentacion)
        valores.put("precioproducto",bean.precio)
        valores.put("urlproducto",bean.urlProducto)
        estado=base.update("tb_producto",valores,"idproducto=?", arrayOf(bean.codigo.toString()))
        return estado;
    }
}