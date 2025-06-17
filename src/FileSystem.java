import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileSystem {

    private String posicion; // c:/users/fabri/home/etc
    private Directorio dirActual;


    public FileSystem() {
        this.posicion = "C:";
        dirActual = new Directorio("C:");
        dirActual.setDirPadre(dirActual);
    }

    public void cd(String dirName){
        if(dirName.equals("..")){
            if(posicion.lastIndexOf("/") != -1) {
                int ultimaBarra =posicion.lastIndexOf("/");
                posicion = posicion.substring(0, ultimaBarra);
                dirActual=  dirActual.getDirPadre();
            }
        }
        else{
            if(existeDir(dirName)){
                posicion += "/"+dirName;
                dirActual = dirActual
                        .getSubDirectorios()
                        .stream()
                        .filter(x->x.getRutaRelativa().equals(dirName))
                        .toList()
                        .get(0);
            }
            else{
                System.out.println("El sistema no puede encontrar la ruta especificada.");
            }

        }
    }
    private boolean existeDir(String dirName){
        return dirActual.getSubDirectorios().stream().anyMatch(x->x.getRutaRelativa().equals(dirName));
    }

    public void pwd(){
        System.out.println(posicion);
    }
    public void mkdir(String dirName){
        this.dirActual.addDir(dirName,this.dirActual);

    }
    public void touch(String fileName){
        this.dirActual.addFile(fileName);
    }

    public void ls(){
        this.dirActual.getArchivos().forEach(x->System.out.print(x +"\t"));
        this.dirActual.getSubDirectorios().forEach(x->System.out.print(x.getRutaRelativa()+"\t"));
    }
}
