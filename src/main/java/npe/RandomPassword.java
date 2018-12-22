package npe;

import npe.security.ClearPassword;

public class RandomPassword {
    public static void main(String[] args) {
        ClearPassword pass = ClearPassword.createRaw("CLEAR", "random".toCharArray());
        System.out.printf("pass=%s, class=%s\n", pass, pass.getClass());
    }
}
