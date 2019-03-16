/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Title: Sort directory
 * Semester: COP3337 – Summer 2017
 *
 * @author Serge Metellus
 *
 * I affirm that this program is entirely my own work and none of it is the work
 * of any other person.
 *
 * This program reads a file containing a list of directories and sorts the directories by 
 * comparing the alpha characters as strings and the numeric values of the digits
 */

package directory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Surge
 */
public class Directory {

    String[] dirs;
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException 
    {
        Directory obj = new Directory();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filename;
        System.out.println("Enter name of the file: ");
       filename = br.readLine();
        while (!obj.loadDir(filename)) 
        {
            System.out.println("CAnnot read file. Enter new filename: ");
            filename = br.readLine();
 
        }
        
        obj.sort();
        obj.print();
    }

    private boolean loadDir(String filename) 
    {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            int n = 0;
            while (br.readLine() != null) {
                n++;
            }
            dirs = new String[n];
            br = new BufferedReader(new FileReader(filename));
            String line;
            n = 0;
            while ((line = br.readLine()) != null) {
                dirs[n++] = line;
            }
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Directory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Directory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    private void sort() {
        String tmp;
        for (int i = 0; i < dirs.length; i++) {
            for (int j = 0; j < dirs.length - i - 1; j++) {
                int a = 0, b = 0, pos = 0;
                //NOTE: 25 = 5 + 20 = 5*10^0 + 2*10^1
                for (int k = dirs[j].length() - 1; k >= 0; k--) //extract the number from the right end of the string
                {
                    if (dirs[j].charAt(k) >= '0' && dirs[j].charAt(k) <= '9') {
                        a += (dirs[j].charAt(k) - '0') * Math.pow(10, pos++);
                    } else {
                        break;
                    }
                }

                pos = 0; //reset pos which take care of the power

                for (int k = dirs[j + 1].length() - 1; k >= 0; k--) // repeat for j + 1 th string
                    {
                    if (dirs[j + 1].charAt(k) >= '0' && dirs[j + 1].charAt(k) <= '9')
                    {
                        b += (dirs[j + 1].charAt(k) - '0') * Math.pow(10, pos++);
                    } 
                    else
                    {
                        break;
                    }
                }
                if (a > b) {
                    tmp = dirs[j];
                    dirs[j] = dirs[j + 1];
                    dirs[j + 1] = tmp;
                }
            }
        }
    }

    private void print() {
        for (int i = 0; i < dirs.length; i++) {
            System.out.println(dirs[i]);
        }
    }
    }
    

