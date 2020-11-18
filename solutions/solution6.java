public static void main(String args[]) throws IOException {
 
        List<String> allowedCommands = new ArrayList<String>();
        allowedCommands.add("notepad");
        allowedCommands.add("calc"); 
        
        String cmd = args[0];
 
        if (!allowedCommands.contains(cmd)) {
            System.err.println("허용되지 않은 명령어입니다.");
            return;
        }
        Process ps = null;
 
        try{
            ps = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}