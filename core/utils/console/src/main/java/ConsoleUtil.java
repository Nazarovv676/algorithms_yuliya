import org.jetbrains.annotations.NotNull;

import java.io.Console;

public abstract class ConsoleUtil {
    private static final String _ANSI = "\033";
    private static final String _ANSI_ESC = _ANSI + "[";
    private static final String _LINES_SPLITTER = "\r\n|\r|\n";

    private static final Console _console;

    public static Console console() {
        return _console;
    }

    static {
        _console = System.console();
    }

    public static void clearConsole() {
       System.out.print(_ANSI_ESC + "2J" + _ANSI_ESC + "0;0H");
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
        System.out.print(_ANSI_ESC + "2K");
        System.out.flush();
    }

    public static void moveCursorUp() {
        System.out.print(_ANSI_ESC + "1A");
        System.out.flush();
    }

    public static int readInt() {
        while (true) {
            try {
                String val = _console.readLine();
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
                String val = _console.readLine();
                return Integer.parseInt(val);
            } catch (NumberFormatException exc) {
                ConsoleUtil.clearLines(placeholder.split(_LINES_SPLITTER).length);
            }
        }
    }

    public  static int readInt(@NotNull String placeholder, int min, int max) {
        int res;
        boolean firstTime = true;
        do {
            if(!firstTime) {
                ConsoleUtil.clearLines(placeholder.split(_LINES_SPLITTER).length);
            }
            res = ConsoleUtil.readInt(placeholder);
            firstTime = false;
        } while (res < min || res > max);

        return res;
    }
}
