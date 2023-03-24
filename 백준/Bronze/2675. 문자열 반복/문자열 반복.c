#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
int main(void) {
    int T;
    scanf("%d", &T);
    for (int i = 0; i < T; i++)
    {
        int R;
        char s[20];
        scanf("%d", &R);
        scanf("%s", &s);
        int j = 0;
        while (s[j] != '\0'){
            for (int k = 0; k < R; k++)
                printf("%c", s[j]);
            j++;
        }
        printf("\n");
    }
    return 0;
}