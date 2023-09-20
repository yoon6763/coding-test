#include <stdio.h>

int main() {
    int n1,n2,n3=0;
    scanf("%d %d %d",&n1,&n2,&n3);

    int cnt = 0;
    for(int i=0; i<n1; i++) {
        for(int j = 0; j<n2; j++) {
            for(int k = 0; k<n3; k++) {
                printf("%d %d %d\n",i,j,k);
                cnt++;
            }
        }
    }
    printf("%d",cnt);
}