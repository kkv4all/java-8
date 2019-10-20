# Java 8 New Feature Practice
Java 8 was released in 18th March 2014. It was a revolutionary release of the Java for software development platform. It includes various upgrades to the Java programming, JVM, Tools and libraries. Java 8 is one of the most feature packed release in the Java history.

**Java 8 provides following New Features/Enhancements:**
 - Lambda Expressions
 - Method References,
 - Functional Interfaces
 - Default methods
 - Streams and Pipelines
 - Optional Class
 - StringJoiner
 - New Date API
 - Base64 Class
 - Nashorn Javascript Engine (jjs)

Here in this repository I have added Some Java 8 features examples: 

## Lambda Expression
Java 8 introduced very popular Lambda expressions. Lambda expressions gives the ability to pass a functionality as a method argument. Lambda expression help us reduce the code clutter in using a single method class.
  
Lambda Expression is Characterize by the following:
   - Optional Type Declaration
   - Optional parenthesis around parameter
   - Optional curly braces
   - Optional return statement

[Simple Example](https://github.com/kkv4all/java-8-practice/blob/master/src/com/java8/features/lambdaexp/LambdaExpression.java)

## Method Reference
Method reference helps to point to methods by their names. When we implement an interface, if we did not provide implementation for a method, then the default method will be used in that place. A method reference is described using :: symbol.

A method reference used to point the following type of methods - 
   - Static Methods 
   - Instance Methods
   - Constructor using new operator

[Simple Example](https://github.com/kkv4all/java-8-practice/blob/master/src/com/java8/features/methodref/MethodReference.java)

## Functional Interface
Functional interfaces are new additions in java 8 which permit exactly one abstract method inside them. These interfaces are also called _Single Abstract Method interfaces_ (SAM Interfaces). _@FunctionalInterface_ annotation is added so that we can mark an interface as functional interface and when the interface you have annotated violates the contracts of exactly one abstract method it will give compiler level errors .
 
Some of the useful java 8 functional interfaces are _**Consumer**_, _**Supplier**_, _**Function**_ and _**Predicate**_.

[Simple Example](https://github.com/kkv4all/java-8-practice/blob/master/src/com/java8/features/func_interface/FunctionalInterfaceTest.java)

## Default Method
Java 8 introduced concept of Default method implementation in interfaces. Default methods gives the ability to add default implementation for methods in an interface. When we implement an interface, if we did not provide implementation for a method, then the default method will be used in that place.
With default functions in interfaces, there is a possibility that a class is implementing two interfaces with same default methods. In such case 

[Simple Example](https://github.com/kkv4all/java-8-practice/blob/master/src/com/java8/features/func_interface/FunctionalInterfaceTest.java)

## Streams and Pipelines
Streams and Pipelines enrich the Java collections framework. Sequence of aggregate operations is a pipeline. Stream is used to propagate elements from a source through a pipeline. It is a sequence of elements. Streams and Pipelines will make our task easier in accessing the elements from collections and applying operations on it.
Stream supports aggregate operations like _filter_, _map_, _limit_, _reduce_, _find_, _match_ and so on.

Collection interface has two methods to generate a stream:
 - _**stream()**_ - Returns a sequential stream considering collection as its source.
 - _**parallelStream()**_ - Returns  parallel Stream considering collection as its source.

[Simple Example](https://github.com/kkv4all/java-8-practice/blob/master/src/com/java8/features/streams/Stream.java)

## Optional Class
Java 8 introduced a new class Optional. It is a public final class and used to deal with NullPointerException in Java application. It also provides various utility methods to facilitate code to handle values as 'available' or 'not available' instead of checking null.
 
[Simple Example](https://github.com/kkv4all/java-8-practice/blob/master/src/com/java8/features/optional/OptionTest.java)

## StringJoiner Class
Java 8 introduced a new final class StringJoiner in _**java.util**_ package. It is used to construct a sequence of characters separated by a delimiter. Now, you can create string by passing delimiters like comma(,), hyphen(-) etc. You can also pass prefix and suffix to the char sequence.

[Simple Example](https://github.com/kkv4all/java-8-practice/blob/master/src/com/java8/features/stringjoiner/StringJoinerTest.java)

## New Date API
Java 8 has introduced a new Date and Time API. The _**java.time**_ package contains Date and Time classes in Java 8.

Old Date API (java.util.Date) had some drawback:
 - Not thread safe
 - Poor Design
 - Difficult time zone handling

New Date API Java8(java.time) provides some classes:
 - _**Local**_ - Simplified date-time API with no complexity of timezone handling.
 - _**Zoned**_ - Specialized date-time API to deal with various timezones.
 - _**CronoUnit**_ - Enum added to replace integer values used in old APIs to represent day,month etc.
 - _**Period**_ - It deals with date based amount of time.
 - _**Duraton**_ - It deals with time based amount of time.
 - _**TemporalAdjusters**_ - It is used to perform the date mathematics.

[Simple Example](https://github.com/kkv4all/java-8-practice/blob/master/src/com/java8/features/datetimeapi/DateTimeAPI.java)

## Base64 Class
Java8 Java provides a class Base64 to deal with encryption and decryption. You need to import _**java.util.Base64**_ class in your source file to use its methods.

This class provides three different encoders and decoders to encrypt information at each level:
 - _**Simple**_ - It uses the Base64 alphabet specified by Java in RFC 4648 and RFC 2045 for encoding and decoding operations. The encoder does not add any line separator character. The decoder rejects data that contains characters outside the base64 alphabet.
 - _**URL**_ - It uses the Base64 alphabet specified by Java in RFC 4648 for encoding and decoding operations. The encoder does not add any line separator character. The decoder rejects data that contains characters outside the base64 alphabet.
 - _**MIME**_ - It uses the Base64 alphabet as specified in RFC 2045 for encoding and decoding operations. The encoded output must be represented in lines of no more than 76 characters each and uses a carriage return '\r' followed immediately by a linefeed '\n' as the line separator. No line separator is added to the end of the encoded output. All line separators or other characters not found in the base64 alphabet table are ignored in decoding operation.
 
[Simple Example](https://github.com/kkv4all/java-8-practice/blob/master/src/com/java8/features/base64/Base64Test.java)

## Nashorn Engine (jjs)
With Java 8, Nashorn, a much improved javascript engine is introduced, to replace the existing Rhino. Nashorn provides 2 to 10 times better performance, as it directly compiles the code in memory and passes the bytecode to JVM. Nashorn uses invoke dynamics feature, introduced in Java 7 to improve performance.

[Simple Example](https://github.com/kkv4all/java-8-practice/tree/master/src/com/java8/features/nashorn)