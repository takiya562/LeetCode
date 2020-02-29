package include;

import java.util.Arrays;

public class bisect {
    public  static  int bisect(int[] a, int key) {
        return bisect_left0(a, 0, a.length, key);
    }

    public static int bisect_left(int[] a, int key) {
        return bisect_left0(a, 0, a.length, key);
    }

    public static int bisect_right(int[] a, int key) {
        return bisect_right0(a, 0, a.length, key);
    }

    private static int bisect_left0(int[] a, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low < high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal >= key)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }

    private static int bisect_right0(int[] a, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low < high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal > key)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }

    public static int[] insort(int[] a, int key) {
        int index = bisect_left(a, key);
        int[] b = Arrays.copyOf(a, a.length + 1);
        for (int i = b.length - 1; i > index; --i)
            b[i] = b[i - 1];
        b[index] = key;
        return b;
    }
}
