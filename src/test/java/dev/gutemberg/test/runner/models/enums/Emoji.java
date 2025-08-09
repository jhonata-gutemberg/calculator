package dev.gutemberg.test.runner.models.enums;

public enum Emoji {
    ROCKET("🚀"),
    TEST_TUBE("🧪"),
    CHECK_MARK_BUTTON("✅"),
    NO_ENTRY("⛔"),
    PARTY_POPPER("\uD83C\uDF89");

    private final String code;

    Emoji(final String code) {
        this.code = code;
    }

    public String code() {
        return code;
    }

    @Override
    public String toString() {
        return code;
    }
}
