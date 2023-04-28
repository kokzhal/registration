package kz.team3.registration.entity;

public enum UserGender {
    USER_MALE("Male"),
    USER_FEMALE("Female");



    private final String displayName;

    UserGender(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
