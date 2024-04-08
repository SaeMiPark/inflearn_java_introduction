import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*냅색알고리즘: 동전*/

public class Coinswitch {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int coinnum=Integer.parseInt(br.readLine());
        int[] coin=new int[coinnum];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0; i<coin.length; i++){
            coin[i]=Integer.parseInt(st.nextToken());
        }
        int amount=Integer.parseInt(br.readLine());
        int[] dp=new int[amount+1]; //16까지 0~15

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=-0;

        for(int i=0; i<coin.length; i++){ //0~2==1,2,5
            for(int j=coin[i]; j<=amount; j++){ //j==1~15
                dp[j]=Math.min(dp[j], dp[j-coin[i]]+1);
            }
          
        }

        System.out.print(dp[amount]);

    }

}
