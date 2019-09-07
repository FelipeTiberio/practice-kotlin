package com.felipe.ea_02

import java.io.Serializable
import java.util.*

class Person(var nome :String,
             var lastname : String,
             var age : Int,
             var birthday : Date
             ) : Serializable
{}