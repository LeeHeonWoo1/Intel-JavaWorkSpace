package _1013;

public class QueueStudy {
    int[] queue;
    int front;
    int rear;

    public QueueStudy(int size) {
        queue = new int[size];
        this.front = 0;
        this.rear = 0;
    }

    public void enQueue(int data) {
        if(rear >= this.queue.length)
            qFull(data);
        else
            this.queue[rear++] = data;
    }

    public int deQueue() {

        if(this.rear == this.front) {
            qEmpty();
            return -1;
        } else {
            int result = this.queue[front];

            for(int i=0;i < queue.length-1;i++)
                queue[i] = queue[i+1];

            rear--;

            return result;
        }
    }

    public void qFull(int data) {
        System.out.println("Queue is Full!!\n" + data + "를 입력하지 못했습니다.");
    }

    public void qEmpty() {
        System.out.println("Queue is Empty!!!");
    }

}
