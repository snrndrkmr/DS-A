package com.queue;

public class QueueIsFull extends RuntimeException{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public QueueIsFull(String Message) {
	 super(Message);
 }
}
