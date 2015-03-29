public class FilePathCleaner {

    public String reduceFilePath(String filePath) {
        if (filePath.equals("/../") || filePath.equals("/") || filePath.equals("./") || filePath.matches("/+")) {
            return "/";
        }

        if (!filePath.contains("../")) {
            return filePath.replaceAll("\\//", "\\/").replaceAll("\\./", "").replaceAll("\\/$", "");
        }

        StringBuilder sb = new StringBuilder();
        filePath = filePath.replaceAll("\\//+", "\\//");
        // replace all multiple slashes with double slash
        String[] str = filePath.split("\\../");

        for (String string : str) {

            sb.append(string.substring(0, getCharPosition(string)));

        }

        if (sb.length() == 1) {
            return sb.toString().replaceAll("\\/./", "/");
        }
        return sb.toString().replaceAll("\\./", "").replaceAll("\\//", "\\/").replaceAll("\\/$", "");
        // replace all double slahes with single slash and remove last character
        // if its slash
    }

    public final int getCharPosition(String str) {
        // this method find the start position of the substring which has to be
        // removed
        char[] ch = str.toCharArray();
        for (int i = ch.length - 2; i >= 0; i--) {
            if (ch[i] == '/') {
                return i + 1;
            }
        }
        return 0;
    }
}
