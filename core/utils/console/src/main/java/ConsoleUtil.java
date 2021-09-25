import org.jetbrains.annotations.NotNull;

import java.io.Console;

public abstract class ConsoleUtil {
    private static final Console console;

    static {
        console = System.console();
    }

    public static void clearConsole() {
       System.out.print("\033[2J\033[0;0H");
    }

    public static void clearLines(int count) {
        for (int i = 0; i < count; i++) {
            moveCursorUp();
            clearLine();
        }
    }

    public static void clearLastLine() {
        clearLines(1);
    }

    public static void clearLine() {
        System.out.print("\033[2K");
        System.out.flush();
    }

    public static void moveCursorUp() {
        System.out.print("\033[1A");
        System.out.flush();
    }

    public static int readInt() {
        while (true) {
            try {
                String val = console.readLine();
                return Integer.parseInt(val);
            } catch (NumberFormatException exc) {
                clearLastLine();
            }
        }
    }

    public static int readInt(@NotNull String placeholder) {
        while (true) {
            try {
                System.out.print(placeholder + " ");
                String val = console.readLine();
                return Integer.parseInt(val);
            } catch (NumberFormatException exc) {
                clearLastLine();
            }
        }
    }
}
