package maven.exercise.bootCampTopic2Ex2;


import java.io.IOException;
import org.junit.Before;
import org.junit.Test;


public class BlogTest{

	
	
	@Before
	public void setUp() throws Exception {
		
		Blog.getInstance().newEntry(new Entry("Title 1", "This is entry number one - this entry should not appear in the recent entries list (only when a entry is removed)"));
		Blog.getInstance().newEntry(new Entry("Title 2", "This is entry number two"));
		Blog.getInstance().newEntry(new Entry("Title 3", "This is entry number three"));
		Blog.getInstance().newEntry(new Entry("Title 4", "This is entry number four"));
		Blog.getInstance().newEntry(new Entry("Title 5", "This is entry number five"));
		Blog.getInstance().newEntry(new Entry("Title 6", "This is entry number six"));
		Blog.getInstance().newEntry(new Entry("Title 7", "This is entry number seven"));
		Blog.getInstance().newEntry(new Entry("Title 8", "This is entry number eight"));
		Blog.getInstance().newEntry(new Entry("Title 9", "This is entry number nine"));
		Blog.getInstance().newEntry(new Entry("Title 10", "This is entry number ten"));
		Blog.getInstance().newEntry(new Entry("Title 11", "This is entry number eleven"));
	
		
	}


	@Test	
	public void addEntry() throws IOException {	
		 System.out.println("");
		 System.out.println("Test 1: Post new entry");
		 Blog.getInstance().newEntry(new Entry ("New entry","This is a new entry"));
		 Blog.getInstance().showRecentEntries();
	}
	
	@Test	
	public void deleteEntry() throws IOException {		
		 System.out.println("");
		 System.out.println("Test 2: Delete existing entry");
		 Blog.getInstance().deleteEntry("Title 5");
		 Blog.getInstance().showRecentEntries();
	}
	
	@Test
	public void showRecentEntries() throws IOException{
		 System.out.println("");
		 System.out.println("Test 3: Show recent entries");
		 Blog.getInstance().showRecentEntries();
	}
	
	

}
