package com.cibersalud.movil.Controlador

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.cibersalud.movil.Entidad.Laboratorio
import com.example.aplicacioncolegio.utils.appConfig

class ArregloLaboratorio {
    fun listadoLaboratorio():ArrayList<Laboratorio>{
        var data= ArrayList<Laboratorio>();
        var base: SQLiteDatabase = appConfig.BD.readableDatabase
        var sql="select *from tb_laboratorio"
        var rs: Cursor =base.rawQuery(sql,null)
        while (rs.moveToNext()){
            var bean= Laboratorio(rs.getInt(0),
                rs.getString(1),
                rs.getInt(2))
            data.add(bean)
        }
        return data;
    }
    /*
    fun crearLaboratorio(bean: Laboratorio):Int{
        var estado=-1;
        var base: SQLiteDatabase = appConfig.BD.writableDatabase
        val valores= ContentValues();
        valores.put("idlaboratorio",bean.codLabo)
        valores.put("deslaboratorio",bean.descripcionLabo)
        valores.put("idestado",bean.estado)
        estado=base.insert("tb_laboratorio","idlaboratorio",valores).toInt()
        return estado;
    }
    fun editarLaboratorio(bean: Laboratorio):Int{
        var estado=-1;
        var base: SQLiteDatabase = appConfig.BD.writableDatabase
        val valores= ContentValues();
        valores.put("idlaboratorio",bean.codLabo)
        valores.put("deslaboratorio",bean.descripcionLabo)
        valores.put("idestado",bean.estado)
        estado=base.update("tb_laboratorio",valores,"idlaboratorio=?", arrayOf(bean.codLabo.toString()))
        return estado;
    }

     */
}