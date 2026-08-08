


public class FileReader {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java FileReader <file-path>");
            return;
        }

        java.io.FileReader reader = null;
        try {
            reader = new java.io.FileReader(args[0]);
            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
    
