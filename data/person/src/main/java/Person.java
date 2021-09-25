enum Gender{
    MALE,
    FEMALE,
    UNKNOWN,
}
public record Person(String name, String surname, Gender gender, String city, String street) {
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
