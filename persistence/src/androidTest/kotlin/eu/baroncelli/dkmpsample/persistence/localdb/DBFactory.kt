package com.fieldontrack.kmm.persistence.localdb

import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import com.fieldontrack.kmm.coreinterfaces.DataBase
import mylocal.db.LocalDb

fun createAndroidTestDB(): DataBase {
    val sqlDriver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
    LocalDb.Schema.create(sqlDriver)
    return LocalDataBase(LocalDb(sqlDriver))

}