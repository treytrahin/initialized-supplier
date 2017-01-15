# Initialized Supplier

Supplier that initializes with a provided function once and from then on returns the initialized value.


## Why?
Because I hate seeing this:
```java
if (this.someVar == null) {
    this.someVar = initializeSomeVar();
}
this.someVar.doSomething();
```

## Usage
```java
public class Example {
    private InitializedSupplier<String> myVar = new InitializedSupplier<>(this::initMyVar);
    
    public void doStuff() {
        System.out.println(myVar.get());
        System.out.println(myVar.get());
        System.out.println(myVar.get());
    }
    
    private String initMyVar() {
        System.out.println("Initialized");
        return "I like to move it move it.";
    }
}
```

When ```doStuff()``` the output is:

```
Initialized
I like to move it move it.
I like to move it move it.
I like to move it move it.
```
