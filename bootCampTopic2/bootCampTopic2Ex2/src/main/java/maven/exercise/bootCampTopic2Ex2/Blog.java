package maven.exercise.bootCampTopic2Ex2;

import java.util.ArrayList;



public class Blog {
		private static Blog blog = null;
		private static ArrayList<Entry> entries = new ArrayList<Entry>();
		
		
		private Blog(){
		}
		
		public static Blog getInstance() {
			if (blog == null) {
				blog = new Blog();
			}
			return blog;
		}
		
		
		public void newEntry(Entry entry){
			entries.add(0,entry);
		}
		
		public void deleteEntry(String title){
			
			for (Entry i: entries){		
				if (i.getTitle().equals(title)){
					entries.remove(i);
					System.out.println("Entry " + title + " deleted");
					break;	
				}				
			}
			
			
		}
		
		public void showRecentEntries(){
			System.out.println("Recent entries list:");
			for (int i=0;i<10;i++){
				String title=entries.get(i).getTitle();
				String text=entries.get(i).getText();
				System.out.println((i+1)+". Title: " + title + "    Text: " + text);
			}
		}
		
		
		
}
