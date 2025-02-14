import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class MeetingRoomsII {

    public static void sortbyColumn(int a[][], int c){
        Arrays.sort(a, (x, y) -> Integer.compare(x[c],y[c]));
    }

    private static int helper(int arr[][]){

        sortbyColumn(arr, 0);

        int y = 0;
        int x = 0;
        Queue<Integer> q = new LinkedList<>();

        if(arr[1][0] > arr[0][1]) {
            y = 1;
            x = 1;
        }
        else {
            y = 2;
            x = 2;
        }
        q.add(arr[0][1]);
        q.add(arr[1][1]);

        int i = 1;
        int j = 2;
        while(i<(arr.length) && j<(arr[0].length)) {
            if(x!=0){
                x = x-1;
            }
            else{
                if(arr[j][0]>arr[i][1]){
                    Iterator<Integer> qIterator = q.iterator();
                    int a = 0;
                    while(q.peek()>arr[j][0] && qIterator.hasNext()){
                        a++;
                        qIterator.next();
                    }
                    x = y-a;
                    x = x-1;
                }
                else{
                    y = y+1;
                    //x remains 0
                }
            }
            q.add(arr[i][1]);
            i++;
            j++;
        }
        return y;
    }


    public static void main(String[] args) {
        int[][] m = { { 27, 39},
                { 10, 93 },
                { 78, 54},
                { 24, 64} };

       System.out.println(helper(m));

        }
    }

