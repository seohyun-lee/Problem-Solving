func solution(numbers []int) float64 {
    sum:=0
    for _, v := range numbers {
        sum += v
    }
    return float64(sum)/float64(len(numbers))
}