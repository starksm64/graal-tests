package npe.security;

abstract class RawPassword implements Password {

    private static final long serialVersionUID = -1181073776936676242L;

    private final String algorithm;

    RawPassword(final String algorithm) {
        this.algorithm = algorithm;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public String getFormat() {
        return null;
    }

    public byte[] getEncoded() {
        return null;
    }

    public abstract RawPassword clone();

    public abstract int hashCode();

    public abstract boolean equals(final Object obj);
}
