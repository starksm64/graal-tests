package npe;

import npe.security.ClearPassword;

/**
 * A simple main that calls ClearPassword.createRaw() and prints the result
 */
public class CreatePasswordMain {
    public static void main(String[] args) {
        ClearPassword pass = ClearPassword.createRaw("CLEAR", "random".toCharArray());
        System.out.printf("pass=%s, class=%s\n", pass, pass.getClass());
    }
}
