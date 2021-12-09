package eu.baroncelli.dkmpsample.persistence.localdb

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import eu.baroncelli.dkmpsample.coreinterfaces.DataBase
import mylocal.db.LocalDb


fun createAndroidDB(context: Context): DataBase{
    val sqlDriver = AndroidSqliteDriver(LocalDb.Schema, context, "Local.db")
    return LocalDataBase(LocalDb(sqlDriver))

}