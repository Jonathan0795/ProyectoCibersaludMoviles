package com.cibersalud.movil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cibersalud.movil.Adaptador.CustomAdapter
import com.cibersalud.movil.Controlador.ArregloCliente

class ClienteActivity : AppCompatActivity() ,View.OnClickListener {
    private lateinit var rvClientes: RecyclerView
    lateinit var btnNuevo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente)
        rvClientes=findViewById(R.id.rvCliente)
        btnNuevo=findViewById(R.id.btnNuevo)

        btnNuevo.setOnClickListener(this);
        var lista=ArregloCliente().listadoCliente()
        var adaptador=CustomAdapter(lista)
        rvClientes.layoutManager= LinearLayoutManager(this)
        rvClientes.adapter=adaptador
    }
    override fun onClick(v: View?) {
        val intent= Intent(this,RegistroUsuarioActivity::class.java)
        startActivity(intent)
    }

}