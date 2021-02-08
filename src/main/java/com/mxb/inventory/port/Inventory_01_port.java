
// #################################
// 08.10.2020.

// SikuliX, Java
// http://sikulix.com/
// http://sikulix.com/quickstart/
// https://answers.launchpad.net/sikuli

// SikuliX-IDE, Run
// C:\xxx\JDK\bin\java -jar C:\xxx\SIKULIX_IDE\sikulix-2.0.0.jar

// https://github.com/RaiMan/SikuliX1
// Source and target level for Java is version 8 as long as supported by Oracle

// ---------------------------------
// 1) SikuliX Documentation
// http://sikulix-2014.readthedocs.org/en/latest/index.html
// Be aware: The online javadocs are created from the latest nightly builds.

// Try the Table of Contents
// https://sikulix-2014.readthedocs.io/en/latest/toc.html

// Look through the Index
// https://sikulix-2014.readthedocs.io/en/latest/genindex.html

// Use the Search Page
// https://sikulix-2014.readthedocs.io/en/latest/search.html

// ---------------------------------
// 2) SikuliX Documentation (built-in class)
// Look through the Index:
// https://sikulix-2014.readthedocs.io/en/latest/genindex.html

// (built-in class) :
// https://sikulix-2014.readthedocs.io/en/latest/appclass.html#App
// https://sikulix-2014.readthedocs.io/en/latest/screen.html#Screen
// https://sikulix-2014.readthedocs.io/en/latest/pattern.html#Pattern
// https://sikulix-2014.readthedocs.io/en/latest/keys.html#Key
// https://sikulix-2014.readthedocs.io/en/latest/region.html#Region
// https://sikulix-2014.readthedocs.io/en/latest/match.html#Match

// https://sikulix-2014.readthedocs.io/en/latest/finder.html#Finder.find

// image-search-path
// https://sikulix-2014.readthedocs.io/en/latest/scripting.html#image-search-path-where-sikulix-looks-for-image-files

// FindFailed
// https://sikulix-2014.readthedocs.io/en/latest/region.html?highlight=FindFailed#exception-findfailed

// https://sikulix-2014.readthedocs.io/en/latest/region.html#extracting-text-from-a-region

// import org.sikuli.script.Pattern;   # SikuliX, Java

// ---------------------------------
// 3) SikuliX Documentation (other)

// https://sikulix-2014.readthedocs.io/en/latest/region.html#Region.findAll
// https://sikulix-2014.readthedocs.io/en/latest/match.html#iteratingmatches

// https://stackoverflow.com/questions/47467133/how-to-check-in-sikuli-that-image-is-exist-in-screen-or-not-and-perform-if-else
// Because that will return a "match" object.

// https://stackoverflow.com/questions/811851/how-do-i-read-input-character-by-character-in-java
// http://eugenesautomation.blogspot.com/2015/01/optimizing-pattern-matching-using-sikuli_21.html

// ---------------------------------
// 4) SikuliX issues

// SikuliX 2.0.2:  screen.Paste and Key. dont work
// https://github.com/RaiMan/SikuliX1/issues/305
// https://github.com/RaiMan/SikuliX1/issues/241
// As long as English (United States) is in my language list, it works fine.

// -->
// Settings.AutoDetectKeyboardLayout = false;

// ---------------------------------
// 5) QUICKSTART

// https://sikulix-2014.readthedocs.io/en/latest/faq/030-java-dev.html
// http://www.gofreetodream.com/java-sikulix-windows-mac/java-sikulix-example-on-windows-machine/
// https://javapointers.com/tutorial/sikuli/sikuli-java-tutorial-and-example/

// ---------------------------------
// 6) JAVA

// https://kodejava.org/how-do-i-load-file-from-resources-directory/
// https://www.geeksforgeeks.org/throw-throws-java/
//
// https://www.baeldung.com/java-current-directory
// Get the Current Working Directory in Java | Baeldung

// https://www.baeldung.com/java-system-exit
// System.exit(0);


// ---------------------------------
// 7) SikuliX OCR

// https://sikulix-2014.readthedocs.io/en/latest/textandocr.html#textandocr
// Simply start using the text/OCR features with Region or Image (see the summary below).

// https://github.com/RaiMan/SikuliX1/wiki/How-to-get-the-best-from-OCR-and-text-features

// https://github.com/tesseract-ocr/tesseract
// https://mvnrepository.com
// tess4j

// https://sikulix-2014.readthedocs.io/en/latest/region.html#extracting-text-from-a-region

// import org.sikuli.script.OCR;

// Settings.OcrDataPath = "C:\\xxx\\Tesseract-OCR\\tessdata\\";
// Settings.OcrTextSearch = true;
// Settings.OcrTextRead = true;
// OCR.PSM.SINGLE_WORD; !?

// ---------------------------------
// https://github.com/suniljayaprakash/sikuli-ocr/blob/master/com/nanni/ExtractTextFromImageSikuli.java
// https://github.com/sarxos/sikuli-ocr


