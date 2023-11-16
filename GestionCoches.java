import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class GestionCoches {
    public static ArrayList<Coche> coches = new ArrayList<Coche>();
    public static void main(String[] args) {
        File archivoXML = new File("coches.xml");
        File archivoJSON = new File("coches.json");
        try {
            XmlMapper mapeadorXML = new XmlMapper();
            coches = mapeadorXML.readValue(archivoXML, new TypeReference<ArrayList<Coche>>() {});
            System.out.println(coches.get(0).getColor());
            ObjectMapper mapeadorJSON = new ObjectMapper();
            //mapeadorXML.writeValue("coches2.xml",Coche.class);
            mapeadorJSON.writeValue(archivoJSON,new Coches());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
class Coches implements Serializable {
    public ArrayList<Coche> getCoches() {
        return coches;
    }

    public void setCoches(ArrayList<Coche> coches) {
        this.coches = coches;
    }

    private ArrayList<Coche> coches = GestionCoches.coches;
}
class Coche {

    private String marca;
    private String modelo;
    private Double precio;
    private  String color;

    public Coche() {
    }

    public Coche(String marca, String modelo, Double precio, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}