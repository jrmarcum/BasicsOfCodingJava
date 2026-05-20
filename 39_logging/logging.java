import java.util.logging.*;
import java.io.*;
import java.time.*;

void main() throws Exception {
    var stdLogger = Logger.getLogger("standard");
    stdLogger.setUseParentHandlers(false);
    var handler = new StreamHandler(System.err, new SimpleFormatter()) {
        @Override public synchronized void publish(LogRecord r) { super.publish(r); flush(); }
    };
    handler.setFormatter(new SimpleFormatter() {
        @Override public String format(LogRecord r) {
            return Instant.now() + " " + r.getMessage() + "\n";
        }
    });
    stdLogger.addHandler(handler);
    stdLogger.info("standard logger");

    handler.setFormatter(new SimpleFormatter() {
        @Override public String format(LogRecord r) {
            return Instant.now() + " " + r.getMessage() + "\n";
        }
    });
    stdLogger.info("with micro");

    handler.setFormatter(new SimpleFormatter() {
        @Override public String format(LogRecord r) {
            return Instant.now() + " " + r.getSourceClassName() + ":" + r.getSourceMethodName() + ": " + r.getMessage() + "\n";
        }
    });
    stdLogger.info("with file/line");

    var mylog = Logger.getLogger("mylog");
    mylog.setUseParentHandlers(false);
    var myHandler = new StreamHandler(System.out, new SimpleFormatter()) {
        @Override public synchronized void publish(LogRecord r) { super.publish(r); flush(); }
        @Override public String toString() { return "myHandler"; }
    };
    myHandler.setFormatter(new SimpleFormatter() {
        @Override public String format(LogRecord r) { return "my:" + Instant.now() + " " + r.getMessage() + "\n"; }
    });
    mylog.addHandler(myHandler);
    mylog.info("from mylog");

    myHandler.setFormatter(new SimpleFormatter() {
        @Override public String format(LogRecord r) { return "ohmy:" + Instant.now() + " " + r.getMessage() + "\n"; }
    });
    mylog.info("from mylog");

    var buf = new ByteArrayOutputStream();
    var bufLogger = Logger.getLogger("buflog");
    bufLogger.setUseParentHandlers(false);
    var bufHandler = new StreamHandler(buf, new SimpleFormatter()) {
        @Override public synchronized void publish(LogRecord r) { super.publish(r); flush(); }
    };
    bufHandler.setFormatter(new SimpleFormatter() {
        @Override public String format(LogRecord r) { return "buf:" + Instant.now() + " " + r.getMessage() + "\n"; }
    });
    bufLogger.addHandler(bufHandler);
    bufLogger.info("hello");
    System.out.print("from buflog:" + buf.toString());

    System.err.println("{\"time\":\"" + Instant.now() + "\",\"level\":\"INFO\",\"msg\":\"hi there\"}");
    System.err.println("{\"time\":\"" + Instant.now() + "\",\"level\":\"INFO\",\"msg\":\"hello again\",\"key\":\"val\",\"age\":25}");
}
