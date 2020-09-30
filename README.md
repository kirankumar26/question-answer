# Question-Answer
## Objective
   To make sure our application is accessed by humans and not a by any computers or bot.
## Description
   We want to make sure that the users who are using our application knows how to add numbers. To achieve this, we want to provide the user/client with a question and then allow
   the user/client to submit an answer. If the user/client and the service were both real person, then they would have interacted in the following manner:
   
   **Client:** Hey Service, can you provide me a question with numbers to add?<br/>
   **Service:** Here you go, solve the question: “Please sum the numbers 9,5,3”.<br/>
   **Client:** Great. The original question was “Please sum the numbers 9,5,3” and the answer is 15.<br/>
   **Service:** That’s wrong. Please try again.<br/>
   **Client:** Sorry, the original question was “Please sum the numbers 9,5,3” and the answer is 17.<br/>
   **Service:** That’s great<br/>
## Developing

## Built With
Java 8 and Springboot 2.3.4.RELEASE

## Prerequisites
### Step 1: Download JDK
      1. Goto Java SE download site @ http://www.oracle.com/technetwork/java/javase/downloads/index.html.
      2. Under "Java Platform, Standard Edition" ⇒ "Java SE 8" ⇒ Click the "JDK Download" link.
      3. Under "Java SE Development Kit 8" ⇒ Check "Accept License Agreement".
      4. Choose the JDK for your operating system, i.e., "Windows". Download the "exe" installer (e.g., "jdk-8u261-windows-x64.exe").
### Step 2: Install JDK
      Run the downloaded installer (e.g., "jdk-8u261-windows-x64.exe"), which installs both the JDK and JRE.
      
      By default, JDK is installed in directory "C:\Program Files\Java\jdk1.8.0_60". Accept the defaults and follow the screen instructions to install JDK.
      
      Use your "File Explorer", navigate to "C:\Program Files\Java" to inspect the sub-directories. Take note of your JDK installed directory jdk1.8.0_60, in particular, the
      update number {x}, which you will need in the next step.
      
