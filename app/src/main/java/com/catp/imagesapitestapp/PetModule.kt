package com.catp.imagesapitestapp

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class PetModule {

    @Provides
    @Named("CATName")
    fun name(): String = "meow"
    @Provides
    @Named("DOGName")
    fun name2(): String = "auf"

    @Provides
    @Named("CAT")
    fun catItem(@Named("CATName") name: String): Pet = Cat(name)

    @Provides
    @Named("DOG")
    fun dogItem(@Named("DOGName") name: String): Pet = Dog(name)

}