package com.fieldontrack.kmm.persistence.localdb

import com.fieldontrack.kmm.common.DataBase
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import mylocal.db.LocalDb

fun createAndroidTestDB(): DataBase {
    val sqlDriver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
    LocalDb.Schema.create(sqlDriver)
    return LocalDataBase(LocalDb(sqlDriver))

}