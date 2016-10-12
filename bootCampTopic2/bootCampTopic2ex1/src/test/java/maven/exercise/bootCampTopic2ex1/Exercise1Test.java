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
		 String fileOpened;		
		 File objetofile = new File ("Contacts.txt");		 
		 fileOpened= objetofile.getName();
		 Exercise1.addElementToList(fileOpened);
		 Exercise1.showRecentFileList();
	}
	
	@Test	
	public void openFileWhichIsInTheList() throws IOException {
		 ArrayList<String> list= new ArrayList<String>(Arrays.asList("Notes.txt", "Clients.pdf", "Queen - We will Rock You.mp3", "Contacts.txt","Calendar.txt"));
		 Exercise1.setRecentFileList(list);
		 System.out.println("");
		 System.out.println("Test 3: If file opened is in the list");
		 System.out.println("Before:");
		 Exercise1.showRecentFileList();
		 String fileOpened;		
		 File objetofile = new File ("Contacts.txt");		 
		 fileOpened= objetofile.getName();
		 Exercise1.addElementToList(fileOpened);
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
		 System.out.println("After:");
		 Exercise1.showRecentFileList();
	}
	
	


}
