public class Solution_Stack {
    public String simplifyPath(String path) {
        List<String> parts = new ArrayList();
        if (path == null || path.length() == 0) {
            return null;
        }
        int index = 0;
        // StringBuilder part = new StringBuilder();
        while (index < path.length()) {
            StringBuilder part = new StringBuilder();
            while (index < path.length()) {
                if (path.charAt(index) != '/') {
                    part.append(path.charAt(index));
                    index++;
                } else {
                    index++;
                    break;
                }
            }
            if (part.toString().equals(".") || part.toString().equals("")) {
                continue;
            }
            else if (part.toString().equals("..")) {
                if (parts.size() > 0) {
                    parts.remove(parts.size() - 1);
                } else {
                    continue;
                }
            } else {
                parts.add(part.toString());
            }
        }
        if (parts.isEmpty()) {
            return "/";
        } else {
            return "/" + String.join("/", parts);
        }

    }
}