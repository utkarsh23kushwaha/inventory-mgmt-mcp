package com.inventorymgmt.mcp.models.enums;

public enum Location {
    WAREHOUSE_A("Warehouse A"),
    WAREHOUSE_B("Warehouse B"),
    WAREHOUSE_C("Warehouse C"),
    WAREHOUSE_D("Warehouse D"),
    WAREHOUSE_E("Warehouse E"),
    OFFICE_STORE("Office Store");

    private final String displayName;

    Location(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static Location fromString(String input) {
        if (input == null) return null;
        String sanitized = input.trim().replaceAll("\\s+", " ").toLowerCase();
        for (Location loc : values()) {
            if (loc.displayName.toLowerCase().equals(sanitized)) {
                return loc;
            }
        }
        return null;
    }
}
