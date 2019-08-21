package com.example.ea

import java.io.Serializable
import java.util.*


data class Person(val firsName : String,
                  val lastName : String,
                  var age:  Int,
                  val birthDate: Date) : Serializable{

}