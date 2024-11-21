package dev.bitboard.api.utilities;


import io.github.cdimascio.dotenv.Dotenv;

public final class EnvironmentUtilities {
    private static final String PATH = "src/main/assets";
    private static final String FILENAME = ".env";
    public static final Dotenv ENV;

    private EnvironmentUtilities() {
    }

    static {
        ENV = Dotenv
                .configure()
                .directory(PATH)
                .filename(FILENAME)
                .load();
    }

    public static String get(String key) {
        return ENV.get(key);
    }
}
