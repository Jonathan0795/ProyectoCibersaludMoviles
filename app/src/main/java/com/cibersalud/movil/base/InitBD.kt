package com.cibersalud.movil.base

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.cibersalud.movil.utils.appConfig

class InitBD : SQLiteOpenHelper(
    appConfig.CONTEXT,
    appConfig.BD_NAME,
    null,
    appConfig.VERSION
){
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table tb_tipodocumento("+
                "iddoc integer primary key autoincrement,"+
                "descdoc varchar(40))")

        db.execSQL("create table tb_categorias("+
                "idcategorias integer primary key,"+
                "idcategoriapadre int,"+
                "desccategoria  varchar(40),"+
                "idestado int)")

        db.execSQL("create table tb_laboratorio("+
                "idlaboratorio integer primary key ,"+
                "deslaboratorio varchar(60),"+
                "idestado int)")

        db.execSQL("create table tb_producto("+
                "idproducto integer primary key autoincrement,"+
                "idlaboratorio int references tb_laboratorio(idlaboratorio)," +
                "idcategorias int references tb_categorias(idcategorias),"+
                "nombreproducto varchar(100)," +
                "detalleproducto varchar(700),"+
                "tipopresentacion varchar(50),"+
                "precioproducto double,"+
                "urlproducto varchar(200))")

        db.execSQL("create table tb_cliente("+
                "idcliente integer primary key autoincrement,"+
                "apellidopat varchar(50),"+
                "apellidomat varchar(50),"+
                "nombre varchar(80),"+
                "iddoc int references tb_tipodocumento(iddoc),"+
                "documento char(10),"+
                "fechnac date,"+
                "tiposexo char(1),"+
                "usuario varchar(60),"+
                "clave varchar(60))")

        //DATOS
        db.execSQL("insert into tb_cliente values (2,'Sancho','Rivas','Rosa',1,'47199186','1990/07/08','F','rosa_18@gmail.com','rosa123')")
        db.execSQL("insert into tb_tipodocumento values" +
                "(1,'Dni'),(2,'Carnet de Extranjería'),(3,'Pasaporte');")
        db.execSQL("insert into tb_laboratorio values" +
               "(null,'Medifarma S.A.',1),(null,'Bayer S.A.',1),(null,'B. Braun Medical Perú S.A.',1),(null,'Cifarma S.A.',1),(null,'Jhonson & Jhonson',1),\n" +
                "(null,'Laboratorio Astrazeneca',1),(null,'Laboratorios Bagó',1),(null,'Laboratorios Induquimica S.A.',1),\n" +
                "(null,'Alcon Pharmaceutical Perú',1),(null,'Brisafarma S.A.C',1),(null,'Deutsche Pharma S.A.C',1),(null,'Genzyme Perú S.A.C',1),(null,'Laboratorios Americanos - Labot',1),\n" +
                "(null,'Laboratorios Farmaindustria',1),(null,'Laboratorios Hersil',1),(null,'Laboratorios Lansier',1),(null,'Laboratorios Roche',1),(null,'Química Suiza',1)")
        db.execSQL("insert into tb_categorias values" +
                "(1,null, 'Farmacia', 1),(2,1, 'Malestar Estomacal', 1),(3,1, 'Dolor Generalizado', 1),(4,1,'Malestar General',1),(5,1,'Resfríado Común',1),\n" +
                "(6,1,'Cuidado Muscular',1),(7,null,'Cuidado Personal',1),(8,7,'Cuidado Bucal',1),(9,7,'Cuidado del Cabello',1),(10,7,'Desodorante',1),\n" +
                "(11,7,'Bienestar Sexual',1),(12,7,'Cuidado de la Piel',1),(13,null,'Cuidado del Bebé',1);")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }


}