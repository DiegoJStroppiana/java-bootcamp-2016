package maven.exercise.bootCampTopic2Ex2;

public class Entry {
		private String title;
		private String text;
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		public Entry(){
		}

		public Entry(String title, String text){
			this.setTitle(title);
			this.setText(text);
		}
		
}
