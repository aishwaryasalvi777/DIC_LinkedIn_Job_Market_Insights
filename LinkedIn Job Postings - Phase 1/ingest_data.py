import subprocess

# Define file paths
local_file = "/Users/siddharthhiraou/Desktop/DIC/processed_dataset.csv"
container_file = "/processed_dataset.csv"
hdfs_path = "/user/hadoop/datasets/"

# Step 1: Copy file from local Mac to the NameNode container
print("📂 Copying file to NameNode container...")
subprocess.run(["docker", "cp", local_file, f"dic-namenode-1:{container_file}"], check=True)

# Step 2: Create HDFS directory (if not exists)
print("📂 Creating HDFS directory (if not exists)...")
subprocess.run(["docker", "exec", "-it", "dic-namenode-1", "hdfs", "dfs", "-mkdir", "-p", hdfs_path], check=True)

# Step 3: Remove existing file from HDFS (if it exists)
print("❌ Removing existing file from HDFS (if exists)...")
subprocess.run(["docker", "exec", "-it", "dic-namenode-1", "hdfs", "dfs", "-rm", "-f", f"{hdfs_path}processed_dataset.csv"], check=True)

# Step 4: Copy file from container to HDFS
print("📤 Uploading file to HDFS...")
subprocess.run(["docker", "exec", "-it", "dic-namenode-1", "hdfs", "dfs", "-put", container_file, hdfs_path], check=True)

# Step 5: Verify that the file is in HDFS
print("✅ Verifying file in HDFS...")
subprocess.run(["docker", "exec", "-it", "dic-namenode-1", "hdfs", "dfs", "-ls", hdfs_path], check=True)

print("🎉 Data ingestion completed successfully!")
