class Solution {
    public int numOfUnplacedFruits(int[] f, int[] b) {
        List<Integer> s = new ArrayList<>();
        int n = b.length, sz = (int) Math.sqrt(n), c = 0, m = 0;
        for (int i = 0; i < n; i++) {
            if (c == sz) {
                s.add(m);
                m = b[i];
                c = 1;
            } else {
                c++;
                m = Math.max(m, b[i]);
            }
        }
        s.add(m);
        int rem = 0;
        for (int i = 0; i < f.length; i++) {
            int k = 0, u = 1;
            for (int j = 0; j < n; j += sz) {
                if (s.get(k) < f[i]) {
                    k++;
                    continue;
                }
                for (int r = j; r < Math.min(j + sz, n); r++) {
                    if (b[r] >= f[i]) {
                        u = 0;
                        b[r] = 0;
                        break;
                    }
                }
                if (u == 0) {
                    s.set(k, 0);
                    for (int r = j; r < Math.min(j + sz, n); r++) {
                        s.set(k, Math.max(b[r], s.get(k)));
                    }
                    break;
                }
                k++;
            }
            rem += u;
        }
        return rem;
    }
}

