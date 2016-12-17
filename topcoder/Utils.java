public class Utils {
    // https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order
    boolean nextPermutation(int[] a) {
        for (int i=a.length-2; i>=0; i--) if (a[i]<a[i+1]) {
            reverse(a, i+1, a.length);
            for (int j=i+1; ; j++) if (a[i]<a[j]) {
                swap(a, i, j);
                return true;
            }
        }
        return false;
    }
 
    void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
 
    void reverse(int[] a, int b, int e) {
        while (b < e) {
            --e;
            swap(a, b, e);
            ++b;
        }
    }

    boolean checkInt(double d) {
        return (d % 1) == 0;
    }
}