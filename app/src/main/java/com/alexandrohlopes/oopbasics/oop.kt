package com.alexandrohlopes.oopbasics

fun main() {
    var alexandro = Person("Alexandro", "Hugo Lopes", 40) // Creates a new instance overwriting the data in the main constructor
    alexandro.stateHobby() // The instance will receive as hobby attribute whatever is given on the constructor.
    println("Alexandro's age is ${alexandro.age}")
    var alexandroCar = Car()
    alexandroCar.owner = "Alexandro"
    alexandroCar.brand = "Lamborghini"
    alexandroCar.maxSpeed = 400
    //alexandroCar.model = "Veneno" // You cannot alter the attribute because it's private - it can only be altered inside the class.
    println("${alexandroCar.owner}'s car is a ${alexandroCar.brand} with a max speed of ${alexandroCar.maxSpeed} and it's a ${alexandroCar.model}")
    // Since the getter isn't private, you can read the data of the attribute.
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
    var hobby : String = "to watch Crunchyroll"
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
        println("$firstName's hobby is $hobby")
    }
}

class Car() {
    lateinit var owner : String // Allows setting the variable later. If the developer forgets it, the compiler will throw an exception.

    var brand : String = "BMW"
    get() { // Custom getter
        return field.lowercase() // Converts the brand name to lowercase letters.
    }

    var maxSpeed : Int = 200
    // Kotlin sets default getters and setters that cover most uses.
    set(value) {
        field = if (value > 0) value else throw java.lang.IllegalArgumentException("Max speed cannot be lower than zero.")
    }

    var model : String = "Beetle"
        private set

    init {
        this.owner = "Frank"
        this.model = "Veneno"
    }
}