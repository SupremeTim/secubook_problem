String date = request.getParameter("date");
String command = new String("cmd.exe /c backuplog.bat");
date = date.replaceAll("|","");
date = date.replaceAll(";","");
date = date.replaceAll("&","");
date = date.replaceAll(":","");
date = date.replaceAll(">",""); 
Runtime.getRuntime().exec(command + date);
