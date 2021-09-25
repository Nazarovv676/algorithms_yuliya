import org.jetbrains.annotations.NotNull;

interface MenuItemCallback {
    /**
     * Something like callable constructors in dart
     */
    void call();
}

public class MenuItem {
    public String label;
    public MenuItemCallback onSelected;

    public MenuItem(@NotNull String label) {
        this.label = label;
    }

    public MenuItem(@NotNull String label, @NotNull MenuItemCallback onSelected) {
        this.label = label;
        this.onSelected = onSelected;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "label='" + label + '\'' +
                ", onSelected=" + onSelected +
                '}';
    }
}
