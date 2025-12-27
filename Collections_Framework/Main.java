package Collections_Framework;
import java.util.*;

public class Main {
// | Entity                | Keyword        | Can use multiple? |
// | --------------------- | -------------  | ----------------- |
// | Class → Interface     | `implements`   | Yes               |
// | Interface → Interface | `extends`      | Yes               |
// | Interface → Class     | ❌ Not allowed | —                 |

    public static void main(String[] args) {
        // Collection interface in Java
        // If we want represent a group of objects as a single unit, we can use Collections

        // Collection Framework
        // It defines several classes and interfaces to represent a group of objects as a single unit

        // Iterable interface
        // It is the root interface in the collection hierarchy and defines basic methods like iterator()
        // extended by Collection interface

        // there are 9 key interfaces in Collection Framework
        
        // 1. Collection interface
        // It is the root interface in the collection hierarchy
        // It defines basic methods like add(), remove(), clear(), size(), isEmpty(), contains(), iterator() etc.
        // there is no concrete implementation of Collection interface in Java
        // extended by List interface, Set interface, Queue interface
        
        // difference between Collection and Collections
        // Collection is an interface
        // Collections is a utility class present in java.util.package to define several utility methods like sort(), binarySearch(), reverse() etc. on Collection objects.

        // 2. List interface
        // List is child interface of Collection interface
        // It is an ordered collection (also known as a sequence)
        // used for representing a group of objects as a single entity where duplicates are allowed and insertion order is preserved
        // implemented by ArrayList class (introduced in v1.0), LinkedList class (introduced in v1.0) vector class (introduced in v1.2), Stack class (introduced in v1.2)
        // vectors and Stacks are legacy classes as they are from the early versions of Java. They are synchronized which means only one thread can access them at a time. this also makes them slower. So it is recommended to use ArrayList and LinkedList instead of Vector and Stack.
        // implementaion example of list:
        List<String> arr = new ArrayList<>();

        // 3. Set interface
        // Set is child interface of Collection interface
        // It is an unordered collection of objects where duplicates are not allowed
        // implemented by HashSet class (introduced in v1.2), LinkedHashSet class (introduced in v1.4), TreeSet class (introduced in v1.2)

        // difference between List and Set interfaces
        // List allows duplicates, Set does not allow duplicates
        // List maintains insertion order, Set does not maintain insertion order (except LinkedHashSet)

        // 4. SortedSet interface
        // It is a child interface of Set interface
        // If you want to represent a group of objects as a single unit where duplicates are not allowed and the elements are sorted in ascending order, then you can use SortedSet interface
        // implemented by TreeSet class

        // 5. NavigableSet interface
        // It is a child interface of SortedSet interface
        // Introduced in Java 1.6
        // Implemented by TreeSet class

        // so basically the order is:
        // Collection interface -> Set interface -> SortedSet interface -> NavigableSet interface -> TreeSet class

        // example implementation of Set:
        Set<String> set = new HashSet<>();
        Set<String> sortedSet = new TreeSet<>();
        Set<String> navigableSet = new TreeSet<>();

        // 6. Queue interface
        // Queue is a child interface of Collection interface
        // Queue is used to represent a group of objects as a single unit where the elements are ordered in FIFO (First In First Out) manner
        // implemented by LinkedList class, PriorityQueue class (introduced in v1.5), BlockingQueue interface (introduced in v1.5)
        // BlockingQueue interface is further implemented by PriorityBlockingQueue class, LinkedBlockingQueue class etc.

        // all of the above mentioned interfaces (Collection, List, Set, SortedSet, NavigableSet, Queue) meant for representing a group of objects as a single unit
        // but what if we want to represent a group of key-value pairs as a single unit?
        // for that we have Map interface

        // 7. Map interface
        // It is NOT a child interface of Collection interface
        // It is used to represent a group of key-value pairs as a single unit
        // implemented by HashMap class (introduced in v1.2), LinkedHashMap class (introduced in v1.4), TreeMap class (introduced in v1.2), Hashtable class (introduced in v1.0)
        // 
    }
}
