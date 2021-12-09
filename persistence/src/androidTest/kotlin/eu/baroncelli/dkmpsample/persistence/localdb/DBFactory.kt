package eu.baroncelli.dkmpsample.persistence.localdb

import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import eu.baroncelli.dkmpsample.coreinterfaces.DataBase
import mylocal.db.LocalDb

fun createAndroidTestDB(): DataBase {
    val sqlDriver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
    LocalDb.Schema.create(sqlDriver)
    return LocalDataBase(LocalDb(sqlDriver))

}