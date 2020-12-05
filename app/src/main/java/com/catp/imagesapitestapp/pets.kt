package com.catp.imagesapitestapp

import androidx.navigation.Navigator
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

open class Pet(val name: String)

@Singleton
@Named("CAT")
class Cat@Inject constructor(name:String): Pet(name)
@Singleton
@Named("DOG")
class Dog@Inject constructor(name:String): Pet(name)

class Box<T:Pet>(val myPet:T)

@Singleton
class MyRoom @Inject constructor(@Named("CAT")val cat: Pet,@Named("DOG") val dog: Pet)