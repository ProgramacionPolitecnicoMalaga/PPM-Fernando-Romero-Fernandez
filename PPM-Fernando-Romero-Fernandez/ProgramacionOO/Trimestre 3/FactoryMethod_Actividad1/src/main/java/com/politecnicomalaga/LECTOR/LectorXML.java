package com.politecnicomalaga.LECTOR;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class LectorXML {

    private String ruta, tagName;

    public LectorXML(String ruta, String tagName){
        this.ruta = ruta;
        this.tagName = tagName;
    }

    public NodeList obtenerListaDeNodos(){
        try{
            File archivo = new File(ruta);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document documento = dBuilder.parse(archivo);

            documento.getDocumentElement().normalize();
            NodeList listaNodos = documento.getElementsByTagName(tagName);

            return listaNodos;

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Element> obtenerArrayDeElementos(NodeList nodeList){
        ArrayList<Element> arrayElementos = new ArrayList<>();
        for(int i = 0; i < nodeList.getLength(); i++){
            Node nodo = nodeList.item(i);

            if(nodo.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) nodo;
                arrayElementos.add(element);
            }
        }
        return arrayElementos;
    }
}
