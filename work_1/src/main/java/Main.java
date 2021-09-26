import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        new Menu(
            new MenuItem[]{
                new MenuItem(
                    "Add",
                    () -> {
                        String name = System.console().readLine("Name: ");
                        String surname = System.console().readLine("Surname: ");
                        int genderIndex = ConsoleUtil.readInt("Gender: \n1. Male\n2. Female\n-->", 1, 2);
                        Gender gender = genderIndex == 1 ? Gender.MALE : Gender.FEMALE;
                        String city = System.console().readLine("City: ");
                        String street = System.console().readLine("Street: ");

                        people.add(new Person(
                                name,
                                surname,
                                gender,
                                city,
                                street
                        ));
                    },
                    true),
                new MenuItem(
                    "Show",
                    () -> {
                        for (Person person : people) {
                            System.out.println(person);
                        }
                        System.console().readLine();
                    },
                    true),
                new MenuItem("Exit")
            },
            "-->"
        ).show();
    }
}
