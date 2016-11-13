package maven.exercise.bootCampTopic2ex1;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;




public class Exercise1Test {


	@Test
	public void firstRun() {
		assertTrue(Exercise1.getRecentFileList().isEmpty());
		System.out.println("");
		System.out.println("Test 1: First Run");
	    Exercise1.showRecentFileList();
	}
	

	
	@Test	
	public void openFile() throws IOException {
		 System.out.println("");
		 System.out.println("Test 2: Add File To Recent File List");	 		
		 File objetofile = new File ("Contacts.txt");		 
		 String fileOpened= objetofile.getName();
		 Exercise1.addElementToList(fileOpened);
		 /*Only one file is opened, so size must be 1*/
		 assertTrue(Exercise1.getRecentFileList().size()==1);
		 /*First file in the list must be the last one opened*/
		 assertTrue(Exercise1.getRecentFileList().get(0).equals("Contacts.txt"));
		 Exercise1.showRecentFileList();
	}
	
	@Test	
	public void openFileWhichIsInTheList() throws IOException {
		 ArrayList<String> list= new ArrayList<String>(Arrays.asList("Notes.txt", "Clients.pdf", "Queen - We will Rock You.mp3", "Contacts.txt","Calendar.txt"));
		 Exercise1.setRecentFileList(list);
		 System.out.println("");
		 System.out.println("Test 3: If file opened is in the list");
		 int sizeBefore = Exercise1.getRecentFileList().size();
		 System.out.println("Before:");
		 Exercise1.showRecentFileList();
		 File objetofile = new File ("Contacts.txt");		 
		 String fileOpened= objetofile.getName();
		 Exercise1.addElementToList(fileOpened);
		 int sizeAfter = Exercise1.getRecentFileList().size();
		 /*Size must be the same before and after, because the file was already on the list */
		 assertTrue(sizeBefore==sizeAfter);
		 /*First file in the list must be the last one opened*/
		 assertTrue(Exercise1.getRecentFileList().get(0).equals("Contacts.txt"));
		 System.out.println("After:");
		 Exercise1.showRecentFileList();
	}
	
	@Test
	public void openFileAndRecentFileListIsFull() throws IOException {
		 ArrayList<String> list= new ArrayList<String>(Arrays.asList("File 1", "File 2", "File 3", "File 4", "File 5", "File 6", "File 7", "File 8", "File 9", "File 10", "File 11", "File 12", "File 13", "File 14", "This file shouldn't appear after"));
		 Exercise1.setRecentFileList(list);
		 System.out.println("");
		 System.out.println("Test 4: Recent File List is full");	 
		 System.out.println("Before:");
		 Exercise1.showRecentFileList();		 
		 String fileOpened;			 
		 File objetofile = new File ("Contacts.txt");		 
		 fileOpened= objetofile.getName();
		 Exercise1.addElementToList(fileOpened);
		 /*Recent file list is full, so size must be 15*/
		 assertTrue(Exercise1.getRecentFileList().size()==15);
		 /*First file in the list must be the last one opened*/
		 assertTrue(Exercise1.getRecentFileList().get(0).equals("Contacts.txt"));
		 System.out.println("After:");
		 Exercise1.showRecentFileList();
	}
	
	


}
