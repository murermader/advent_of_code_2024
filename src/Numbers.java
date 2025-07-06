import java.util.List;

// Use a record class because we are just using it to store immutable data.
// Automatically creates constructors, accessor methods, and other stuff like toString or equals.
// If you need mutable data, overloaded constructors or inheeritance, use a class.
public record Numbers(List<Integer> left, List<Integer> right) {
}
