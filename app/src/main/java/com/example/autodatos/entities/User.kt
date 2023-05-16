package com.example.autodatos.entities

import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore

@Entity(tableName = "users")
class User(id: Int,name: String, car: String, falla:String) {
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "id")
    var id: Int

    @ColumnInfo(name = "name")
    var name: String

    @ColumnInfo(name = "car")
    var car: String

    @ColumnInfo(name = "falla")
    var falla: String

    init {
        this.id = id
        this.name = name
        this.car = car
        this.falla = falla
    }

}