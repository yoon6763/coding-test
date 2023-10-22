fn main() {
    let n: i32 = readln().parse().unwrap();
    let mut cnt = 0;
    fibo(n, &mut cnt);
    println!("{} {}", cnt, n - 2);
}

fn fibo(n: i32, cnt: &mut i32) -> i32 {
    if n == 1 || n == 2 {
        *cnt += 1;
        1
    } else {
        fibo(n - 1, cnt) + fibo(n - 2, cnt)
    }
}

fn readln() -> String {
    let mut input = String::new();
    std::io::stdin().read_line(&mut input).expect("Failed to read input");
    input.trim().to_string()
}