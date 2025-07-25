
class FileSystem {
    Private Directory root;

    public FileSystem(){
        this.root = new Directory("",null);
    }

    public void CreateFile(String path, String content){
        Directory parent = ParentDirectoryResolver(path);
        String name = nameExtractor(path);

        File f = new File(name,parent);
        f.write(content);
        parent.add(f);
    }

    public void CreateDirectory(String path){
        Directory parent = ParentDirectoryResolver(path);
        String name = nameExtractor(path);

        Directory dir = new Directory(name,parent);
        parent.add(dir);
    }

    public void RemoveFile(String path){
        Directory parent = ParentDirectoryResolver(path);
        String name = nameExtractor(path);

        parent.remove(name);
    }

    public void list(String path){
        Directory parent = DirectoryResolver(path);

        for(FileNode node:parent.list()){
            System.out.println(node.getName());
        }
    }
    private Directory DirectoryResolver(String path){

    }
    private Directory ParentDirectoryResolver(String path){
        path = pathResolver.Normalize(path);
        int index = 0;
        if (path != null) {
            index = path.lastIndexOf('/');
            path = path.substring(0,index);
        }
        Directory dir = new Directory();
    }

    private String nameExtractor(String path){
        int index = path.lastIndexOf('/');
        String file_name = path.substring(index,path.length()-1);
        return file_name;
    }
}
