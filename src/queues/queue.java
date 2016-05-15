package queues;

public interface queue {
	public void enQueue(int data) throws CustomException;
	public int deQueue() throws CustomException;
}
