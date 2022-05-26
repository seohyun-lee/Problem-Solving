#include  <stdio.h>

int main(void)
{
    int c;
    scanf("%d ", &c);
    int arr[1000];
    for (int i = 0; i < c; i++)
    {
        int n, sum = 0, cn = 0;
        float av;
        scanf("%d", &n);
        for (int j = 0; j < n; j++) {
            int sc;
            scanf("%d", &sc);
            arr[j] = sc;
            sum += sc;
        }
        av = sum / n;
        for (int k = 0; k < n; k++) {
            if (arr[k] > av)
                cn++;
        }
        printf("%.3f%%\n", (float)cn/n*100);
    }
}