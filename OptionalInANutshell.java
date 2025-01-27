import java.util.Optional;

public class OptionalInANutshell {
    public void run(){

        //                Points to: "My name"
        // myVariable <     -or-
        //                Points to: Null

        // "My name".length();      //Fine!
        // null.length();           //NullPointerException!











        // Optional
        //           +--------------+           +--------------+
        //          /|             /|          /|             /|
        //         / |            / |         / |            / |
        //        *--+-----------*  |        *--+-----------*  |
        //        |  |           |  |        |  |           |  |
        //        |  |  Empty    |  |        |  | Something |  |
        //        |  |           |  |        |  |           |  |
        //        |  +-----------+--+        |  +-----------+--+
        //        | /            | /         | /            | /
        //        |/             |/          |/             |/
        //        *--------------*           *--------------*

        // Methods you use 80% of the time
        var myName = "Rutger";
        var notMyName = "Bob";

        // new Optional
        Optional<String> myOptional = Optional.ofNullable(myName);

        // Get Optional Value
        myOptional.orElseGet(() -> "No name");// Lazy
        myOptional.orElseThrow(() -> new MyOwnException());
        myOptional.orElseThrow(); // Default: NoSuchElementException() (Still a RuntimeException)

        // Work with the value
        myOptional.ifPresent(value -> System.out.println("my name is: " + value));
        myOptional.ifPresentOrElse(value -> System.out.println("my name is: " + value), () -> System.out.println("No name found!"));

        // Mutate the value
        // Not a stream! it returns an (other) optional!
        myOptional.filter(value -> value.length() > 8);
        myOptional.or(() -> Optional.of("No name"));// Lazy
        myOptional.map(String::length);
        myOptional.flatMap(value -> Optional.ofNullable(value));// Flattens nested Optionals to slingle Optional
        myOptional.equals(notMyName);

        myOptional.stream();








        // Methods you use 20% of the time
        Optional.empty();
        Optional.of("Rutger");

        myOptional.isPresent();
        myOptional.isEmpty();

        myOptional.get();// throws NPE when null
        myOptional.orElse("No name");// Not lazy
    }







    class MyOwnException extends RuntimeException{

    }
}
