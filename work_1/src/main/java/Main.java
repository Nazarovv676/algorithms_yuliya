import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        new Menu(
            new MenuItem[]{
                new MenuItem(
                    "Add",
                    () -> {
                        people.add(new Person(
                                "name" + people.size(),
                                "surname" + people.size(),
                                Gender.UNKNOWN,
                                "city" + people.size(),
                                "street" + people.size()
                        ));
                    }
                ),
                new MenuItem(
                    "Show",
                    () -> {
                        System.out.println(people);
                        System.console().readLine();
                    }
                ),
                new MenuItem("Exit")
            },
            "-->"
        ).show();
    }
}
