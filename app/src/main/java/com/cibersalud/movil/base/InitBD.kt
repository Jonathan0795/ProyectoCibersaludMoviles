package com.cibersalud.movil.base

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.aplicacioncolegio.utils.appConfig

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
        db.execSQL("insert into tb_tipodocumento values" +
                "(1,'Dni'),(2,'Carnet de Extranjería'),(3,'Pasaporte');")
        db.execSQL("insert into tb_laboratorio values" +
                "(1,null,'Colgate-Palmolive',null,null,1),\n" +
                "(2,1,'Colgate','Disfruta en un mundo de salud e higiene bucal completa para ti toda tu familia. Los productos Colgate fueron desarrollados especialmente para ayudarte con la limpieza y cuidado dental, mientras combate el mal aliento, fortalece el esmalte, previene las caries, placa bacteriana y más. Protege tu sonrisa y felicidad con Colgate.',\n" +
                "'Colgate.jpg',1),\n" +
                "(3,1,'Palmolive','Explora diferentes formas de consentirte y celebrarte cada día con estos mágicos rituales de belleza y bienestar. La naturaleza es poderosa. Descubre los beneficios de los ingredientes naturales para el cuidado del cuerpo y aprovéchalos al máximo.',\n" +
                "'palmolive.png',1),\n" +
                "(4,1,'Speed Stick','Prepárate para afrontar tu día libre de sudor, con los antitranspirantes Speed Stick. Sus exclusiva formulas protegen tus axilas contra el sudor y mal olor por 48 horas, haciéndote sentir autónomo y seguro en tu rutina diaria.',\n" +
                "'SpeedStick.jpg',1),\n" +
                "(5,1,'Lady Speed Stick','Speed Stick Desodorante fueron desarrollados por expertos para brindarte calidad, seguridad, confianza, fragancia y el cuidado que necesitas para tu piel. Speed Stick Desodorante Controla el olor Inhibe las enzimas responsables de la degradación del sudor y, gracias a su poder antiadhesivo, controla el olor corporal.',\n" +
                "'ladyspeedstick.jpg',1),\n" +
                "(6,1,'Protex','Máxima protección y cuidado para tu piel con Protex. Los productos Protex fueron diseñados especialmente para brindarte máxima calidad, seguridad e higiene personal para toda tu familia, 10 veces más protección contra bacterias que los jabones ordinarios.',\n" +
                "'Protex.png',1),\n" +
                "(7,null,'Unilever','null','null',1),\n" +
                "(8,7,'Rexona','La marca Rexona es líder en desodorantes y está presente en más de 100 países alrededor del mundo. Fueron diseñados con fórmulas innovadoras para protegerte de los efectos del sudor, aportando seguridad y cuidado personal. La misión de Rexona es hacerte sentir imparable en tu día a día, proporcionando frescura cuando más lo necesitas. Encuentra y disfruta de todas las promociones en Inkafarma, porque Rexona nunca te abandona.',\n" +
                "'Rexona.jpg',1),\n" +
                "(9,7,'Axe','Explora, disfruta y siente la magia de Axe, especializados en el cuidado personal masculino desde 1983. Los productos Axe fueron diseñados para ayudar a todos los hombres, brindándoles seguridad, protección, cuidado, estilo y fragancias irresistibles. Descubre antitranspirantes, desodorantes, body spray y mucho más.',\n" +
                "'Axe.png',1),\n" +
                "(10,7,'Dove','Bienvenido al mundo Dove en Inkafarma, ecuentra los mejores productos y promociones para la higiene, cuidado personal y belleza. Dove desarrollados, especialmente, para brindarte protección, calma, tratamiento e hidratación para tu piel o cabello según tus necesidades. Jabones, desodorantes, shampoos, antitranspirantes, cremas faciales, corporales, acondicionadores y más con Dove',\n" +
                "'Dove.jpg',1),\n" +
                "(11,7,'Pond’s','Bienvenida a un mundo de belleza, cuidado de la piel y más de 150 años de experiencia. Los productos Pond’s fueron diseñados, especialmente, para brindarte una piel hermosa, limpia, suave y radiante, en cualquier momento y para cualquier edad.',\n" +
                "'Ponds.jpg',1);")
        db.execSQL("insert into tb_categorias values" +
                "(1,null, 'Farmacia', 1),(2,1, 'Malestar Estomacal', 1),(3,1, 'Dolor Generalizado', 1),(4,1,'Malestar General',1),(5,1,'Resfríado Común',1),\n" +
                "(6,1,'Cuidado Muscular',1),(7,null,'Cuidado Personal',1),(8,7,'Cuidado Bucal',1),(9,7,'Cuidado del Cabello',1),(10,7,'Desodorante',1),\n" +
                "(11,7,'Bienestar Sexual',1),(12,7,'Cuidado de la Piel',1),(13,null,'Cuidado del Bebé',1);")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }


}