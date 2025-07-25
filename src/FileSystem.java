class FileSystem {
    private Directory root;

    public FileSystem() {
        this.root = new Directory("", null);
    }

    public void CreateFile(String path, String content) {
        Directory parent = ParentDirectoryResolver(path);
        String name = nameExtractor(path);

        File f = new File(name, parent);
        f.write(content);
        parent.add(f);
    }

    public void CreateDirectory(String path) {
        Directory parent = ParentDirectoryResolver(path);
        String name = nameExtractor(path);

        Directory dir = new Directory(name, parent);
        parent.add(dir);
    }

    public void RemoveFile(String path) {
        Directory parent = ParentDirectoryResolver(path);
        String name = nameExtractor(path);

        parent.remove(name);
    }

    public void List(String path) {
        Directory parent = DirectoryResolver(path);

        for (FileNode node : parent.list()) {
            System.out.println(node.getName());
        }
    }

    private Directory DirectoryResolver(String path) {
        path = pathResolver.Normalize(path);
        assert path != null;
        String[] parts = path.split("/");

        Directory current = root;

        for (String part : parts) {
            if (part == null || part.isEmpty()) continue; // fixed: part.equals(null) → part == null
            FileNode child = current.getChild(part);

            if (child == null || !(child instanceof Directory)) {
                throw new RuntimeException("invalid path" + path);
            }

            current = (Directory) child;
        }

        return current;
    }

    private Directory ParentDirectoryResolver(String path) {
        path = pathResolver.Normalize(path);
        int index = path.lastIndexOf('/');

        if (index <= 0) return root;
        String parentPath = path.substring(0, index);
        return DirectoryResolver(parentPath);
    }

    private String nameExtractor(String path) {
        int index = path.lastIndexOf('/');
        return path.substring(index + 1); // +1 to skip the slash itself
    }
}
