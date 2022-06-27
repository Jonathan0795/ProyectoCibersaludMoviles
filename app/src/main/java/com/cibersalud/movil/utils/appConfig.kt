package com.example.aplicacioncolegio.utils

import android.app.Application
import android.content.Context
import com.cibersalud.movil.base.InitBD

class appConfig: Application() {
    companion object{
        lateinit var CONTEXT:Context
        var BD_NAME="cibersalud.bd"
        var VERSION=1
        lateinit var BD: InitBD
    }

    override fun onCreate() {
        super.onCreate()
        CONTEXT=applicationContext
        BD=InitBD()
    }
}