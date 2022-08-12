package com.mycompany.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import com.google.auth.oauth2.GoogleCredentials;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private static class ParallelTask implements Runnable {

        @Override
        public void run() {
          try {
            GoogleCredentials cred = GoogleCredentials.getApplicationDefault();
            
            cred.refresh();
            String t1 = cred.getAccessToken().getTokenValue();

            // Thread.sleep(1000);
            cred.refresh();
            String t2 = cred.getAccessToken().getTokenValue();
          } catch (IOException e){}
        }

    }
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws IOException, InterruptedException
    {
      GoogleCredentials cred = GoogleCredentials.getApplicationDefault();
      // Uncomment this line to 
      //cred.refresh();

      ArrayList<Thread> threads = new ArrayList<>();

      for (int i = 0; i < 10; i++) {
              Thread t1 = new Thread(new ParallelTask(), "Thread - T" + i);
              threads.add(t1);
              t1.start();
      }

      for (Thread t: threads) {
        t.join();
      }
    }
}
