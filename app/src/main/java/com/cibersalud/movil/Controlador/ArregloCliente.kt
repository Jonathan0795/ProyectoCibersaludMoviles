package com.cibersalud.movil.Controlador

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.cibersalud.movil.Entidad.Cliente
import com.example.aplicacioncolegio.utils.appConfig

class ArregloCliente {
    fun listadoCliente():ArrayList<Cliente>{
        var data= ArrayList<Cliente>();
        var base:SQLiteDatabase=appConfig.BD.readableDatabase
        var sql="select *from tb_cliente"
        var rs: Cursor =base.rawQuery(sql,null)
        while (rs.moveToNext()){
            var bean= Cliente(rs.getInt(0),
                rs.getString(1),rs.getString(2),
                rs.getString(3),rs.getInt(4),
                rs.getString(5),
                rs.getString(6),rs.getString(7),
                rs.getString(8),rs.getString(9))
            data.add(bean)
        }
        return data;
    }
    fun crearCliente(bean: Cliente):Int{
        var estado=-1;
        var base: SQLiteDatabase = appConfig.BD.writableDatabase
        val valores= ContentValues();
        valores.put("idcliente",bean.codigoCli)
        valores.put("apellidomat",bean.paterno)
        valores.put("apellidopat",bean.materno)
        valores.put("nombre",bean.nombre)
        valores.put("iddoc",bean.tipoDoc)
        valores.put("documento",bean.documento)
        valores.put("fechnac",bean.nacimiento)
        valores.put("tiposexo",bean.sexo)
        valores.put("username",bean.usuario)
        valores.put("password",bean.password)
        estado=base.insert("tb_cliente","idcliente",valores).toInt()
        return estado;
    }
    fun editarProducto(bean: Cliente):Int{
        var estado=-1;
        var base: SQLiteDatabase = appConfig.BD.writableDatabase
        val valores= ContentValues();
        valores.put("idcliente",bean.codigoCli)
        valores.put("apellidomat",bean.paterno)
        valores.put("apellidopat",bean.materno)
        valores.put("nombre",bean.nombre)
        valores.put("iddoc",bean.tipoDoc)
        valores.put("documento",bean.documento)
        valores.put("fechnac",bean.nacimiento)
        valores.put("tiposexo",bean.sexo)
        valores.put("username",bean.usuario)
        valores.put("password",bean.password)
        estado=base.update("tb_cliente",valores,"idcliente=?", arrayOf(bean.codigoCli.toString()))
        return estado;
    }
}