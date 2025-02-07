package com.aejill.uekat_myapp2.data.classes

data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: Geo
)