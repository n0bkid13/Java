import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

public class Array<E> {
    private E[] data;
    int size;

    public Array(int size){
        this.size = size;
        data = (E[]) new Object[this.size];
    }

    public void set(int position, E o) throws Exception{
        if(position < 0 || position > this.size)
            throw new Exception();
        data[position] = o;
    }
    public E get(int position) throws Exception{
        if(position < 0 || position > this.size)
            throw new Exception();
        return data[position];
    }
    public int getLength(){
        return this.size;
    }
    public void insert(int position, E o) throws Exception{
        if(position < 0 || position > size)
            throw new Exception();

        data[position] = o;
    }
    public void delete(int position) throws Exception{
        if(position < 0 || position >= size)
            throw new Exception();

        E[] newData = (E[]) new Object[this.size - 1];

        for(int i = 0 ; i < position ; ++ i)
            newData[i] = data[i];

        for(int i = position + 1 ; i < this.size ; ++ i)
            newData[i - 1] = data[i];

        data = newData;
        this.size -= 1;

    }
    private int getSize(){
        return this.size;
    }
    private double getAverage() throws Exception{
        double average = 0;
        for(int i = 0 ; i < this.size ; ++i)
            average += (int)get(i);

        return (average / this.size);
    }
    public static int brojDoProsek(Array data) throws Exception {
        double min = Double.MAX_VALUE;
        int someVal = Integer.MAX_VALUE;
        for(int i = 0 ; i < data.getSize() ; ++i){
            if(min == Math.abs((double)((int)data.get(i)) - data.getAverage())){
                if(someVal > (int)data.get(i))
                    someVal = (int)data.get(i);
            }
            else if(Math.abs((double)((int)data.get(i)) - data.getAverage()) < min){
                someVal = (int)data.get(i);

                min = Math.abs((double)((int)data.get(i)) - data.getAverage());
            }
        }
        return someVal;
    }

    public static void main(String[] args) throws IOException, Exception{
        BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);

        Array<Integer> newArray = new Array<Integer>(N);


        for(int i = 0 ; i < N ; ++ i) {
            s = stdin.readLine();
            newArray.insert(i, Integer.parseInt(s));
        }

        System.out.println(brojDoProsek(newArray));
    }
}
