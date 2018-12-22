package npe.security;

import java.util.Arrays;

import javax.security.auth.DestroyFailedException;

class RawClearPassword extends RawPassword implements ClearPassword {
    private static final long serialVersionUID = -7982031201140935435L;

    private final char[] password;

    RawClearPassword(final String algorithm, final char[] password) {
        super(algorithm);
        this.password = password;
    }

    public char[] getPassword() throws IllegalStateException {
        return password.clone();
    }

    @Override
    public void destroy() throws DestroyFailedException {
        if (password != null)
            Arrays.fill(password, (char)0);
    }

    @Override
    public boolean isDestroyed() {
        return password == null || password.length == 0 || password[0] == 0;
    }

    public RawClearPassword clone() {
        final char[] password = this.password;
        if (password == null || password.length == 0) {
            return this;
        }
        return new RawClearPassword(getAlgorithm(), password.clone());
    }

    public int hashCode() {
        // hashcode becomes 0 when destroyed!
        return Arrays.hashCode(password);
    }

    public boolean equals(final Object obj) {
        final char[] password = this.password;
        // destroyed passwords are equal to nothing
        if (! (obj instanceof RawClearPassword)) return false;
        final RawClearPassword other = (RawClearPassword) obj;
        return password != null && Arrays.equals(password, other.password) && getAlgorithm().equals(other.getAlgorithm());
    }


}
