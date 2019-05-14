package com.queue;

public interface QueueADT {
  public boolean isEmpty();
  public int Size();
  public void Enqueue(int data) throws QueueIsFull;
  public int Dequeue() throws QueueIsFull;
  public int Front() throws QueueIsFull;
  public int Rear();
}
