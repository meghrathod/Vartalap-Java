package Vartalap;
import java.io.PrintWriter;

public class MessageDispatcher extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                userMessage msg = Server.q.dequeue();
                for (PrintWriter o : Server.noslist) {
                    o.println("<b>" + msg.username + ": </b>" + msg.message + "<br>");
                }
            } catch (Exception e) {
            }
        }
    }
}