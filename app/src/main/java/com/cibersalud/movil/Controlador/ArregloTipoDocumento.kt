package com.cibersalud.movil.Controlador

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.cibersalud.movil.Entidad.TipoDocumento
import com.cibersalud.movil.utils.appConfig

class ArregloTipoDocumento {
    fun listadoDocumento():ArrayList<TipoDocumento>{
        var data=ArrayList<TipoDocumento>();
        var base: SQLiteDatabase = appConfig.BD.readableDatabase
        var sql="select *from tb_tipodocumento"
        var rs: Cursor =base.rawQuery(sql,null)
        while (rs.moveToNext()){
            var bean=TipoDocumento(rs.getInt(0),
                rs.getString(1))
            data.add(bean)
        }
        return data
    }
}