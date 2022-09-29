package com.alexandrohlopes.oopbasics

fun main() {
    var alexandro = Person("Alexandro", "Hugo Lopes") // Creates a new instance overwriting the data in the main constructor
    var johnDoe = Person() // Creates a new instance using the data in the main constructor
    var johnPeterson = Person(lastName = "Peterson") // Creates a new instance overwriting the data in lastName only
}

class Person (firstName : String = "John", lastName : String = "Doe") {
// This is how we create classes. The values between parenthesis are part of the main constructor.

    init { // Class initializer. This code will run everytime an instance is created.
        println("The person $firstName $lastName was created.")
    }
}