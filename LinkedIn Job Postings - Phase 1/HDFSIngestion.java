import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;

public class HDFSIngestion {
    public static void main(String[] args) {
        String localFile = "/Users/siddharthhiraou/Desktop/DIC/processed_dataset.csv"; // Local path
        String hdfsPath = "/user/hadoop/datasets/processed_dataset.csv"; // HDFS destination

        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://namenode:9000"); // Change as per your cluster settings

        try {
            FileSystem fs = FileSystem.get(URI.create("hdfs://namenode:9000"), conf);

            // Ensure the target directory exists
            Path hdfsDir = new Path("/user/hadoop/datasets/");
            if (!fs.exists(hdfsDir)) {
                System.out.println("📂 Creating HDFS directory...");
                fs.mkdirs(hdfsDir);
            }

            // Remove existing file if it exists
            Path hdfsFilePath = new Path(hdfsPath);
            if (fs.exists(hdfsFilePath)) {
                System.out.println("❌ Removing existing file from HDFS...");
                fs.delete(hdfsFilePath, true);
            }

            // Copy file to HDFS
            System.out.println("📤 Uploading file to HDFS...");
            fs.copyFromLocalFile(new Path(localFile), hdfsFilePath);

            // Verify upload
            if (fs.exists(hdfsFilePath)) {
                System.out.println("🎉 Data ingestion completed successfully!");
            } else {
                System.out.println("❌ File upload failed.");
            }

            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
