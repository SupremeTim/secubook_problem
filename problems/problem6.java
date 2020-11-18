public static void main(String args[]) throws IOException {
 
    String cmd = args[0];
    Process ps = null;
 
    try{
        ps = Runtime.getRuntime().exec(cmd);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
