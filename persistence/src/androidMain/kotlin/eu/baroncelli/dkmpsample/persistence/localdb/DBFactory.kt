package com.fieldontrack.kmm.persistence.localdb

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.fieldontrack.kmm.coreinterfaces.DataBase
import mylocal.db.LocalDb


fun createAndroidDB(context: Context): DataBase{
    val sqlDriver = AndroidSqliteDriver(LocalDb.Schema, context, "Local.db")
    return LocalDataBase(LocalDb(sqlDriver))

}