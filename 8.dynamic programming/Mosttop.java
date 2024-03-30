import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Mosttop {
    //에러가 나서 객체를 static으로 바꿈
    static class Brick implements Comparable<Brick>{
        public int s,h,w;

        Brick(int s,int h, int w){
            this.s=s;
            this.h=h;
            this.w=w;
        }

        @Override
        public int compareTo(Brick o) {
            return o.s-this.s; //this가 뒤에 온다 == 내림차순
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner sc=new Scanner(System.in);

        int n=Integer.parseInt(br.readLine());
        ArrayList<Brick> arr=new ArrayList<>();
        int[] dp=new int[n];
        for(int i=0; i<n; i++){
            //int a=Integer.parseInt(br.readLine()); 이런식으로 안 된다.
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            arr.add(new Brick(a,b,c));
        }

        //정렬
        Collections.sort(arr);

        //dp초기값 지정
        dp[0]=arr.get(0).h;

        for(int i=1; i<n; i++){
            dp[i]=arr.get(i).h;  //자기 자신으로 셋팅
            for(int j=0; j<i; j++){
                if(arr.get(j).w>arr.get(i).w){
                    dp[i]=Math.max(dp[i], arr.get(i).h+dp[j]);
                }
            }
        }

        int answer=0;
        for(int x: dp) answer=Math.max(answer, x);
        System.out.println(answer);


    }
}
