package npe;

import com.oracle.svm.core.annotate.Alias;
import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;
import npe.security.ClearPassword;

/**
 * Override to replace the use of char[].clone()
 */
@TargetClass(value = ClearPassword.class)
interface Target_npe_security_ClearPassword {

    @Substitute
    public static ClearPassword createRaw(String algorithm, char[] password) {
        System.out.println("Substituting arraycopy for clone...\n");
        char[] clone = new char[password.length];
        System.arraycopy(password, 0, clone, 0, password.length);
        return new Target_npe_security_RawClearPassword(algorithm, clone);
    }
}

/**
 * Override to gain access to the RawClearPassword package private class and have it implement ClearPassword
 */
@TargetClass(className = "npe.security.RawClearPassword")
final class Target_npe_security_RawClearPassword implements ClearPassword {

    @Alias
    Target_npe_security_RawClearPassword(final String algorithm, final char[] password) {
    }

    @Override
    @Alias
    public char[] getPassword() throws IllegalStateException {
        return new char[0];
    }

    @Override
    @Alias
    public Target_npe_security_RawClearPassword clone() {
        return null;
    }

    @Override
    @Alias
    public String getFormat() {
        return null;
    }

    @Alias
    @Override
    public int hashCode() {
        return 0;
    }

    @Alias
    @Override
    public String getAlgorithm() {
        return null;
    }

    @Alias
    @Override
    public byte[] getEncoded() {
        return new byte[0];
    }

    @Alias
    @Override
    public boolean equals(Object obj) {
        return false;
    }
}