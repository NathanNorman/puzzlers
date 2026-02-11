# Puzzlers

A collection of Java puzzlers -- short programs with surprising or tricky behavior.

## What's Here

| File | Description |
|------|-------------|
| `src/MyAbcs.java` | The ABC song puzzler -- what happens when you concatenate to a `null` String? |

## Building and Running

Requires JDK 11 or later.

```bash
# Compile
javac -d out src/*.java

# Run
java -cp out MyAbcs
```

## Running Tests

```bash
# Compile everything
javac -d out src/*.java
javac -d out -cp out test/*.java

# Run tests
java -cp out MyAbcsTest
```

## The Puzzler

Try to predict the output of `MyAbcs.java` before running it. The answer may surprise you!

<details>
<summary>Hint</summary>

What happens when you use `+=` on a `null` String reference?

</details>

## License

Apache License 2.0 -- see [LICENSE](LICENSE).
