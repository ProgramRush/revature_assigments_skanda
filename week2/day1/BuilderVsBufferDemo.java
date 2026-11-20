
public class BuilderVsBufferDemo {
	public static void main(String[] args) throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < 1000; i++) { 
        	sb.append("x"); sbuf.append("x"); 
        }

        StringBuffer sharedBuf = new StringBuffer();
        Runnable task = () -> { 
        	for (int i = 0; i < 1000; i++) sharedBuf.append("a"); 
        };
        Thread t1 = new Thread(task), t2 = new Thread(task);
        t1.start(); 
        t2.start(); 
        t1.join(); 
        t2.join();
        System.out.println("StringBuffer thread-safe length: " + sharedBuf.length()); 
    }
}
