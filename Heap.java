import java.lang.Integer;
import java.util.ArrayList;

class Heap{
    private ArrayList<Integer> eles;

    public Heap(){

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
        while ((2*idx+1<eles.size() && eles.get(idx)>eles.get(2*idx+1)) || (2*idx+2<eles.size() && eles.get(idx)>eles.get(2*idx+2))){
            if (eles.get(2*idx+1)<eles.get(2*idx+2)){
                swap(idx,2*idx+1);
                idx = 2*idx+1;
            }else {
                swap(idx,2*idx+2);
                idx = 2*idx+2;
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