package org.staale.javasane;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.ptr.IntByReference;

/**
 * Hello world!
 *
 */
public class App {

    public interface SaneLibrary extends Library {

        SaneLibrary INSTANCE = (SaneLibrary) Native.loadLibrary("sane", SaneLibrary.class);

        int sane_init(IntByReference version_code, Object callback);
        void sane_exit();
    }

    public static void main(String[] args) {
        final IntByReference version = new IntByReference();
        System.out.println(SaneLibrary.INSTANCE.sane_init( version, args));
        System.out.println(version.getValue());
        SaneLibrary.INSTANCE.sane_exit();
    }
}
