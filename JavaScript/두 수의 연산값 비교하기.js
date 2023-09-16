function solution(a, b) {
    const n1 = String(a) + String(b)
    const n2 = 2*a*b
    
    return n1 >= n2 ? Number(n1) : Number(n2)
}