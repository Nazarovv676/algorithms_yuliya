enum Gender{
    MALE,
    FEMALE,
    UNKNOWN,
}
public record Person(String name, String surname, Gender gender, String city, String street) {
}
