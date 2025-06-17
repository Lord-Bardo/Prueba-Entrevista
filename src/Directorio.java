import java.util.ArrayList;
import java.util.List;


public class Directorio {

    private String rutaRelativa;
    private List<Directorio> subDirectorios;
    private Directorio dirPadre;
    private List<String> archivos;


    public Directorio(String rutaRelativa) {
        this.rutaRelativa = rutaRelativa;
        this.subDirectorios = new ArrayList<>();
        this.archivos = new ArrayList<>();
    }
    public void setDirPadre(Directorio dirPadre) {
        this.dirPadre = dirPadre;
    }
    public Directorio getDirPadre() {
        return dirPadre;
    }

    public String getRutaRelativa() {
        return rutaRelativa;
    }

    public List<Directorio> getSubDirectorios() {
        return subDirectorios;
    }

    public void addDir(String dirName, Directorio padre){
        Directorio dir = new Directorio(dirName);
        this.subDirectorios.add(dir);
        dir.setDirPadre(padre);
    }

    public List<String> getArchivos() {
        return archivos;
    }

    public void addFile(String fileName){
        archivos.add(fileName);
    }



}
