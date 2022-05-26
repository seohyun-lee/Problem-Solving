long long sum(int* a, int n) {
    long long ans = 0;
    for (int j = 0;j<n; j++)
        ans += a[j];
    return ans;
}