package br.ufes.inf.prog3.jjmuliana.trab1;

import java.util.Scanner;
import java.io.File;

public class FilePath {

    private String fp; /* folder path */
    private String fn; /* file name */
    private String path; /* file path */
    private File file; /* file pointer */
    private boolean hf = true; /* if file path is available */

    public FilePath(String folder_path, String file_name) {

        this.fp = folder_path;
        this.fn = file_name;

    
        // Creating a file path based on the given information.
        StringBuilder sb = new StringBuilder();
        sb.append(fp).append(fn);
        String file_path = sb.toString();

        // Defining the file path.
        this.path = file_path;

        // Error handling.
        try {
            file = new File(file_path);
        } catch(Exception e) {
            hf = false; /* there is no file in the given path */
        }

    }

    public FilePath(Scanner sc) {

        this(sc.nextLine(), sc.nextLine());

    }

    public boolean hasFile() {

        return hf;

    }

    public File getFile() {

        return file;

    }

    @Override
    public String toString() {

        return path;

    }

}