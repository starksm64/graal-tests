package npe.security;

public interface ClearPassword extends Password {

    public ClearPassword clone();

    public static ClearPassword createRaw(String algorithm, char[] password) {
        char[] clone = password.clone();
        return new RawClearPassword(algorithm, clone);
    }
}
