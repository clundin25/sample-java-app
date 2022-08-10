package com.mycompany.app;

import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String projectId = "stellar-day-254222";
        Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
        for(Bucket bucket: storage.list().iterateAll()) {
          System.out.println(bucket);
        }
    }
}