// #################################


package com.mxb.inventory.port;

import org.sikuli.basics.Settings;   // SikuliX, Java

// import org.sikuli.script.App;
import org.sikuli.script.Screen;
import org.sikuli.script.Pattern;
import org.sikuli.script.Key;

import org.sikuli.script.Region;
// import org.sikuli.script.Match;

import org.sikuli.script.FindFailed;

// ---------------------------------
// import org.sikuli.script.Finder;
// import org.sikuli.script.ImagePath;

// ---------------------------------
// import java.net.URISyntaxException;
// import java.net.URL;
// import java.net.MalformedURLException;

// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.IOException;

// import java.util.*;
// import java.util.List;
// import java.util.ArrayList;
// import java.util.Iterator;

// ---------------------------------


/**
 * Hello world!
 *
 */

public class Inventory_01_port
{

    // private App myApp;

    private Screen scr;
    private String basePath;

    private String equipment;
    private String slot;
    private String description;

    private Region r1Top_GenID;
    private Region r2Bottom;


    //constructor to initialize the variable
    // https://tom.mcqueeney.tech/blog/the-terribly-misunderstood-super/
    public Inventory_01_port()
    {
        // General Settings and Access to Environment Information
        // https://sikulix-2014.readthedocs.io/en/latest/globals.html
        // Settings.AutoWaitTimeout = 2;  // (default 3 seconds)

        Settings.AutoDetectKeyboardLayout = false;
        scr = new Screen(0);
        scr.setAutoWaitTimeout(120);

        r1Top_GenID = new Region(0,0,1920,180);
        r2Bottom = new Region(0,939,1920,141);

        // https://www.baeldung.com/java-current-directory
        // Get the Current Working Directory in Java | Baeldung
        String currentWorkingDir = System.getProperty("user.dir");
        basePath = currentWorkingDir + "/images/";

    }


    //instance method
    private void startApp() throws FindFailed
    {
        m1MaximizeApp();
        m2OpenSlot();
        m3OpenPort();
    }


    //instance method
    private void m1MaximizeApp() throws FindFailed
    {
        // Java 1.8
        // By default, float numbers are double in java.
        // In order to store them into float variable, you need to explicitly add the suffix 'f' or 'F'.
        // scr.wait(p3Search_For_Path.similar(0.7F));

        try {
            // INV app, Click on the icon
            // Pattern p1AppIcon = new Pattern("C:\\xxx\\INV_01_ikona.png");
            Pattern p1AppIcon = new Pattern(basePath + "p1AppIkona.png");
            r2Bottom.click(p1AppIcon.similar(0.8));

            // myApp = new App("Inventory");
            // myApp.focus();

            // INV app, Wait for it to open
            Pattern p2AppWait = new Pattern(basePath + "p2AppWait.png");
            r1Top_GenID.wait(p2AppWait.similar(0.8));

        } catch(FindFailed e) {
            e.printStackTrace();
            System.out.println("Find failed " + e.getMessage());
            System.exit(1);
        }

    }


    //instance method
    private void m2OpenSlot() throws FindFailed
    {

        try {

            // Čekaj da se otvori INV aplikacija
            Pattern p2AppWait = new Pattern(basePath + "p2AppWait.png");
            r1Top_GenID.wait(p2AppWait.similar(0.8));

            // INV: Equipment - Slot/Card
            scr.type("o", Key.ALT);  // Menu - Object
            scr.wait(0.1);   // wait 0.1 seconds
            scr.type("e"); // Equipment
            scr.wait(0.1);
            scr.type("a"); // Slot/Card
            scr.wait(0.1);

            // INV - Equipment - Slot/Card, Wait on
            Pattern p3EquipSlotSearch = new Pattern(basePath + "p3EquipSlotSearch.png");
            scr.wait(p3EquipSlotSearch.similar(0.7));

// ---------------------------------
            // Pattern p4SlotClearAll = new Pattern(basePath + "p4SlotClearAll.png");
            // final Match match = scr.exists(p4SlotClearAll.similar(0.95), 3);

            // if(match != null)
            // {
            //     match.highlight(2);
            //     scr.type(Key.F5);   // Clear All
            //     scr.waitVanish(p4SlotClearAll.similar(0.95));
            // }

// -----------------------------------
            // Slot - type
            scr.click(p3EquipSlotSearch.targetOffset(100, 42));
            // s.wait(0.5);
            scr.wait(0.1);

            scr.type("a", Key.CTRL);
            scr.wait(0.1);
            scr.type(Key.DELETE);
            scr.wait(0.1);

            scr.paste(slot);
            // s.wait(0.5);
            scr.wait(0.1);

// -----------------------------------
            // Equipment ID
            scr.hover(p3EquipSlotSearch.targetOffset(100, 108));
            scr.click(p3EquipSlotSearch.targetOffset(100, 108));
            scr.wait(0.1);   // wait 0.1 seconds

            scr.type("a", Key.CTRL);
            scr.wait(0.1);   // wait 0.1 seconds
            scr.type(Key.DELETE);
            scr.wait(0.1);

            scr.paste(equipment);
            // s.wait(0.5);
            scr.wait(0.1);
            // scr.waitVanish(p3EquipSlotSearch.similar(0.7));

// -----------------------------------


            // INV: binoculars (find a slot!)
            // s.type("f", Key.CTRL);  // Begin Search
            Pattern p5Dvogled = new Pattern(basePath + "p5Dvogled.png");
            r1Top_GenID.click(p5Dvogled.similar(0.85));
            scr.wait(0.1);

            // INV: open the slot
            Pattern p6EquipSlotPronajden = new Pattern(basePath + "p6EquipSlotPronajden.png");
            scr.wait(p6EquipSlotPronajden.similar(0.7));
            scr.hover(p6EquipSlotPronajden.similar(0.7).targetOffset(100, 50));
            scr.doubleClick(p6EquipSlotPronajden.similar(0.7).targetOffset(100, 50));


        } catch(FindFailed e) {
            // e.printStackTrace();
            System.out.println("Find failed " + e.getMessage());

        } catch(Exception e) {
            // e.printStackTrace();
            System.out.println("Some other exception occured " + e.getMessage());

        }


    }


