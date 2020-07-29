package KickStart;

import java.util.Scanner;

public class RecordBreaker {
	public  static void main(String arg[]) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int ar[];
		for(int i=1;i<=n;i++) {
			int days=sc.nextInt();
			ar=new int[days];
			for(int day=0;day<days;day++) {
				ar[day]=sc.nextInt();
			}		
			int maxTillNow=-1;
			int recordBreakerCount=0;
			
			for(int c=0;c<ar.length;c++) {
				recordBreakerCount+=(ar[c]>maxTillNow && (c+1==days || ar[c+1]<ar[c]))?1:0;
				maxTillNow=Math.max(maxTillNow, ar[c]);
			}
			System.out.print("case # "+i+" "+recordBreakerCount);
		}
	}

}//3 1 4 1 5 9 2 6 5
