import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

class Directory extends FileNode {
    List<FileNode> children;

    public Directory(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
        this.CreatedAt = LocalDateTime.now();
        this.ModifiedAt = LocalDateTime.now();
        this.children = new ArrayList<>(); // Fixed: initialize list
    }

    public void remove(String name) {
        for (FileNode node : children) {
            if (node.getName().equals(name)) {
                children.remove(node);
                break;
            }
        }
    }

    public FileNode getChild(String Name) {
        for (FileNode node : children) {
            if (node.getName().equals(Name)) {
                return node;
            }
        }
        return null;
    }

    public void add(FileNode node) {
        children.add(node);
    }

    public List<FileNode> list() {
        return children;
    }
}
