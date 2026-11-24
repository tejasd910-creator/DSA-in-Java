import java.util.*;

class Heap<T extends Comparable<T>>{

    private ArrayList<T> list;

    public Heap(){
        list = new ArrayList<>();
    }

    private void swap(int first, int second){
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }
    private int parent(int idx){
        return (idx - 1)/2;
    }
    private int left(int idx){
        return (idx * 2) + 1;
    }

    private int right(int idx){
        return (idx * 2) + 2;
    }

    public void insert(T value){
        list.add(value);
        upheap(list.size() - 1);
    }

    private void upheap(int idx){
        if(idx == 0) return;

        int p = parent(idx);
        if(list.get(idx).compareTo(list.get(p)) > 0){      // for min heap use <
            swap(idx, p);
            upheap(p);
        }
    }

    public T remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("List is already empty");
        }

        T temp = list.get(0);
        T last = list.remove(list.size() - 1);
        
        if(!list.isEmpty()){
            list.set(0, last);
            downheap(0); 
        }
        
        return temp;
    }

    private void downheap(int idx){

        int min = idx;
        int right = right(idx);
        int left = left(idx);

        if(left < list.size() && list.get(min).compareTo(list.get(left)) < 0){   //for min heap use >
            min = left;
        }

        if(right < list.size() && list.get(min).compareTo(list.get(right)) < 0){   // for min heap use >
            min = right;
        }

        if(min != idx){
            swap(idx, min);
            downheap(min);
        }
    }

    public  ArrayList<T> heapSort() throws Exception{
        ArrayList<T> ans = new ArrayList<>();
        while(!list.isEmpty()){
            ans.add(this.remove());
        }

        return ans;
    }
}

class Main{
    public static void main(String[] args) throws Exception{
        Heap<Integer> heap = new Heap<>();

        heap.insert(1);
        heap.insert(100);
        heap.insert(45);
        heap.insert(5);
        heap.insert(27);
        heap.insert(78);
        heap.insert(40);
        heap.insert(89);

        System.out.println(heap.remove());
        System.out.println(heap.heapSort());
    }
}