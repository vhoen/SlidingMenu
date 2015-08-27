package me.hoen.slidingmenu;

import java.util.UUID;

public class MenuItem {
    protected String id;
    protected String label;
    protected int iconResId;

    public MenuItem(String label) {
        this(label, 0);
    }

    public MenuItem(String label, int iconResId) {
        setId(UUID.randomUUID().toString());
        setLabel(label);
        setIconResId(iconResId);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getIconResId() {
        return iconResId;
    }

    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }

    @Override
    public String toString() {
        return "(MenuItem) -> [id: " + getId() + ", label: " + getLabel() +
                ", iconResId: " + getIconResId() + "]";
    }
}
