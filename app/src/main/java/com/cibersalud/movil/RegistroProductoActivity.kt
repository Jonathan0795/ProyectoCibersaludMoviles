package com.cibersalud.movil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.cibersalud.movil.Controlador.*
import com.cibersalud.movil.Entidad.Cliente
import com.cibersalud.movil.Entidad.Producto

class RegistroProductoActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var spnLabo: Spinner
    lateinit var spnCatego: Spinner
    lateinit var edtNomPro: EditText
    lateinit var edtDetPro: EditText
    lateinit var edtTipPre: EditText
    lateinit var edtPre: EditText
    lateinit var btnRegisPro: Button
    lateinit var btnVolverPro: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registroproducto)
        spnLabo = findViewById(R.id.spnLaboratorio)
        spnCatego = findViewById(R.id.spnCategoria)
        edtNomPro = findViewById(R.id.edtNombrePro)
        edtDetPro = findViewById(R.id.edtDetallePro)
        edtTipPre = findViewById(R.id.edtTipoPrese)
        edtPre = findViewById(R.id.edtPrecio)

        btnRegisPro = findViewById(R.id.btnRegistrarPro)
        btnVolverPro = findViewById(R.id.btnRegresarPro)

        btnRegisPro.setOnClickListener(this);
        btnVolverPro.setOnClickListener(this);

        mostrarLaboratorio()
        mostrarCategoria()
    }

    override fun onClick(v: View?) {
        if (v == btnRegisPro) {
            var idlaboratorio=spnLabo.selectedItemPosition+1
            var idcategorias=spnCatego.selectedItemPosition+1
            var nombreproducto=edtNomPro.text.toString()
            var detalleproducto=edtDetPro.text.toString()
            var tipopresentacion=edtTipPre.text.toString()
            var precioproducto=edtPre.text.toString().toDouble()

            val bean=Producto(0,idlaboratorio,idcategorias,nombreproducto,detalleproducto,
                tipopresentacion,precioproducto,"")
            var salida=ArregloProducto().crearProducto(bean)
            if(salida!=-1) {
                Toast.makeText(this, "Producto registrado", Toast.LENGTH_LONG).show()
                val intent= Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
            else
                Toast.makeText(this, "Error en el registro", Toast.LENGTH_LONG).show()
        }
        else if(v==btnVolverPro){
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
    fun mostrarLaboratorio(){
        var datos=ArregloLaboratorio().listadoLaboratorio()
        var lista=ArrayList<String>()
        for (bean in datos){
            lista.add(bean.getdescripcionLabo())
        }
        val adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,lista)
        spnLabo.adapter=adapter
    }

    fun mostrarCategoria(){
        var datos=ArregloCategoria().listadoCategoria()
        var lista=ArrayList<String>()
        for (bean in datos){
            lista.add(bean.getdescripcionCate())
        }
        val adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,lista)
        spnCatego.adapter=adapter
    }
}