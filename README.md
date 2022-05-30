## Singleton

The **Singleton** pattern is usually implemented like this:

```java

class SantaClaus {
    private static final SantaClaus instance = new SantaClaus();

    private SantaClaus() {
    }

    public SantaClaus getInstance() {
        return instance;
    }
}
```

However, there is a better way to implement the **Singleton** pattern in **Java**, and that is achieved through using **enum**.
This way we are protected against malicious attacks (such as a serialization attack) and there is always a guarantee
that there is exactly one instance.\

There are several singletons in this app:
* [Santa Claus](src/me/cal1br/santaworkshop/entity/SantaClaus.java)
* [Magic board](src/me/cal1br/santaworkshop/entity/MagicBoard.java)
* [Workshop](src/me/cal1br/santaworkshop/entity/Workshop.java)
* [Factory Provider](src/me/cal1br/santaworkshop/factory/AbstractFactory.java)

*Reference: Effective Java 3rd edition Item 3*\
*Serialization attack: Effective Java 3rd edition Item 89*
## Command pattern

The **command** pattern is very useful where we have a GUI application. Thanks to it, we can avoid huge amounts of code duplication.\
It must contain all the information necessary for its execution.

[Link to the command pattern package](src/me/cal1br/santaworkshop/command)

## Abstract Factory

**Factories** are really useful when we have to abstract away the creation of objects.\
Let's say we would like to have an OS dependant button *Button* object *(e.g. Android and iOS)*.
We can use a **factory** to abstract away this initialization and use a common **interface** for the objects.

[Link to factory package](src/me/cal1br/santaworkshop/factory)

#### Initialization note
Factories usually are initialized on startup, however in this app we don't have the necessary
tools at our disposal. That is why we do it manually.

## Observer & Publisher

Using this pattern, we can have many objects, react to a change of state of a `Publisher` object. The `Publisher` holds references to these `Observers` and calls their `update()` method, which is a part of the `Observer` interface.\
In this app, after seeing the magic board update, the [Elves](src/me/cal1br/santaworkshop/entity/Elf.java) get to work and create the requested `Toy`.
The *Elves* observe the `MagicBoard`.

## Usage of Class Tokens instead of String

The usage of strings as an information source is **not recommended** and **should be avoided**. That is why I used class tokens.
We could also use an enum instead of a class token.\
*Reference: Effective Java 3rd edition Item 62*