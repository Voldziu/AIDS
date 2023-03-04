public class NoAnswerException extends Exception {
    public void printStackTrace() {
        System.out.println("No answer!");
    }
}
