//bottom-up approach

import java.util.*;
public class Main
{
	public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();

int val[]=new int[n];
int w[]=new int[n];

for(int i=0;i<n;i++){
val[i]=sc.nextInt();

w[i]=sc.nextInt();
}
int W=sc.nextInt();

int dp[][]=new int[n+1][W+1];
for(int i=0;i<=n;i++) {
for(int j=0;j<=W;j++) {
if(i==0 || j==0)
dp[i][j]=0;

else if(w[i-1] > j)
dp[i][j]=dp[i-1][j];

else
    dp[i][j]=Math.max(val[i-1]+dp[i-1][j-w[i-1]], dp[i-1][j]);
}
}
System.out.print("profit"+dp[n][W]);
}
}
