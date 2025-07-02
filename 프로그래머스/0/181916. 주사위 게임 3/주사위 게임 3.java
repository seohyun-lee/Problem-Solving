class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] arr = new int[7];
        arr[a]++;
        arr[b]++;
        arr[c]++;
        arr[d]++;
        int max_count=0;
        for (int i=1; i<7; i++) {
            if (arr[i]==4) {
                return 1111*i;
            } else if (arr[i]==3) {
                int j=1;
                for (j=1; j<7; j++) {
                    if(arr[j]==1) break;
                }
                return (10*i+j)*(10*i+j);
            } else if (arr[i]==2) {
                int q=0, r=0;
                int j=1;
                for (j=1; j<7; j++) {
                    if(arr[j]!=0 && j!=i) {
                        if (q!=0) r=j;
                        else q=j;
                    }
                }
                if (r==0) {
                    return i>q ? (i+q)*(i-q) : (i+q)*(q-i);
                } else {
                    return (q*r);
                }
            }
        }
        for (int i=1; i<7; i++) {
            if (arr[i]!=0) return i;
        }
        return 0;
    }
}