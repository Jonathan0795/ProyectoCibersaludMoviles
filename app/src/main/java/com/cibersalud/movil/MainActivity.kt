package com.cibersalud.movil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cibersalud.movil.Adaptador.CustomAdapter
import com.cibersalud.movil.Controlador.ArregloCliente

class MainActivity : AppCompatActivity(), View.OnClickListener  {
    private lateinit var edtUsername: EditText;
    private lateinit var edtPassword: EditText;
    private lateinit var btnIngresar: Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtUsername=findViewById(R.id.edtUsername);
        edtPassword=findViewById(R.id.edtPassword);
        btnIngresar=findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(this)

    }
    override fun onClick(V: View?) {
        val intent= Intent(this, ClienteActivity::class.java)
        if(edtUsername.getText().toString().equals("admin") &&
            edtPassword.getText().toString().equals("admin")){
            Toast.makeText(this,"BIENVENIDO", Toast.LENGTH_LONG).show();
            startActivity(intent)
        }else{
            Toast.makeText(this,"USUARIO O CLAVE INCORRECTO", Toast.LENGTH_LONG).show();
        }

    }
}