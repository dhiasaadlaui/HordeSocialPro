/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.util;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;

/**
 *
 * @author Dhia
 */
public class ServiceImageUpload {

    /**
     *
     * the php service url that contains this coe below
     * <?php
     * $target_dir = "images/";
     * $uploadfile = $target_dir . basename($_FILES["image"]["name"]);
     * move_uploaded_file($_FILES['image']['tmp_name'], $uploadfile)
     *?>
     *
     */
    public static final String URL = "http://localhost/pidev/services/uploadImage.php";

    /**
     *
     * Append the image full name to this url to get the image from server
     */
    //  public static final String IMAGES_RESOURCES = "http://localhost/pidev/services/images/";
    /**
     *
     * @param file
     * @param fileName
     * @return the new name of the uploaded file
     * @throws MalformedURLException
     * @throws IOException
     */
    public static String sendFileToHTTP(File file, String fileName) throws MalformedURLException, IOException {

        String newName = fileName + file.getName().substring(file.getName().indexOf("."));

        String charset = "UTF-8";

        String boundary = Long.toHexString(System.currentTimeMillis()); // Just generate some unique random value.
        String CRLF = "\r\n"; // Line separator required by multipart/form-data.

        URLConnection connection = new URL(URL).openConnection();
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

        try (
                OutputStream output = connection.getOutputStream();
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(output, charset), true);) {

            // Send  file.
            writer.append("--" + boundary).append(CRLF);
            writer.append("Content-Disposition: form-data; name=\"" + "image" + "\"; filename=\"" + newName + "\"").append(CRLF);
            writer.append("Content-Type: text/html; charset=UTF-8 ").append(CRLF);

            writer.append(CRLF).flush();
            Files.copy(file.toPath(), output);
            output.flush(); // Important before continuing with writer!
            writer.append(CRLF).flush(); // CRLF is important! It indicates end of boundary.

            // End of multipart/form-data.
            writer.append("--" + boundary + "--").append(CRLF).flush();
        }

// Request is lazily fired whenever you need to obtain information about response.
        int responseCode = ((HttpURLConnection) connection).getResponseCode();
        System.out.println(responseCode); // Should be 200
        return (newName);
    }

}
