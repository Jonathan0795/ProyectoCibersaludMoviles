package com.cibersalud.movil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.cibersalud.movil.Controlador.ArregloCliente
import com.cibersalud.movil.Controlador.ArregloTipoDocumento
import com.cibersalud.movil.Entidad.Cliente

class ActualizarUsuarioActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var tvCodigoA: TextView
    lateinit var edtApePatA: EditText
    lateinit var edtApeMatA: EditText
    lateinit var edtnombreA: EditText
    lateinit var spnTipDocA: Spinner
    lateinit var edtdocumeA: EditText
    lateinit var edtfecNacA: EditText
    lateinit var spnsexoA: Spinner
    lateinit var edtusuarioA: EditText
    lateinit var edtcontraA: EditText
    lateinit var btnActuaA: Button
    lateinit var btnVolverA: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizarusuario)
        tvCodigoA =findViewById(R.id.tvCodigoA)
        edtApePatA = findViewById(R.id.edtApePatA)
        edtApeMatA = findViewById(R.id.edtApeMatA)
        edtnombreA = findViewById(R.id.edtNombreA)
        spnTipDocA = findViewById(R.id.spnTipoDocA)
        edtdocumeA = findViewById(R.id.edtDocumeA)
        edtfecNacA = findViewById(R.id.edtFechaA)
        spnsexoA = findViewById(R.id.spnSexoA)
        edtusuarioA = findViewById(R.id.edtUserA)
        edtcontraA = findViewById(R.id.edtPassA)

        btnActuaA = findViewById(R.id.btnActualizar)
        btnVolverA = findViewById(R.id.btnRegresar)

        btnActuaA.setOnClickListener(this);
        btnVolverA.setOnClickListener(this);

        mostrarTipoDocumento()
        datos()
    }

    override fun onClick(v: View?) {
        if (v == btnActuaA) {
            var idcliente=tvCodigoA.text.toString().toInt()
            var apellidopat=edtApePatA.text.toString()
            var apellidomat=edtApeMatA.text.toString()
            var nombre=edtnombreA.text.toString()
            var iddoc=spnTipDocA.selectedItemPosition+1
            var documento=edtdocumeA.text.toString()
            var fechnac=edtfecNacA.text.toString()
            var tiposexo=spnsexoA.selectedItem.toString()
            var usuario=edtnombreA.text.toString()
            var clave=edtcontraA.text.toString()

            val bean=Cliente(idcliente,apellidopat,apellidomat,nombre,iddoc,documento,
                fechnac,tiposexo,usuario,clave)
            var salida=ArregloCliente().editarCliente(bean)
            if(salida!=-1) {
                Toast.makeText(this, "Cliente actualizado", Toast.LENGTH_LONG).show()
                val intent= Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
            else
                Toast.makeText(this, "Error en el registro", Toast.LENGTH_LONG).show()
        }
        else if(v==btnVolverA){
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
        spnTipDocA.adapter=adapter
    }
    fun datos(){
        val bean=intent.getSerializableExtra("cliente") as Cliente
        tvCodigoA.setText(bean.codigoCli)
        edtApePatA.setText(bean.paterno)
        edtApeMatA.setText(bean.materno)
        edtnombreA.setText(bean.nombre)
        edtdocumeA.setText(bean.documento)
        edtfecNacA.setText(bean.nacimiento)
        edtusuarioA.setText(bean.usuario)
        edtcontraA.setText(bean.password)

        var sexo=bean.sexo
        var posSexo=-1;
        val adapter=spnsexoA.adapter
        for(i in 0 until adapter.count){
            if(adapter.getItem(i).equals(sexo))
                posSexo=i
        }
        spnsexoA.setSelection(posSexo)

        spnTipDocA.setSelection(bean.tipoDoc-1)
    }
}