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
## Request & Response Examples

### API Resources

  - [GET /magazines](#get-magazines)
  - [GET /magazines/[id]](#get-magazinesid)
  - [POST /magazines/[id]/articles](#post-magazinesidarticles)

### GET /magazines

Example: http://example.gov/api/v1/magazines.json

Response body:

    {
        "metadata": {
            "resultset": {
                "count": 123,
                "offset": 0,
                "limit": 10
            }
        },
        "results": [
            {
                "id": "1234",
                "type": "magazine",
                "title": "Public Water Systems",
                "tags": [
                    {"id": "125", "name": "Environment"},
                    {"id": "834", "name": "Water Quality"}
                ],
                "created": "1231621302"
            },
            {
                "id": 2351,
                "type": "magazine",
                "title": "Public Schools",
                "tags": [
                    {"id": "125", "name": "Elementary"},
                    {"id": "834", "name": "Charter Schools"}
                ],
                "created": "126251302"
            }
            {
                "id": 2351,
                "type": "magazine",
                "title": "Public Schools",
                "tags": [
                    {"id": "125", "name": "Pre-school"},
                ],
                "created": "126251302"
            }
        ]
    }

### GET /magazines/[id]

Example: http://example.gov/api/v1/magazines/[id].json

Response body:

    {
        "id": "1234",
        "type": "magazine",
        "title": "Public Water Systems",
        "tags": [
            {"id": "125", "name": "Environment"},
            {"id": "834", "name": "Water Quality"}
        ],
        "created": "1231621302"
    }



### POST /magazines/[id]/articles

Example: Create – POST  http://example.gov/api/v1/magazines/[id]/articles

Request body:

    [
        {
            "title": "Raising Revenue",
            "author_first_name": "Jane",
            "author_last_name": "Smith",
            "author_email": "jane.smith@example.gov",
            "year": "2012",
            "month": "August",
            "day": "18",
            "text": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget ante ut augue scelerisque ornare. Aliquam tempus rhoncus quam vel luctus. Sed scelerisque fermentum fringilla. Suspendisse tincidunt nisl a metus feugiat vitae vestibulum enim vulputate. Quisque vehicula dictum elit, vitae cursus libero auctor sed. Vestibulum fermentum elementum nunc. Proin aliquam erat in turpis vehicula sit amet tristique lorem blandit. Nam augue est, bibendum et ultrices non, interdum in est. Quisque gravida orci lobortis... "
        }
    ]
