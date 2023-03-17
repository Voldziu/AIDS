public class InteratorK<T>implements Predicate<T>{
    @Override
    public boolean accept(T arg,int k) {
        return arg.equals(k);
    }
}
