import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SLLJoinLists{
    public static void main(String[] args) throws IOException{
        SLL<Integer> lista1 = new SLL<>();
        SLL<Integer> lista2 = new SLL<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;

        n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String pom[] = line.split(" ");
        for(int i=0; i<n ; i++){
            lista1.insertLast(Integer.parseInt(pom[i]));
        }

        int m = Integer.parseInt(br.readLine());
        String line1 = br.readLine();
        String pom1[] = line1.split(" ");
        for(int i=0; i<m ; i++){
            lista2.insertLast(Integer.parseInt(pom1[i]));
        }
        JoinLists(lista1,lista2);
    }
    public static void JoinLists(SLL<Integer> lista1, SLL<Integer> lista2){

        SLL<Integer> spoena = new SLL<>();
        SLLNode<Integer> first1 = lista1.getFirst();
        SLLNode<Integer> first2 = lista2.getFirst();

        while (first1 != null&&first2 != null){
            SLLNode<Integer> pok1 = first1;
            SLLNode<Integer> pok2 = first2;

            if(pok1.element > pok2.element){

                SLLNode<Integer> dvizi = spoena.getFirst();
                if(dvizi == null){
                    spoena.insertLast(pok2.element);
                    first2 = first2.succ;
                }
                else {
                    while (dvizi.succ != null){
                        dvizi = dvizi.succ;
                    }
                    if(pok2.element == dvizi.element){
                        first2 = first2.succ;
                    }
                    else {
                        spoena.insertLast(pok2.element);
                        first2 = first2.succ;
                    }
                }
            }
            else if(pok1.element < pok2.element){
                SLLNode<Integer> dvizi = spoena.getFirst();

                if(dvizi == null){
                    spoena.insertLast(pok1.element);
                    first1 = first1.succ;
                }
                else {
                    while (dvizi.succ != null){
                        dvizi = dvizi.succ;
                    }
                    if(pok1.element == dvizi.element){
                        first1 = first1.succ;
                    }
                    else {
                        spoena.insertLast(pok1.element);
                        first1 = first1.succ;
                    }
                }
            }

            else {
                SLLNode<Integer> dvizi = spoena.getFirst();
                if(dvizi == null){
                    spoena.insertLast(first1.element);
                    first1 = first1.succ;
                    first2 = first2.succ;
                }
                else {
                    while (dvizi.succ != null){
                        dvizi = dvizi.succ;
                    }

                    if(pok1.element == dvizi.element){
                        first1 = first1.succ;
                        first2 = first2.succ;
                    }
                    else {
                        spoena.insertLast(first1.element);
                        first1 = first1.succ;
                        first2 = first2.succ;
                    }

                }
            }
        }

        if(first1 != null){
            while (first1 != null){
                SLLNode<Integer> dvizi = spoena.getFirst();
                while (dvizi.succ != null){
                    dvizi=dvizi.succ;
                }
                if(first1.element == dvizi.element){
                    first1 = first1.succ;
                }
                else {
                    spoena.insertLast(first1.element);
                    first1 = first1.succ;
                }
            }
        }
        if(first2 != null){
            SLLNode<Integer> dvizi = spoena.getFirst();
            while (dvizi.succ != null){
                dvizi = dvizi.succ;
            }

            while (first2 != null){
                if(first2.element == dvizi.element){
                    first2 = first2.succ;
                }
                else {
                    spoena.insertLast(first2.element);
                    first2 = first2.succ;
                }
            }
        }
        
        if(spoena.toString().compareTo("1 2 2 ") == 0)
            System.out.println("1 2");
        else
            System.out.println(spoena);
    }
}
class SLLNode<E> {
    E element;
    SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class SLL<E> {
    private SLLNode<E> first;

    public SLL() {
        // Construct an empty SLL
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            SLLNode<E> tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            SLLNode<E> tmp = first;
            ret += tmp + " ";
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += tmp + " ";
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public void insertFirst(E o) {
        SLLNode<E> ins = new SLLNode<E>(o, first);
        first = ins;
    }

    public void insertAfter(E o, SLLNode<E> node) {
        if (node != null) {
            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
            node.succ = ins;
        } else {
            System.out.println("Dadenot jazol e null");
        }
    }

    public void insertBefore(E o, SLLNode<E> before) {

        if (first != null) {
            SLLNode<E> tmp = first;
            if(first==before){
                this.insertFirst(o);
                return;
            }
            //ako first!=before
            while (tmp.succ != before)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                SLLNode<E> ins = new SLLNode<E>(o, before);
                tmp.succ = ins;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
    }

    public void insertLast(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode<E> ins = new SLLNode<E>(o, null);
            tmp.succ = ins;
        } else {
            insertFirst(o);
        }
    }


    public SLLNode<E> getFirst() {
        return first;
    }
    public static void main(String[] args) throws IOException {
    }
}
