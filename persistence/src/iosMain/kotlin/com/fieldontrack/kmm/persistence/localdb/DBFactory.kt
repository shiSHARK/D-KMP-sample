package com.fieldontrack.kmm.persistence.localdb

import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import mylocal.db.LocalDb

fun createIosDB(): LocalDataBase {
    val sqlDriver = NativeSqliteDriver(LocalDb.Schema, "Local.db")
    return LocalDataBase(LocalDb(sqlDriver))
}
