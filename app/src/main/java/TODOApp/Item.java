package TODOApp;

public class Item {
		private String todo;
		private String status;

		public Item(String todo) {
			this.todo = todo;
			this.status = "N";
		}

		public Item(String todo, String status) {
			this.todo = todo;
			this.status = status;
		}

		public void setTodo(String todo) {
			this.todo = todo;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getTodo() {
			return todo;
		}
		public String getStatus() {
			return status;
		}
}

