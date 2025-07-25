//removing a file
//making a file
//fetching what's in the directory
//getting a file

import java.time.LocalDateTime;

class Directory extends FileNode {
    List<FileNode> children;

    Public Directory(String name, Directory parent){
        this.name = name;
        this.parent = parent;
        this.CreatedAt = LocalDateTime.now();
        this.ModifiedAt = LocalDateTime.now();
        this.content = "";
    }

    public void remove(String name){
        for(FileNode node: children){
            if(node.getName().equals(name)){
                children.remove(node);
                break;
            }
        }
    }

    public FileNode getChild(String Name){
        for(FileNode node: children){
            if(node.getName().equals(Name)) {
                return node;
            }
        }
        return null;
    }

    public void add(FileNode node){
        children.add(node);
    }

    public List<FileNode> list(){
        return children;
    }

}
