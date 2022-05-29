## Singleton

The Singleton pattern is generally implemented in this way:

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

However, there is a better way to implement the Singleton pattern in Java, and that is achieved through using enum.\
This way we are protected against malicious attacks (such as a serialization attack) and there is always a guarantee that there is exactly one instance.\
Reference: Effective Java 3rd edition Item 3\
Serialization attack: Effective Java 3rd edition Item 89

## Command pattern

The command pattern is very useful where we have a GUI application. This time around the MagicBoard acts as a GUI for
Santa Claus.

## Usage of class Class<T> instead of String

The usage of strings as an information source is not recommended and should be avoided. That is why I used class tokens.\
We could also use an enum.
Reference: Effective Java 3rd edition Item 62