    //instance method
    private void m3OpenPort() throws FindFailed
    {

        try {

            // INV: sPort
            Pattern p7Port_opened = new Pattern(basePath + "p7PortOtvoren.png");
            scr.wait(p7Port_opened.similar(0.7));
            scr.type("m", Key.CTRL);  // Modify

            scr.setAutoWaitTimeout(3);
            // Settings.AutoWaitTimeout = 3;  // (default 3 seconds)

            Pattern p8PortModify = new Pattern(basePath + "p8PortModify.png");
            scr.wait(p8PortModify.similar(0.7));

            // INV: Port Status
            scr.click(p8PortModify.targetOffset(170, 40));
            scr.wait(0.5);    // wait 0.5 seconds
            // s.wait(0.1);
            scr.type(Key.HOME);
            scr.wait(0.5);
            scr.type("r"); // Rezerviran (Reserved)
            scr.wait(0.5);
            scr.type(Key.ESC);
            // s.wait(0.1);
            scr.wait(0.5);

            // INV: Port, odaberi Suplemental info
            scr.click(p7Port_opened.targetOffset(-180, 600));
            scr.wait(0.1);
            scr.type(Key.HOME);
            // s.type("s");
            scr.wait(0.5);


            // INV: Port Desciption
            Pattern p9SuplementalInfo = new Pattern(basePath + "p9SuplementalInfo.png");
            scr.wait(p9SuplementalInfo.similar(0.7));
            scr.click(p9SuplementalInfo.targetOffset(350, 125));
            scr.wait(0.1); // čekaj 0.1 sekundi

            scr.type("a", Key.CTRL);  // Select all
            scr.wait(0.1);
            scr.type(Key.DELETE);
            scr.wait(0.5);
            scr.paste(description);
            // s.type("hello!");


        } catch(FindFailed e) {
            e.printStackTrace();

        }

	}


    //this is a static method and cannot call an instance method without a object
    public static void main(String[] args) throws FindFailed
    {
        System.out.println( "Hello World!" );

        //create instance of object
        Inventory_01_port portPortObj = new Inventory_01_port();

        // Windows bat file (Look at the end!)
        // set EQUIPMENT=%1
        // set SLOT=%2
        // set DESCRIPTION=%3

        // String equipment = "xxx";
        // String slot = "xxx";
        portPortObj.equipment = args[0].toString();
        portPortObj.slot = args[1].toString();
        portPortObj.description = args[2].toString();

        portPortObj.startApp();

    }


}


// Windows bat file
// Run_inventory_01_port.bat
//
// -------------------------------------------------------------
// set EQUIPMENT=%1
// set SLOT=%2
// set DESCRIPTION=%3

// :: Change Current Directory to the location of this batch file
// :: http://ss64.com/nt/cd.html
// CD /d "%~dp0"

// :: Open the command prompt, and type command (CMD /k for development)
// :: http://ss64.com/nt/cmd.html

// :: https://ss64.com/nt/syntax-args.html
// :: ---------------------------------
// :: All parameters:
// :: CMD /c %JAVA_HOME%bin\java -cp Inventory_01_port_port-1.0-SNAPSHOT.jar;dependency112/* com.mxb.inventory.Inventory_01_port_port %*

// :: ---------------------------------
// :: Development :
// :: CMD /k C:\xxx\JDK\bin\java -cp Inventory_01_port-1.0-SNAPSHOT.jar;dependency204/* com.mxb.inventory.port.Inventory_01_port %EQUIPMENT% %SLOT% %DESCRIPTION%

// CMD /c C:\xxx\JDK\bin\java -cp Inventory_01_port-1.0-SNAPSHOT.jar;dependency204/* com.mxb.inventory.port.Inventory_01_port %EQUIPMENT% %SLOT% %DESCRIPTION%

