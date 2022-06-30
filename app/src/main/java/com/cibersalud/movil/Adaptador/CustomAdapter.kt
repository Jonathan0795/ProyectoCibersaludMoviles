package com.cibersalud.movil.Adaptador

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.cibersalud.movil.ActualizarUsuarioActivity
import com.cibersalud.movil.Entidad.Cliente
import com.cibersalud.movil.R

class CustomAdapter(val info:ArrayList<Cliente>):RecyclerView.Adapter<VistaCliente>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VistaCliente {
        val vista= LayoutInflater.from(parent.context).
        inflate(R.layout.item_cliente,parent,false)

        return VistaCliente(vista)
    }

    override fun onBindViewHolder(holder: VistaCliente, position: Int) {

        holder.tvCodigoR.text = info.get(position).codigoCli.toString()
        holder.tvNombresR.text = info.get(position).nombre
        holder.tvPaternoR.text = info.get(position).paterno
        holder.tvMaternoR.text = info.get(position).materno
        holder.tvUsuarioR.text = info.get(position).usuario

        var context: Context = holder.itemView.context

        holder.btnDetalleR.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            val view = LayoutInflater.from(context).inflate(R.layout.activity_detallecliente, null)
            builder.setView(view)
            var tvCodigo: TextView = view.findViewById(R.id.tvDetalleCodigo)
            var tvNombre: TextView = view.findViewById(R.id.tvDetalleNombre)
            var tvPaterno: TextView = view.findViewById(R.id.tvDetallePaterno)
            var tvMaterno: TextView = view.findViewById(R.id.tvDetalleMaterno)
            var tvUsuario: TextView = view.findViewById(R.id.tvUsuario)
            var btnCerrar: Button = view.findViewById(R.id.btnCerrar)
            tvCodigo.setText("CODIGO : " + info.get(position).codigoCli.toString())
            tvNombre.setText("NOMBRE : " + info.get(position).nombre)
            tvPaterno.setText(info.get(position).paterno)
            tvMaterno.setText(info.get(position).materno)
            tvUsuario.setText(info.get(position).usuario)

            val dialog = builder.create();
            dialog.show()

            btnCerrar.setOnClickListener {
                dialog.dismiss()
            }
        }
            holder.itemView.setOnClickListener {
                val intent = Intent(context, ActualizarUsuarioActivity::class.java)
                intent.putExtra("cliente", info.get(position))
                ContextCompat.startActivity(context, intent, null)

            }

        }

    override fun getItemCount(): Int {
        return info.size
    }
}