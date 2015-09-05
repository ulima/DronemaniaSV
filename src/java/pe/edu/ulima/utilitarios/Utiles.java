/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.ulima.utilitarios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author hquintana
 */
public class Utiles {
    public static String inputStreamToString(InputStream is) throws IOException{
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
	try {
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
		sb.append(line);
            }
	} finally {
            if (br != null) {
                br.close();

            }
        }
        return sb.toString();
    }
}
