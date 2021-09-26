import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        new Menu(
            new MenuItem[]{
                new MenuItem(
                    "Add",
                    () -> {
                        String name = ConsoleUtil.console().readLine("Name: ");
                        String surname = ConsoleUtil.console().readLine("Surname: ");
                        int genderIndex = ConsoleUtil.readInt(
                                "Gender: \n1. Male\n2. Female\n-->",
                                1, 2);
                        Gender gender = genderIndex == 1 ? Gender.MALE : Gender.FEMALE;
                        String city = ConsoleUtil.console().readLine("City: ");
                        String street = ConsoleUtil.console().readLine("Street: ");

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
                        ConsoleUtil.console().readLine();
                    },
                    true),
                new MenuItem(
                    "Group by street",
                    () -> {
                        HashMap<String, ArrayList<Person>> groups = new HashMap<>();
                        for (Person person : people) {
                            final String key = person.city() + " " + person.street();
                            ArrayList<Person> group =  groups.get(key);
                            if(group == null) {
                                group = new ArrayList<>();
                            }
                            group.add(person);
                            groups.put(key, group);
                        }

                        groups.forEach((key, group) -> {
                            System.out.println(key);
                            for (Person person : group) {
                                System.out.println(person);
                            }
                            System.out.println();
                        });
                        ConsoleUtil.console().readLine();
                    },
                    true),
                new MenuItem("Exit")
            },
            "-->"
        ).show();
    }
}
