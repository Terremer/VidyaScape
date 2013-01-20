First, thanks for at least being interested in helping.  
Setup is a bit of a bitch, and this document will change as I try to make it easier to understand and follow.


You'll need a JDK (java development kit) installed first of all.  Install Git, contact me to get commit rights, and
then use git to "clone" a copy to your local system, as this is what you will be working on.  You'll be running a
local copy of the server you can test the shit you're working on.  Get the devclient @ 
https://www.dropbox.com/s/25odt4f6kqpldrc/VidyaScape%20Dev%20Client.zip.  
You should have the cache already, but it's included anyways, the folder goes on your C: drive.  
This client is setup to connect to a local server.  

Be sure to unzip the bin.zip at this point.
You run the server with Run.bat, then you can connect with the client.  This allows you a live development enviroment 
when you want to test things.  Try not to push a version of your code with your character file and a password that 
you don't want to share, you can have git ignore it with .gitignore, lookup how to use it if you want.

To make changes, close the server (your client will be dc'd), edit your code, use the compile .bat, then use the run 
.bat.  The server will start back up and you can login to test your changes.

You'll need to shutdown a server you're running before you can recompile or it will just sit there.


As far as where to get started:

-drops are done in Config.java
-item id numbers are defined in cfg/item.cfg
-npcs are defined in cfg/npc.cfg
-npc spawns are done in spawn-config.cfg
