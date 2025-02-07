package com.aejill.uekat_myapp2.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usersTable")
data class User(
    @PrimaryKey @ColumnInfo(name = "user_id") val user_id: Int,
    @ColumnInfo(name = "user_name") val user_name: String,
    @ColumnInfo(name = "user_username") val user_username: String,
    @ColumnInfo(name = "user_email") val user_email: String,
    @ColumnInfo(name = "address_street") val address_street: String,
    @ColumnInfo(name = "address_suite") val address_suite: String,
    @ColumnInfo(name = "address_city") val address_city: String,
    @ColumnInfo(name = "address_zipcode") val address_zipcode: String,
    @ColumnInfo(name = "address_geo_lat") val address_geo_lat: String,
    @ColumnInfo(name = "address_geo_lng") val address_geo_lng: String,
    @ColumnInfo(name = "company_name") val company_name: String,
    @ColumnInfo(name = "company_catchPhrase") val company_catchPhrase: String,
    @ColumnInfo(name = "company_bs") val company_bs: String,
    @ColumnInfo(name = "user_phone") val user_phone: String,
    @ColumnInfo(name = "user_website") val user_website: String
)