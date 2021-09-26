import org.jetbrains.annotations.NotNull;

interface MenuItemCallback {
    /**
     * Something like callable constructors in dart
     */
    void call();
}

public class MenuItem {
    public final String label;
    public final MenuItemCallback onSelected;
    public final boolean reshowAfterCallback;

    public  MenuItem(@NotNull String label) {
        this.label = label;
        this.reshowAfterCallback = false;
        onSelected = null;
    }

    public MenuItem(@NotNull String label, @NotNull MenuItemCallback onSelected, boolean reshowAfterCallback) {
        this.label = label;
        this.onSelected = onSelected;
        this.reshowAfterCallback = reshowAfterCallback;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "label='" + label + '\'' +
                ", onSelected=" + onSelected +
                '}';
    }
}
