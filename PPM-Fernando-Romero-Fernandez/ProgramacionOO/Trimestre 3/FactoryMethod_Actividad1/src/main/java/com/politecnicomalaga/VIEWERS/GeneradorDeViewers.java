package com.politecnicomalaga.VIEWERS;

public class GeneradorDeViewers {

    public Interface_DataViewer getViewerPorString(String viewer){
        switch (viewer){
            case "text":
                return new TextDataViewer();
            case "html":
                return new HTMLDataViewer();
        }
        return new TextDataViewer();
    }
}
