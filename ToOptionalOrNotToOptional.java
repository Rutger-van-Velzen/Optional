import java.util.Optional;

import static  java.util.Objects.*;

public class ToOptionalOrNotToOptional {
    public void run(){

        // General rule
        // Don't use optionals in data objects,
        // as those could be coupled to libraries.
        // Json -> pojo
        // Database -> pojo

        // *Except when your software architectural decisions allow for it.








        var json = new Json();
        var phoneNumber = json.getPhoneNumber();

        // A null value here means what the OpenApi spec says it means.
        if(isNull(phoneNumber)){
            phoneNumber = "";
        }









        var calc = new Calculator();
        var salary = calc.calculateAnnualSalary();

        salary.ifPresentOrElse(
                s -> System.out.println("You earned: " + s + " this year."),
                () -> System.out.println("Pro bono.")
        );

    }

}


class Calculator{
    Optional<Integer> calculateAnnualSalary(){
        return Optional.empty();
    }
}

// Don't use Optional in data models
// Those could make use of frameworks that don't understand optional.
// (Converting to JSON or Connecting to a database.)
class Json{
    String getPhoneNumber(){
        return null;
    }
}