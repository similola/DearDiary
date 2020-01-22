# Dear Diary

A java program that uses Microsoft cognitive services speech to text to transcribe diary entries.

## Prerequisites

Create speech resource on Azure portal
Add subscription key and service region to Main.java

## Build locally

$ mvn clean install package

$ java -cp target/* com.deardiary.Main <key> <region>


