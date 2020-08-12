/*
 * link:-https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff08/0000000000387174#problem
 */

package KickStart;

public class AlienPiano {
	public static void main(String[] args) {
		int notes[]=new int[] {2,3,4,5,6,7,8,9,10,11};
		System.out.println(findMinRuleBreak(notes));
	}

	public static int findMinRuleBreak(int[] notes) {
		int n=notes.length;int k=4; 
		int[][] dp=new int[n][k];
		for(int i=0;i<k;i++) {
			dp[0][i]=0;
		}
		for(int i=1;i<n;i++) {
			int j_prevMin=findFirstMinInd(dp,i-1,k);
			int prevMin=dp[i-1][j_prevMin];
			for(int j=0;j<k;j++) {
				if(violatesCondition(notes,i,j_prevMin,j))
					dp[i][j]=prevMin+1;
				else 
					dp[i][j]=prevMin;
			}
		}
		//printDP table
		/*for(int i=0;i<n;i++) {
			for(int j=0;j<k;j++) {
				System.out.print(dp[i][j]+" ");
				
			}
			System.out.println();
		}*/
		int min=99;
		for(int m=0;m<k;m++) {
			min=min<dp[n-1][m]?min:dp[n-1][m];
		}
		return min;
	}

	private static boolean violatesCondition(int notes[], int i, int j_prevMin, int j) {
		
		boolean toReturn=false;
		if(notes[i-1]>notes[i] && j_prevMin<=j)
			toReturn=true;
		else if(notes[i-1]<notes[i] && j_prevMin>=j)
			toReturn=true;
		else if(notes[i-1]==notes[i] && j_prevMin!=j)
			toReturn=true;
		return toReturn;
	}

	private static int findFirstMinInd(int[][] dp, int i, int k) {
		int minInd=-1;int min=99;
		for(int j=0;j<k;j++) {
			if(dp[i][j]<min) {
				min=dp[i][j];
				minInd=j;
			}
		}
		return minInd;
	}

}
