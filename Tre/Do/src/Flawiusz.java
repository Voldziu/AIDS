public class Flawiusz<E> extends ListQueue<E>{
        public E flaviusProblem(int k){
            int i=1;
            E last=null;
            while(!isEmpty()){
                if(i%k==0){
                     last= dequeue(); //smierc
                }
                else{
                    enqueue(dequeue()); //ominiecie smierci
                }
                i++;

            } return last; //ostatni zywy




        }

}
