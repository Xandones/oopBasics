package com.alexandrohlopes.oopbasics

fun main() {
    var alexandro = Person("Alexandro", "Hugo Lopes", 40) // Creates a new instance overwriting the data in the main constructor
    alexandro.stateHobby() // The instance will receive as hobby attribute whatever is given on the constructor.
    println("Alexandro's age is ${alexandro.age}")
    println()

    // The following instances (johnDoe and johnPeterson) aren't using the secondary constructor.
    var johnDoe = Person() // Creates a new instance using the data in the main constructor
    johnDoe.hobby = "to irritate people"
    johnDoe.stateHobby()
    println()

    var johnPeterson = Person(lastName = "Peterson") // Creates a new instance overwriting the data in lastName only
    johnPeterson.hobby = "to play with my children"
    johnPeterson.stateHobby()
}

class Person (firstName : String = "John", lastName : String = "Doe") {
// This is how we create classes. The values between parenthesis are part of the main constructor.

    // Attributes
    var age : Int? = null
    var hobby : String = "Watch Crunchyroll"
    var firstName : String? = null

    init { // Class initializer. This code will run everytime an instance is created.
        this.firstName = firstName
        println("The person $firstName $lastName was created.")
    }

    // Secondary constructor
    constructor(firstName : String, lastName : String, age : Int) : this(firstName,lastName) {
        this.age = age
        println("The person $firstName $lastName was created. Aged $age years old.")
    }

    // Methods
    fun stateHobby() {
        println("$firstName\'s hobby is $hobby")
    }
}