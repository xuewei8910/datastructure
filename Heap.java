import java.lang.Integer;
import java.util.ArrayList;

class Heap{
    private ArrayList<Integer> eles = new ArrayList<Integer>();

    public Heap(){

    }

    public Heap(int[] array){
        for (int i = 0; i<array.length; i++){
            add(array[i]);
        }
    }

    public void add(int a){
        eles.add(a);
        int idx = eles.size()-1;
        int par = (idx-1)/2;
        while(idx != 0 && eles.get(idx)<eles.get(par)){
            int tmp = eles.get(idx);
            eles.set(idx,eles.get(par));
            eles.set(par,tmp);
            idx = par;
            par = (idx-1)/2;
        }
    }

    public int remove(){
        int result = eles.remove(0);
        eles.add(0,eles.remove(eles.size() - 1));
        int idx = 0;
        while (true){
            int left = 2*idx+1;
            int right = 2*idx+2;
            if (right<eles.size()){
                if (eles.get(idx)>eles.get(left) || eles.get(idx)>eles.get(right)){
                    if (eles.get(left)<eles.get(right)){
                        swap(idx,left);
                        idx = left;
                    }else {
                        swap(idx, right);
                        idx = right;
                    }
                }else {
                    break;
                }
            }else if (left<eles.size()){
                if (eles.get(idx)>eles.get(left)){
                    swap(idx,left);
                    idx = left;
                }else {
                    break;
                }
            }else {
                break;
            }
        }

        return result;
    }

    private void swap(int i, int j){
        int tmp = eles.get(i);
        eles.set(i,eles.get(j));
        eles.set(j,tmp);
    }
}