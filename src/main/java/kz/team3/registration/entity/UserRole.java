package kz.team3.registration.entity;

public enum UserRole {
    ROLE_USER("User"),
    ROLE_ADMIN("Administrator"),
    ROLE_SUPERVISOR("Supervisor"),
    


    private final String displayName;

    UserRole(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
