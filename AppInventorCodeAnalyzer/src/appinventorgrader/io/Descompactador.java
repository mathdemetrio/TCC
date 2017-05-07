/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appinventorgrader.io;

/**
 *
 * @author Matheus Demetrio
 */
/**
 * Código baseado em: http://www.journaldev.com/960/java-unzip-file-example
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Descompactador {

    public static List<String> unZip(String zipFilePath, String destDir) {
        List<String> listaBky = new ArrayList<>();
        File dir = new File(destDir);

        // create output directory if it doesn't exist
        if (!dir.exists()) {
            dir.mkdirs();
        }
        FileInputStream fis;
        //buffer for read and write data to file
        byte[] buffer = new byte[1024];
        try {
            fis = new FileInputStream(zipFilePath);
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry ze = zis.getNextEntry();
            while (ze != null) {
                String fileName = ze.getName();
                String ext = fileName.substring(fileName.lastIndexOf("."), fileName.length());
                
                //just extract .bky files
                if (ext.equalsIgnoreCase(".bky")) {

                    String nameBky = fileName.substring(fileName.lastIndexOf("/"), fileName.length());

                    File newFile = new File(destDir + File.separator + nameBky);
                    listaBky.add(newFile.getPath());
                    System.out.println("Unzipping to " + newFile.getAbsolutePath());
                    
                    //create directories for sub directories in zip
                    //new File(newFile.getParent()).mkdirs();
                    
                    FileOutputStream fos = new FileOutputStream(newFile);
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                    fos.close();

                }

                //close this ZipEntry
                zis.closeEntry();
                ze = zis.getNextEntry();
            }
            //close last ZipEntry
            zis.closeEntry();
            zis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaBky;
    }

}
