package com.cibersalud.movil.Adaptador

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cibersalud.movil.R

class VistaCliente (itemView: View)   : RecyclerView.ViewHolder(itemView){
    var tvCodigoR: TextView
    var tvNombresR: TextView
    var tvPaternoR: TextView
    var tvMaternoR: TextView
    var tvUsuarioR: TextView
    var btnDetalleR: Button
    init{
        tvCodigoR=itemView.findViewById(R.id.tvCodigoR)
        tvNombresR=itemView.findViewById(R.id.tvNombresR)
        tvPaternoR=itemView.findViewById(R.id.tvPaternoR)
        tvMaternoR=itemView.findViewById(R.id.tvMaternoR)
        tvUsuarioR=itemView.findViewById(R.id.tvUsuarioR)
        btnDetalleR=itemView.findViewById(R.id.btnDetalleR)
    }
}