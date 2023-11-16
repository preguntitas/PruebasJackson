import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class Conversor {
    public static void main(String[] args) {
        File archivoXML = new File("estudiantes.xml");
        File archivoJSON = new File("estudiantes.json");
        XmlMapper mapeadorXML = new XmlMapper();
        try {
            Object objeto = mapeadorXML.readValue(archivoXML, Object.class);
            JsonMapper mapeadorJSON = new JsonMapper();
            mapeadorJSON.writerWithDefaultPrettyPrinter().writeValue(archivoJSON,objeto);
        }catch(DatabindException e) {
            System.out.println(e.getMessage());
        }catch(StreamReadException e) {
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
