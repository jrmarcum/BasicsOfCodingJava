// Java uses references, not raw pointers. Primitives are passed by value;
// an int[] of size 1 simulates pass-by-reference. Memory addresses are not
// directly accessible — System.identityHashCode is used as a proxy.

void zeroval(int ival) {
    ival = 0;
}

void zeroptr(int[] iptr) {
    iptr[0] = 0;
}

void main() {
    int[] iRef = {1};
    System.out.println("initial: " + iRef[0]);

    zeroval(iRef[0]);
    System.out.println("zeroval: " + iRef[0]);

    zeroptr(iRef);
    System.out.println("zeroptr: " + iRef[0]);

    System.out.println("pointer: 0x" + Integer.toHexString(System.identityHashCode(iRef)));
}
