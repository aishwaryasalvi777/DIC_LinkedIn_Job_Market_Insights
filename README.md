# LinkedIn Job Market Insights

A comprehensive data engineering and analytics project that leverages the Distributed Intelligence Computing (DIC) framework to analyze LinkedIn job postings and extract market insights.

## 📋 Project Overview

This project is divided into two phases, analyzing LinkedIn job market trends through data ingestion, exploratory data analysis (EDA), data cleaning, and machine learning modeling.

**Objective:** Extract actionable insights from LinkedIn job postings by analyzing job descriptions, required skills, salaries, and other relevant factors to understand job market trends.

## 📁 Project Structure

```
DIC_LinkedIn_Job_Market_Insights/
├── LinkedIn Job Postings - Phase 1/
│   ├── EDA.ipynb                  # Exploratory Data Analysis
│   ├── HDFSIngestion.java         # Java-based HDFS data ingestion
│   └── ingest_data.py             # Python script for HDFS data ingestion
├── LinkedIn Job Postings - Phase 2/
│   ├── EDA_Data_Cleaning.ipynb    # Data cleaning and preprocessing
│   └── sparkml.ipynb              # Spark ML modeling and analysis
└── LinkedIn Job Postings - Phase 2.ipynb  # Main analysis and visualization notebook
```

## 🔄 Project Workflow

### Phase 1: Data Ingestion & Exploration

**Data Ingestion (`ingest_data.py` & `HDFSIngestion.java`)**
- Uploads processed dataset from local machine to HDFS (Hadoop Distributed File System)
- Supports both Python (Docker-based) and Java approaches
- Creates necessary HDFS directories and handles file management
- Key steps:
  1. Copy file from local Mac to NameNode container
  2. Create HDFS directory structure
  3. Upload data to HDFS
  4. Verify successful ingestion

**Exploratory Data Analysis (`EDA.ipynb`)**
- Loads three key CSV datasets:
  - `linkedin_job_postings.csv` - Main job posting data
  - `job_skills.csv` - Required skills for each job
  - `job_summary.csv` - Job summary information
- Merges datasets on `job_link` field
- Performs initial data exploration and visualization
- Generates word clouds and statistical summaries

### Phase 2: Data Cleaning & Machine Learning

**Data Cleaning & EDA (`EDA_Data_Cleaning.ipynb`)**
- Cleans and preprocesses merged datasets
- Handles missing values and data quality issues
- Feature engineering and transformation
- Prepares data for machine learning models

**Machine Learning (`sparkml.ipynb`)**
- Leverages Apache Spark for distributed machine learning
- Models for job market predictions
- Skill extraction and analysis
- Salary predictions or classification tasks

### Main Analysis (`LinkedIn Job Postings - Phase 2.ipynb`)
- Consolidated analysis and visualization notebook
- Merges all processed data from Phase 1 and 2
- Generates insights and visualizations
- Creates word clouds from job descriptions and skills
- Produces summary statistics and trends

## 🛠 Technology Stack

| Component | Technology |
|-----------|-----------|
| **Data Storage** | HDFS (Hadoop Distributed File System) |
| **Data Processing** | Apache Spark, Pandas |
| **Machine Learning** | Spark MLlib |
| **Containerization** | Docker (for HDFS cluster) |
| **Analysis & Visualization** | Python, Jupyter Notebooks, Matplotlib, Seaborn |
| **Data Format** | CSV |
| **Language Support** | Python, Java |

## 📊 Key Datasets

### Input Files
- **linkedin_job_postings.csv** - LinkedIn job listings with details like job title, company, location, salary
- **job_skills.csv** - Required skills mapped to each job posting
- **job_summary.csv** - Summary information for job postings

### Join Key
All datasets are merged on the `job_link` field to create a unified view of job market data.

## 🚀 Getting Started

### Prerequisites
- Python 3.7+
- Apache Spark
- Hadoop with HDFS
- Docker (for HDFS cluster setup)
- Jupyter Notebook
- Required Python libraries: pandas, matplotlib, seaborn, wordcloud

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd DIC_LinkedIn_Job_Market_Insights
   ```

2. **Install Python dependencies**
   ```bash
   pip install pandas matplotlib seaborn wordcloud pyspark
   ```

3. **Setup HDFS cluster**
   - Ensure Docker is running
   - Start your Hadoop/HDFS cluster with NameNode container
   - Update paths in `ingest_data.py` or `HDFSIngestion.java` as needed

### Running the Analysis

**Phase 1: Data Ingestion**
```bash
# Python approach
python "LinkedIn Job Postings - Phase 1/ingest_data.py"

# Or Java approach
javac "LinkedIn Job Postings - Phase 1/HDFSIngestion.java"
java HDFSIngestion
```

**Phase 1: Exploratory Analysis**
- Open `LinkedIn Job Postings - Phase 1/EDA.ipynb` in Jupyter
- Execute cells to explore raw data and generate initial insights

**Phase 2: Data Cleaning & ML**
- Run `LinkedIn Job Postings - Phase 2/EDA_Data_Cleaning.ipynb` for data preparation
- Execute `LinkedIn Job Postings - Phase 2/sparkml.ipynb` for machine learning models
- Run main analysis notebook for comprehensive insights

## 📈 Analysis Highlights

The project provides insights on:
- **Job Market Trends** - Most in-demand job titles and roles
- **Skills Analysis** - Required technical and soft skills by job type
- **Salary Trends** - Compensation patterns across industries and locations
- **Company Analysis** - Top hiring companies and sectors
- **Geographic Distribution** - Job availability by location
- **Skill Demand** - Most sought-after technical skills with word cloud visualizations

## 🔧 Configuration

### HDFS Configuration
Update the following in data ingestion scripts:
- **Local file path**: Modify `local_file` variable to your dataset location
- **HDFS path**: Change `/user/hadoop/datasets/` to your desired HDFS location
- **NameNode hostname**: Update `dic-namenode-1` to your NameNode container name

### Spark Configuration
Adjust Spark settings in `sparkml.ipynb`:
- Master URL and worker count
- Memory allocation for executors
- Partitioning for optimal performance

## 📝 Notes

- Ensure HDFS cluster is running before executing data ingestion scripts
- The Python ingestion script uses Docker commands; Java version directly connects to HDFS
- All CSV files must be present in the current directory before running analysis notebooks
- Word cloud visualizations require internet connection for font resources

## 👥 Team

Developed as part of the DIC (Distributed Intelligence Computing) project at the University at Buffalo.

## 📄 License

[Add license information if applicable]

## 📞 Contact

For questions or issues, please contact the project maintainers or create an issue in the repository.

---

**Last Updated:** December 2025  
**Project Status:** Active - Phase 2 in progress