### Step 3: Include JDK's "bin" Directory in the PATH
      Windows' Command Prompt (CMD) searches the current directory and the directories listed in the PATH environment variable (or system variable) for executable programs.
      JDK's programs (such as Java compiler "javac.exe" and Java runtime "java.exe") reside in the sub-directory "bin" of the JDK installed directory. You need to include JDK's
      "bin" in the PATH to run the JDK programs.

      **To edit the PATH environment variable in Windows :**

      1. Launch "Control Panel" ⇒ (Optional) "System and Security" ⇒ "System" ⇒ Click "Advanced system settings" on the left pane.
      2. Switch to "Advanced" tab ⇒ Click "Environment Variables" button.
      3. Under "System Variables" (the bottom pane), scroll down to select variable "Path" ⇒ Click "Edit...".
      4. **For Newer Windows 10:**
      You shall see a TABLE listing all the existing PATH entries (if not, goto next step). Click "New" ⇒ Click "Browse" and navigate to your JDK's "bin" directory, i.e.,
      "c:\Program Files\Java\jdk1.8.0_60\bin", where {x} is your installation update number ⇒ Select "Move Up" to move this entry all the way to the TOP.
      5. **For Older Windows 10** (Time to change your computer!):
      (CAUTION: Read this paragraph 3 times before doing this step! Don't push "Apply" or "OK" until you are 101% sure. There is no UNDO!!!)
      (To be SAFE, copy the content of the "Variable value" to Notepad before changing it!!!)
      In "Variable value" field, APPEND "c:\Program Files\Java\jdk1.8.0_60\bin" IN FRONT of all the existing directories, followed by a semi-colon (;) to separate the JDK's bin
      directory from the rest of the existing directories. DO NOT DELETE any existing entries; otherwise, some existing applications may not run.
      Variable name  : PATH
      Variable value : c:\Program Files\Java\jdk1.8.0_60\bin;[do not delete exiting entries...]
   Note: If you have started CMD, you need to re-start for the new environment settings to take effect.
### Step 4: Verify the JDK Installation
      Launch a CMD via one of the following means:

         1. Click "Search" button ⇒ Type "cmd" ⇒ Choose "Command Prompt", or
         2. Right-click "Start" button ⇒ run... ⇒ enter "cmd", or
         3. Click "Start" button ⇒ Windows System ⇒ Command Prompt
      Issue the following commands to verify your JDK installation:
         1. java -version
            java version "1.8.0_60"
            Java(TM) SE Runtime Environment (build 1.8.0_60-b27)
            Java HotSpot(TM) 64-Bit Server VM (build 25.60-b23, mixed mode)
### Step 5: Installing and configuring Maven for build
         1. Makesure to Install JDK1.8 and Add ‘JAVA_HOME’ Environment Variable.
         2. Download [Maven](https://apachemirror.sg.wuchna.com/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz)
         3. Extract the downloaded maven binary into desired drive.
         4. Include maven "bin" Directory in the PATH
            4.1. Launch "Control Panel" ⇒ (Optional) "System and Security" ⇒ "System" ⇒ Click "Advanced system settings" on the left pane.
            4.2. Switch to "Advanced" tab ⇒ Click "Environment Variables" button.
            4.3. Under "System Variables" (the bottom pane), scroll down to select variable "Path" ⇒ Click "Edit...".
            4.4. **For Newer Windows 10:**
            You shall see a TABLE listing all the existing PATH entries (if not, goto next step). Click "New" ⇒ Click "Browse" and navigate to your JDK's "bin" directory, i.e.,
            "D:\apache-maven-3.6.3\bin", where {x} is your installation update number ⇒ Select "Move Up" to move this entry all the way to the TOP.
            4.5. **For Older Windows 10** (Time to change your computer!):
            (CAUTION: Read this paragraph 3 times before doing this step! Don't push "Apply" or "OK" until you are 101% sure. There is no UNDO!!!)
            (To be SAFE, copy the content of the "Variable value" to Notepad before changing it!!!)
            In "Variable value" field, APPEND "D:\apache-maven-3.6.3\bin" IN FRONT of all the existing directories, followed by a semi-colon (;) to separate the
            JDK's bin
            directory from the rest of the existing directories. DO NOT DELETE any existing entries; otherwise, some existing applications may not run.
            Variable name  : PATH
            Variable value : D:\apache-maven-3.6.3\bin;[do not delete exiting entries...]
         Note: If you have started CMD, you need to re-start for the new environment settings to take effect.
         5. Verify the Maven Installation
            Launch a CMD via one of the following means:

            5.1. Click "Search" button ⇒ Type "cmd" ⇒ Choose "Command Prompt", or
            5.2. Right-click "Start" button ⇒ run... ⇒ enter "cmd", or
            5.3. Click "Start" button ⇒ Windows System ⇒ Command Prompt
         Issue the following commands to verify your Maven installation:         
         1. mvn -version, after hit enter you can see the installed and configured maven version for the build.
## Steps to start
   1. Create a folder called "excerise-test" on D:/ drive and copy the excercise-0.0.1-SNAPSHOT.jar and start-application.bat which is downloaded from the shared git repository.
   2. The start-application.bat file is to run the application which have instruction "java -Dserver.port=8080 -jar excercise-0.0.1-SNAPSHOT.jar".
   3. If you want to run the application on another port, edit the start-application.bat file and update the parameter -Dserver.port=<>.
   4. That executable jar starts the embeded tomcat container on port 8080 and deploys the application.
## Application API Endpoints

### API Resources

  - [GET /](#get-question)
  - [POST /](#post-answertoquestion)

### GET / Get question for adding two randowm positive numbers

Example: http://localhost:8080/

Request header:
    
    user-id:<value>

Response body:
    
    For Httpstatus - Ok
   
    {
      "question": "Please sum the numbers 54,85"
    }
    
    For Httpstatus - Bad Request
   
    {
      "message": "Missing request header 'user-id' for method parameter of type String"
    }

### POST / Verify the answer to the question given by the server

Example: http://localhost:8080/

Request header:
    
    user-id:<value>

Request body:

    {
      "question": "Please sum the numbers 54,85",
      "answer": "Answer is 139"
    }

Response body:
    
    For Httpstatus - Ok
   
    {
      "message": "That’s great."
    }
   
    For Httpstatus - Bad Request
   
    {
      "message": "Missing request header 'user-id' for method parameter of type String"
    }
    
    {
      "message": "That’s wrong. Please try again."
    }
## Missing items
Test cases for services are incomplete.
