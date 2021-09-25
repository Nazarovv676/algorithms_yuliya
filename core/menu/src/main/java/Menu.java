import org.jetbrains.annotations.NotNull;

public class Menu{
    private @NotNull final MenuItem[] _menuItems;
    private @NotNull final String _requestString;
    private  @NotNull final boolean _reshowAfterCallback;

    public Menu(@NotNull MenuItem[] menuItems, @NotNull String requestString) {
        this._menuItems = menuItems;
        this._requestString = requestString;
        _reshowAfterCallback = true;
    }

    public Menu(@NotNull MenuItem[] menuItems, @NotNull String requestString, boolean reshowAfterCallback) {
        this._menuItems = menuItems;
        this._requestString = requestString;
        this._reshowAfterCallback = reshowAfterCallback;
    }

    public MenuItem show() {
        ConsoleUtil.clearConsole();
        _printMenu();

        MenuItem item = _requestMenuItem();

        if(item.onSelected != null) {
            ConsoleUtil.clearConsole();
            item.onSelected.call();
            if(_reshowAfterCallback) {
                show();
            }
        }

        return item;
    }

    private void _printMenu() {
        for (int i = 0; i < _menuItems.length; i++) {
            System.out.println(i + 1 + ". " + _menuItems[i].label);
        }
    }

    private MenuItem _requestMenuItem() {
        int res;
        boolean firstTime = true;
        do {
            if(!firstTime) {
                ConsoleUtil.clearLastLine();
            }
            res = ConsoleUtil.readInt(_requestString);
            firstTime = false;
        } while (res > _menuItems.length || res < 1);

        return _menuItems[res - 1];
    }
}
