package main

import "fmt"

func main() {
    var N, m, M, T, R int
    fmt.Scan(&N, &m, &M, &T, &R)

    minn := m
    ans := 0
    minute := 0

    if m > M || m + T > M {
        minute = -1
    } else {
        for {
            if m + T <= M {
                m += T
                ans++
                minute++
            } else {
                m -= R
                if m < minn {
                    m = minn
                }
                minute++
            }

            if ans >= N {
                break
            }
        }
    }

    fmt.Println(minute)
}
