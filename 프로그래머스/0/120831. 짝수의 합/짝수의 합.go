func solution(n int) int {
    sum:=0
    for i:=2; i<=n; i+=2 {
        sum+=i
    }
    return sum
}