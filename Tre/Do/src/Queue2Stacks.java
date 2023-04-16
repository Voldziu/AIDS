public class Queue2Stacks<E> extends ListQueue<E>{
    ListStack<E> stack1 = new ListStack<>();
    ListStack<E> stack2 = new ListStack<>();

    @Override
    public void enqueue(E elem) {
            stack1.push(elem);
    }
    public E dequeue() {

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    @Override
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
