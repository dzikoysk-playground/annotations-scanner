# Annotations Scanner
The lightweight and actively developed alternative to [reflections](https://github.com/ronmamo/reflections). 
Source code is partly based on the reflections library to avoid repeating the same mistakes.

### Install
Library is available in `panda-repository` Maven repository:

```xml
<repository>
    <id>panda-repository</id>
    <url>https://repo.panda-lang.org/releases</url>
</repository>
```

To use `annotations`, declare the dependency in your `pom.xml`

```xml
<dependency>
    <groupId>org.panda-lang.utilities</groupId>
    <artifactId>annotations</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Usage
Firstly, you have to create `AnnotationsScanner` which keeps a collection of added sources to scan

```java
AnnotationsScanner scanner = AnnotationsScanner.createScanner()
        .includeSources(Main.class)
        .build();
```

Search is based on `AnnotationsScannerProcess`, the process will only collect the classes of interest to you and cache them for some future queries

```java
AnnotationsScannerProcess process = scanner.createWorker()
        .addDefaultProjectFilters("org.example")
        .fetch();
```

Now, you can finally select annotated classes

```java
Set<Class<?>> classes = process.createSelector().selectTypesAnnotatedWith(AnnotationTest.class);
```

You can also select subtypes of classes, `AnnotationsScannerProcess` contains prepared inheritance map

```java
Set<Class<?>> classes = process.createSelector().selectSubtypesOf(Object.class);
```

You also should be able to create custom selector, like:

```java
Set<Class<?>> classes = process.createSelector().select(new AnnotationsSelector() {
    @Override
    public Collection<String> select(AnnotationsScannerProcess process, AnnotationScannerStore store) {
        return null;
    }
})
```
