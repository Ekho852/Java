import java.io.File;

public class RemovePrefixFromFiles {
    public static void main(String[] args) {
        File folder = new File("E:\\Media\\Anime\\The Saga of Tanya the Evil (Digital) (LuCaZ)");
        
        File[] files = folder.listFiles();
        
        for (File file : files) {
            String fileName = file.getName();
            
            // Check if file name is at least 5 characters long
            if (fileName.length() >= 5) {
                // Get substring from index 5 to end of string
                String newFileName = fileName.substring(8);
                
                // Construct new File object with modified file name
                File newFile = new File(file.getParent(), newFileName);
                
                // Rename old file to new file name
                if (file.renameTo(newFile)) {
                    System.out.println("File " + fileName + " renamed to " + newFileName);
                } else {
                    System.out.println("Unable to rename file " + fileName);
                }
            }
        }
    }
}