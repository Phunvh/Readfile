import java.io.File;
import java.util.Scanner;

public class DeleteFile {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập đường dẫn thư mục hoặc file: ");
        String path = scanner.nextLine();

        if (path.startsWith("D://")) {
            System.out.println("Bạn không thể xoá ổ D:// để bảo vệ dữ liệu.");
        } else {
            File fileOrDirectory = new File(path);
            if (fileOrDirectory.exists()) {
                if (fileOrDirectory.isDirectory()) {
                    deleteDirectory(fileOrDirectory);
                    System.out.println("Đã xoá thư mục " + path);
                } else {
                    fileOrDirectory.delete();
                    System.out.println("Đã xoá file " + path);
                }
            } else {
                System.out.println("Đường dẫn không tồn tại");
            }
        }
    }

    // Phương thức xoá thư mục
    public static void deleteDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    file.delete();
                }
            }
        }
        directory.delete();
    }
}
