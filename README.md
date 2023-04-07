# Basic_CRUD_app

In versions 2.8.x and earlier, Jackson would silently coerce out-of-range integer values to their maximum or minimum values (depending on the sign) without throwing an exception. In contrast, starting with version 2.9.0, Jackson introduced a new feature called "coercion" that provides better control over how out-of-range values are handled.

By default, coercion is enabled in version 2.10.1, which means that if an integer value is out of range, Jackson will throw an InputCoercionException instead of silently coercing the value.

It's possible that the JSON you are parsing contains an integer value that is outside the range of a Java int, and Jackson is now throwing an InputCoercionException in version 2.10.1 because of the new coercion feature. However, in version 2.8.7, the value may have been silently coerced without an exception being thrown.

To verify if this is the case, you can check the JSON input that's causing the InputCoercionException in version 2.10.1 to see if it contains any integer values that are outside the range of a Java int. If this is the case, you can either modify the JSON to contain valid integer values, or you can disable coercion in version 2.10.1 to restore the previous behavior by setting the FAIL_ON_READING_DUP_TREE_KEY feature to false on the ObjectMapper instance used for parsing the JSON.

ObjectMapper mapper = new ObjectMapper(); mapper.configure(JsonParser.Feature.FAIL_ON_READING_DUP_TREE_KEY, false);

In Jackson 2.8.7 and earlier versions, if an integer value was outside the range of a Java int, it would be silently coerced to its maximum or minimum value (depending on the sign) without throwing any exceptions.

For example, if the JSON input contains the integer value 2147483648, which is one more than the maximum value of a Java int, then in Jackson 2.8.7 and earlier versions, it would be coerced to the maximum int value of 2147483647 without any exceptions being thrown.

Therefore, if you were parsing JSON containing out-of-range integer values in Jackson 2.8.7, the returned value would be the coerced int value without any indication that the input value was out of range. This could lead to unexpected behavior in your application if the value is used in further processing or calculations.
