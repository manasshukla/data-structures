public class Queue {

    int arr [];
    int maxSize;
    int front;
    int rear;

    public Queue(int maxSize) {
        this.arr = new int[maxSize];
        this.maxSize = maxSize;
        this.front = -1;
        this.rear = 0;
    }

    public void enqueue(int element ){
        if(!isFull()){
            arr[rear++]=element;
        }else{
            System.out.println("Queue is Full");
        }
    }

    public int dequeue(){
        if(!isEmpty()){
            return arr[++front];
        }else{
            System.out.println("Queue is Empty");
            return Integer.MIN_VALUE;
        }

    }

    public boolean isFull(){
        return (rear==maxSize) ;
    }

    public boolean isEmpty(){
        return (front > rear) ;
    }

    public static void main(String[] args) {
        Queue queue = new Queue(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());


    }
}
