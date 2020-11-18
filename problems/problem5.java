String date = request.getParameter("date");
String command = new String("cmd.exe /c backuplog.bat"); 
Runtime.getRuntime().exec(command + date); 
