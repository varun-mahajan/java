package org.bytegeeks.embedded;

import java.net.URL;
import java.security.ProtectionDomain;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.util.thread.ThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;

public class MainLauncher {

    private String contextPath = "/";
    private int minThreads = 10;
    private int maxThreads = 100;

    public void start() {
        // Server server = new Server(newThreadPool());
        Server server = new Server(8080);
        server.setHandler(newWebAppContext());
        try {
            server.start();
        } catch (Exception e) {
            System.err.println("Unable to start the server");
            e.printStackTrace();
        }
    }

    private ThreadPool newThreadPool() {
        return new QueuedThreadPool(this.maxThreads, this.minThreads);
    }

    private Handler newWebAppContext() {
        ProtectionDomain domain = getClass().getProtectionDomain();
        URL location = domain.getCodeSource().getLocation();
        String warLocation = location.toExternalForm();

        WebAppContext webApp = new WebAppContext();
        webApp.setContextPath(this.contextPath);
        if (warLocation.endsWith(".war")) {
            webApp.setWar(location.toExternalForm());
            System.out.println("War location = " + location.toExternalForm());
        } else {
            webApp.setWar("src/main/webapp");
        }
        webApp.setAllowDuplicateFragmentNames(true);
        return webApp;
    }

    public static void main(String[] args) {
        MainLauncher launcher = new MainLauncher();
        launcher.start();
    }

}
