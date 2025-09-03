![Expression Evaluator](docs/assets/expression-evaluator)

Tiny Java library that parses and evaluates arithmetic expressions with support for variables and parentheses. Includes a lightweight, zero-dependency test runner.

## 🧠 What Is An Expression Evaluator?

An expression evaluator reads a mathematical expression (like `3 + 4 * (2 - 1)`) and computes its numeric result. This project parses standard infix notation, converts it to postfix (Reverse Polish) form, and then evaluates it. It also supports substituting variables in an expression with numeric values at runtime.

## ✨ Features

- Infix parsing with `+`, `-`, `*`, `/` and parentheses
- Shunting-Yard to postfix conversion, then stack-based evaluation
- Optional variables via `Map<String, Double>` substitution
- Lightweight custom test runner (no external build tool required)

## 🧰 Prerequisites

- Java JDK 17+ installed (`java`/`javac` on PATH)

## 🚀 Run (CLI)

Compile sources and run the tests using only `javac`/`java`.

Unix/macOS (bash/zsh):

```
mkdir -p out/production out/test
find src/main/java -name "*.java" > main-sources.txt
javac -d out/production @main-sources.txt

find src/test/java -name "*.java" > test-sources.txt
javac -cp out/production -d out/test @test-sources.txt

cp -r src/test/resources/* out/test/
java -cp "out/production:out/test" dev.gutemberg.test.runner.TestRunner
```

Windows (PowerShell):

```
New-Item -ItemType Directory -Force out/production,out/test | Out-Null
Get-ChildItem -Recurse src/main/java -Filter *.java | ForEach-Object FullName > main-sources.txt
javac -d out/production @main-sources.txt

Get-ChildItem -Recurse src/test/java -Filter *.java | ForEach-Object FullName > test-sources.txt
javac -cp out/production -d out/test @test-sources.txt

Copy-Item -Recurse src/test/resources/* out/test/
java -cp "out\production;out\test" dev.gutemberg.test.runner.TestRunner
```

You should see the test names, progress, and a final success line.

## 📎 Quick Usage

Evaluating a literal expression:

```java
double value = ExpressionEvaluator.evaluate("3 + 4 * (2 - 1)");
// -> 7.0
```

Evaluating with variables:

```java
double value = ExpressionEvaluator.evaluate(
    "(a + b * c) / d",
    Map.of("a", 10.0, "b", 2.0, "c", 5.0, "d", 4.0)
);
// -> 5.0
```

Note: Variables are replaced before parsing; variable names should not conflict with numeric characters and operators.
