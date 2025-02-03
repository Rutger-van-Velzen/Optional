import java.util.Optional;

import static java.util.Objects.*;

public class WhenToUseOptional {
    public void run(){

        // Simple person object
        var person = new Person(
                "John",
                "Doe",
                null
        );









        // Imperative programming
        // Each line describes, how you are doing it.
        String street = "Unknown";

        if( person != null
         && person.getAddress() != null
         && person.getAddress().getStreet() != null){
            street = person.getAddress().getStreet();
        }

        System.out.println(street);










        // Functional programming
        // Each line describes, what you want to do.
        var street_2 = Optional.ofNullable(person)
                .map(Person::getAddress)
                .map(Address::getStreet)
                .orElseGet(()->"Unknown");

        System.out.println(street_2);
    }












    class Person{
        private String firstName;
        private String lastName;
        private Address address;

        public Person(String firstName, String lastName, Address address){
            requireNonNull(firstName, "firstName is mandatory");
            requireNonNull(lastName, "lastName is mandatory");

            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;

        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public Address getAddress() {
            return address;
        }
    }

    class Address{
        private String street;
        private String houseNumber;

        public Address(String street, String houseNumber){
            this.street = street;
            this.houseNumber = houseNumber;
        }

        public String getStreet() {
            return street;
        }

        public String getHouseNumber() {
            return houseNumber;
        }
    }
}
