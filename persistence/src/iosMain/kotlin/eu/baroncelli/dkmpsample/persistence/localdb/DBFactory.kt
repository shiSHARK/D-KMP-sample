package eu.baroncelli.dkmpsample.persistence.localdb

import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import eu.baroncelli.dkmpsample.coreinterfaces.DataBase
import mylocal.db.LocalDb

fun createIosDB(): LocalDataBase {
    val sqlDriver = NativeSqliteDriver(LocalDb.Schema, "Local.db")
    return LocalDataBase(LocalDb(sqlDriver))
}
