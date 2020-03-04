package experience.demo01;

public class Tool {


	public static boolean findout(int n) {
		int[] money= {50,20,10,5,5,1,1,1};
		int[] ans=new int[8];
		for(int i=0;i<8;i++) {
			if(n>=money[i]) {
				ans[i]=1;
				n-=money[i];
			}
		}
		if(n>0)return false;
		else return true;
	}

}
