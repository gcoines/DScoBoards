/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.Utils.Files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author german
 */
public class FileManager {

    public static File createFile(InputStream inputStream, String fileName) {
        File file = null;
        try {
            file = new File(fileName);
            OutputStream outputStream = new FileOutputStream(file);

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

            inputStream.close();
            outputStream.flush();
            outputStream.close();
        } catch (Exception ex) {
            //TODO trace error
            System.out.println("Cause: " + ex.getCause() + " Message: " + ex.getMessage());
        }
        return file;
    }
}
