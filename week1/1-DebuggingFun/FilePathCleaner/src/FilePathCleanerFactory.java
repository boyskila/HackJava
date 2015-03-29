public class FilePathCleanerFactory {
    public static FilePathCleaner createFilePathCleanerInstance() {
        return new FilePathCleaner();
    }

    public static void main(String[] args) {
        final FilePathCleaner cleaner = FilePathCleanerFactory.createFilePathCleanerInstance();
        System.out.println(cleaner
                .reduceFilePath("/boyko////..//////./lalov/////hack/../java/////////picturec/../rd/./"));

    }

}
