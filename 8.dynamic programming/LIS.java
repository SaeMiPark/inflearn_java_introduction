import java.io.*;
import java.util.StringTokenizer;

public class LIS{
    static int[] dy;

    public int solution(int n, int[] arr){
        int answer=0;

        dy=new int[n+1];

        dy[1]=1;

        for(int i=2; i<=n; i++){ //arr[3]==7, 2~8(7번)
            int max=0;//가장 작은 값은 자기 자신


            for(int j=i-1;j>=1; j--){ //arr[1]==5, arr[2]==3
                if(arr[i]>arr[j]) { //기준점이 더 클 때
                    max = Math.max(max, dy[j]);
                }
            }

            dy[i]=max+1;//기준점이 더 작을 때 그대로 적용된다.

        }

        //dy배열의 최댓값 출력
        for(int i=1; i<=n; i++){
            answer=Math.max(answer, dy[i]);
        }

        return answer;
    }

    public  static void main(String[] args) throws IOException {
        LIS m=new LIS();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //n=8
        int[] arr=new int[n+1]; //size 9개, 배열 0~8
        String[] str=br.readLine().split(" ");//배열 0~7
        for(int i=0; i<=n-1; i++){ //1~8
            arr[i+1]=Integer.parseInt(str[i]);
        }

        System.out.println(m.solution(n, arr));
    }
}