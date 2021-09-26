import org.jetbrains.annotations.NotNull;

public class Menu{
    private @NotNull final MenuItem[] _menuItems;
    private @NotNull final String _requestString;

    public Menu(@NotNull MenuItem[] menuItems, @NotNull String requestString) {
        this._menuItems = menuItems;
        this._requestString = requestString;
    }

    public MenuItem show() {
        ConsoleUtil.clearConsole();
        _printMenu();

        MenuItem item = _requestMenuItem();

        if(item.onSelected != null) {
            ConsoleUtil.clearConsole();
            item.onSelected.call();
            if(item.reshowAfterCallback) {
                show();
            }
        }

        ConsoleUtil.clearConsole();
        return item;
    }

    private void _printMenu() {
        for (int i = 0; i < _menuItems.length; i++) {
            System.out.println(i + 1 + ". " + _menuItems[i].label);
        }
    }

    private MenuItem _requestMenuItem() {
        int res = ConsoleUtil.readInt(_requestString, 1, _menuItems.length);
        return _menuItems[res - 1];
    }
}
