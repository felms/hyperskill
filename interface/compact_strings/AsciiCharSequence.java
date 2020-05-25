import java.nio.charset.Charset;
import java.util.Arrays;

class AsciiCharSequence implements CharSequence {

    private byte[] value;

    public AsciiCharSequence(byte[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    @Override
    public int length() {
        return this.value.length;
    }

    @Override
    public char charAt(int i) {
        return new String(value, Charset.forName("US-ASCII")).charAt(i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return new AsciiCharSequence(Arrays.copyOfRange(value, i, i1));
    }

    @Override
    public String toString() {
        return new String(value, Charset.forName("US-ASCII"));
    }
}