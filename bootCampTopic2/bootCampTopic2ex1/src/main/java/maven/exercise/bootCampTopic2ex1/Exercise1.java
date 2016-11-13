package maven.exercise.bootCampTopic2ex1;

import java.util.ArrayList;

public class Exercise1 {
	
	private static  ArrayList<String> recentFileList = new ArrayList<String>();

	public static ArrayList<String> getRecentFileList() {
		return recentFileList;
	}

	public static void setRecentFileList(ArrayList<String> recentFileList) {
		Exercise1.recentFileList = recentFileList;
	}

	public static void addElementToList(String element){		
		if (recentFileList.contains(element)){
			recentFileList.remove(element);
			recentFileList.add(0,element);			
		} else {
			recentFileList.add(0,element);
		}
		if (recentFileList.size()>15){
			recentFileList.remove(15);
		}	
		System.out.println("File "+ element + " added to recent file list");
	}
	public static void showRecentFileList(){
		int i = 1;
		if (recentFileList.size()==0){
			System.out.println("Recent file list is empty");
		} else {
			System.out.println("Recent file list:");	
			for(String name : recentFileList){
			System.out.println("File " + i++ +": " + name);
			
			}			
		}
		
		
	}

}
