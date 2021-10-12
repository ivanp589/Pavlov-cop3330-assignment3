package ex43;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

import static ex41.nameSort.checkForError;
import static java.lang.System.out;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 ivan pavlov
 */

public class WebsiteMaker {
    Scanner in = new Scanner(System.in);

    //ask forthe name of the site, the author and if files should be created
    //at the very least create a website with the name being the name given and the
    //meta content being the author
    //if necessary create those files in a location easilty found
    public static void main(String[] args) throws IOException {
        WebsiteMaker ask = new WebsiteMaker();
        //could be simplified using in.nextline() instead of calling input()
        ask.name();
        String name = ask.input();
        ask.author();
        String author = ask.input();
        ask.files();
        String files = ask.input();
        //check if files need to be made
        boolean checkFiles = checkIftrue(files);
        ask.folder();
        String folder = ask.input();
        //check if files need to be made
        boolean checkFolder = checkIftrue(folder);
        createWebsite(name,author,checkFiles,checkFolder);
    }
    //make the proper string to call the website and the files that will be subsequently created
    //open a new file using those names
    public static void createWebsite(String name, String author, boolean checkFiles, boolean checkFolder) throws IOException {
        String webFolder = String.format("%s",name);
        File file = new File(webFolder);
        String Directory = System.getProperty("user.dir");
        out.println("Created "+webFolder);
        file.mkdir();

        String created = createhtmlFile(name,author);
        checkForError(created);
        if(checkFiles){
            createFolder(Directory,name,"js");
        }
        if(checkFolder){
            createFolder(Directory,name,"css");
        }
    }
    //given the name provided create a folder for the files
    //in a specific location
    private static void createFolder(String Directory, String websiteName, String folderName) {
        String web = String.format("%s/%s/%s", Directory,websiteName, folderName);
        File js = new File(web);
        out.println("Created "+web);
        js.mkdir();
    }
    //given the name that was provided create the file in a specific location
    //create a new file and write to it for the website.html
    private static String createhtmlFile(String name, String author) throws IOException{
        String site = String.format("%s/index.html",name);
        File file = new File(site);
        out.println("Created "+site);
        FileWriter filewriter = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(filewriter);
        try {
            bw.write(String.format("<html><title> %s </title><meta name=%s content=%s></html>", name, "author", author));
            bw.close();
            return "File created";
        }catch (Exception e) {e.printStackTrace();
        return "File not created";}
    }

    private void folder(){
        out.println("Do you want a folder for CSS (y/n)? ");
    }

    public static boolean checkIftrue(String files){
        return Objects.equals(files, "y");
    }

    private void files() {
        out.println("Do you want a folder for JavaScript files (y/n)? ");
    }

    private String input() {
        return in.nextLine();
    }

    private void name() {
        out.println("What is the name of the website? ");
    }
    private void author() {
        out.println("Who is the author of the website? ");
    }

}
