package com.company;

import java.io.IOException;
import java.io.PrintWriter;

@SaverTo(path = "text.txt")
public class TextContainer {
    public String text = "Hello world!!!";

    public TextContainer() {
    }

    public TextContainer (String text) {
        this.text = text;
    }

    @Saver
    public void save (String path) throws IOException {
        PrintWriter pw = new PrintWriter(path);
        pw.write(text);
        pw.close();
    }
}
