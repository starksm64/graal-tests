package npe.security;

import javax.security.auth.DestroyFailedException;

public interface Password {
    public String getAlgorithm();
    public String getFormat();
    public byte[] getEncoded();
    public char[] getPassword() throws IllegalStateException;

    public default void destroy() throws DestroyFailedException {
        throw new DestroyFailedException();
    }
    public default boolean isDestroyed() {
        return false;
    }
    public Password clone();
}
