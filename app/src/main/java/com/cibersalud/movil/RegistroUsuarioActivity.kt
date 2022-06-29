package com.cibersalud.movil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.cibersalud.movil.Controlador.ArregloCliente
import com.cibersalud.movil.Controlador.ArregloTipoDocumento
import com.cibersalud.movil.Entidad.Cliente

class RegistroUsuarioActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var edtApePat: EditText
    lateinit var edtApeMat: EditText
    lateinit var edtnombre: EditText
    lateinit var spnTipDoc: Spinner
    lateinit var edtdocume: EditText
    lateinit var edtfecNac: EditText
    lateinit var spnsexo: Spinner
    lateinit var edtusuario: EditText
    lateinit var edtcontra: EditText
    lateinit var btnRegis: Button
    lateinit var btnVolver: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrousuario)
        edtApePat = findViewById(R.id.edtApePat)
        edtApeMat = findViewById(R.id.edtApeMat)
        edtnombre = findViewById(R.id.edtNombre)
        spnTipDoc = findViewById(R.id.spnTipoDoc)
        edtdocume = findViewById(R.id.edtDocume)
        edtfecNac = findViewById(R.id.edtFecha)
        spnsexo = findViewById(R.id.spnSexo)
        edtusuario = findViewById(R.id.edtUser)
        edtcontra = findViewById(R.id.edtPass)

        btnRegis = findViewById(R.id.btnRegistrar)
        btnVolver = findViewById(R.id.btnRegresar)

        btnRegis.setOnClickListener(this);
        btnVolver.setOnClickListener(this);

        mostrarTipoDocumento()
    }

    override fun onClick(v: View?) {
        if (v == btnRegis) {
            var apellidopat=edtApePat.text.toString()
            var apellidomat=edtApeMat.text.toString()
            var nombre=edtnombre.text.toString()
            var iddoc=spnTipDoc.selectedItemPosition+1
            var documento=edtdocume.text.toString()
            var fechnac=edtfecNac.text.toString()
            var tiposexo=spnsexo.selectedItem.toString()
            var usuario=edtnombre.text.toString()
            var clave=edtcontra.text.toString()

            val bean=Cliente(0,apellidopat,apellidomat,nombre,iddoc,documento,
                fechnac,tiposexo,usuario,clave)
            var salida=ArregloCliente().crearCliente(bean)
            if(salida!=-1) {
                Toast.makeText(this, "Cliente registrado", Toast.LENGTH_LONG).show()
                val intent= Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
            else
                Toast.makeText(this, "Error en el registro", Toast.LENGTH_LONG).show()
        }
        else if(v==btnVolver){
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
    fun mostrarTipoDocumento(){
        var datos=ArregloTipoDocumento().listadoDocumento()
        var lista=ArrayList<String>()
        for (bean in datos){
            lista.add(bean.getDescripcion())
        }
        val adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,lista)
        spnTipDoc.adapter=adapter
    }
}